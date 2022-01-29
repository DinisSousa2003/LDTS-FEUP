package Tetris.gui;

import Tetris.model.Color;
import Tetris.model.Position;
import Tetris.model.game.*;
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
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI{
    private final Screen screen;
    private final Tetris.model.Color colors = new Color();

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
        ((AWTTerminalFrame) terminal).setTitle("--TETRIS--");
        ((AWTTerminalFrame) terminal).setIconImage(ImageIO.read(getClass().getClassLoader().getResource("tetris.jpg")));
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws FontFormatException, IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
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
    @Override
    public void drawOutLine(){
        for(int i = 0; i < 22; i++) {
            drawSquare(new Position(i, 0), colors.getRAINBOW().get(i % 7));
            drawSquare(new Position(i, 21), colors.getRAINBOW().get(i % 7));
        }
        for(int i = 1; i < 21; i++){
            drawSquare(new Position(0, i), colors.getRAINBOW().get(i % 7));
            drawSquare(new Position(21, i), colors.getRAINBOW().get(i % 7));
        }
    }

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

    @Override
    public void drawStats(Stats stats) {
        drawText(new Position(14, 1), "P", colors.getColor("RED"));
        drawText(new Position(15, 1), "O", colors.getColor("ORANGE"));
        drawText(new Position(16, 1), "I", colors.getColor("YELLOW"));
        drawText(new Position(17, 1), "N", colors.getColor("GREEN"));
        drawText(new Position(18, 1), "T", colors.getColor("BLUE"));
        drawText(new Position(19, 1), "S", colors.getColor("PURPLE"));

        drawText(new Position(15, 3), String.format("%04d", stats.getPoints()), colors.getColor("WHITE"));

        drawText(new Position(13, 5), "LEVEL", colors.getColor("YELLOW"));
        drawText(new Position(20, 5), String.format("%01d", stats.getLevel()), colors.getColor("WHITE"));

        drawText(new Position(13, 7), "LINES", colors.getColor("YELLOW"));
        drawText(new Position(19, 7), String.format("%02d", stats.getLines()), colors.getColor("WHITE"));
    }

    private void drawTetriminoPos(Tetrimino tetrimino, Position CentralPos){
        if (tetrimino != null) {
            for (Position position : tetrimino.getPositions(tetrimino.getDirection())) {
                drawSquare(new Position(position.getX() + CentralPos.getX(), position.getY() + CentralPos.getY()), colors.getColor(tetrimino.getColor()));
            }
        }
    }
}
