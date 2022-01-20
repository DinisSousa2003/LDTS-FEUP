package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.EndGame;
import Tetris.model.Position;
import Tetris.model.game.Screen;

import java.io.IOException;

public class EndGameViewer extends Viewer<EndGame> {

    public EndGameViewer(EndGame endGame){
        super(endGame);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        drawElements(gui);
        gui.refresh();
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        for(int i = 5;i < 17;i++) {
            for(int j = 8;j <13;j++ ) {
                gui.drawSquare(new Position(i, j), color.getColor("BLACK"));
            }
        }

        gui.drawText(new Position(6, 9), "G", color.getColor("RED"));
        gui.drawText(new Position(7, 9), "A", color.getColor("ORANGE"));
        gui.drawText(new Position(8, 9), "M", color.getColor("YELLOW"));
        gui.drawText(new Position(9, 9), "E ", color.getColor("GREEN"));
        gui.drawText(new Position(11, 9), "O", color.getColor("CYAN"));
        gui.drawText(new Position(12, 9), "V", color.getColor("PURPLE"));
        gui.drawText(new Position(13, 9), "E", color.getColor("RED"));
        gui.drawText(new Position(14, 9), "R", color.getColor("ORANGE"));

        gui.drawText(new Position(9, 11),getModel().getEntryName(),color.getColor("RED"));
    }
}
