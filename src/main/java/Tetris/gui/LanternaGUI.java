package Tetris.gui;

import Tetris.model.Color;
import Tetris.model.Position;
import Tetris.model.game.Block;
import Tetris.model.game.Board;
import Tetris.model.game.QueueOfTetrimino;
import Tetris.model.game.Tetrimino;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static java.awt.Font.MONOSPACED;
import static java.awt.Font.PLAIN;

public class LanternaGUI implements GUI{
    private final Screen screen;
    private final Tetris.model.Color colors = new Color();

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws FontFormatException, IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawSquare(Position position, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), " ");
    }

    //TODO: ADD ACTIONS THAT WILL BE USED DURING GAMEPLAY (IF NEEDED)
    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp || (keyStroke.getKeyType() == KeyType.Character && Character.toLowerCase(keyStroke.getCharacter()) == 'x')) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Character && Character.toLowerCase(keyStroke.getCharacter()) == 'z') return ACTION.Z;
        if (keyStroke.getKeyType() == KeyType.Character && Character.toLowerCase(keyStroke.getCharacter()) == ' ') return ACTION.SPACE;


        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public void drawTetrimino(Tetrimino tetrimino){
        if (tetrimino != null) {
            for (Position position : tetrimino.getActualPositions(tetrimino.getCentralPosition(), tetrimino.getDirection())) {
                drawSquare(new Position(position.getX() + 1, 1 + position.getY()), colors.getColor(tetrimino.getColor()));
            }
        }
    }

    @Override
    public void drawShadowTetrimino(Tetrimino tetrimino){
        if (tetrimino != null) {
            for (Position position : tetrimino.getActualPositions(tetrimino.getCentralPosition(), tetrimino.getDirection())) {
                drawSquare(new Position(position.getX() + 1, 1 + position.getY()), colors.getShadowColor(tetrimino.getColor()));
            }
        }
    }

    @Override
    public void drawBoard(Board board){
        for(int y = 0; y < board.getBoard().length; y++){
            for(int x = 0; x < board.getBoard()[0].length; x++){
                if (board.getBoard()[y][x] != null)
                    drawSquare(new Position(x+1,1+y), colors.getColor(board.getBoard()[y][x].getColor()));
            }
        }
    }

    @Override
    public void drawQueue(QueueOfTetrimino queue){
        for(int i = 14; i<20;i++) {
            for(int j = 10; j < 20;j++) {
                drawSquare(new Position(i, j), colors.getColor("GRAY"));
            }
        }

        for(int i = 11;i <= 17;i+=3) {
            for(int j = 15;j <19;j++ ) {
                drawSquare(new Position(j, i), colors.getColor("DARKER_GRAY"));
                drawSquare(new Position(j, i+1), colors.getColor("DARKER_GRAY"));
            }
            Tetrimino tetrimino = queue.getTetreminoQueue().get((i - 11)/3);
            drawTetriminoPos(tetrimino, new Position(17,  i + 1));
        }
    }

    private void drawTetriminoPos(Tetrimino tetrimino, Position CentralPos){
        if (tetrimino != null) {
            for (Position position : tetrimino.getPositions(tetrimino.getDirection())) {
                drawSquare(new Position(position.getX() + CentralPos.getX(), position.getY() + CentralPos.getY()), colors.getColor(tetrimino.getColor()));
            }
        }
    }
}

