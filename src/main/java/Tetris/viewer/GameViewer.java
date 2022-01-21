package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.game.Screen;

import java.io.IOException;

public class GameViewer extends Viewer<Screen> {
    public GameViewer(Screen screen){
        super(screen);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        //CONTOUR FOR GAME
        for(int i = 0; i < 12; i++) {
            gui.drawSquare(new Position(i, 0), color.getColor("LIGHT_GRAY"));
        }

        for(int i = 0; i < 12; i++) {
            gui.drawSquare(new Position(i, 21), color.getColor("LIGHT_GRAY"));
        }

        for(int i = 1; i < 21; i++) {
            gui.drawSquare(new Position(0, i), color.getColor("LIGHT_GRAY"));
        }

        for(int i = 1; i < 21; i++) {
            gui.drawSquare(new Position(11, i), color.getColor("LIGHT_GRAY"));
        }

        //STATS
        gui.drawText(new Position(14, 1), "P", color.getColor("RED"));
        gui.drawText(new Position(15, 1), "O", color.getColor("ORANGE"));
        gui.drawText(new Position(16, 1), "I", color.getColor("YELLOW"));
        gui.drawText(new Position(17, 1), "N", color.getColor("GREEN"));
        gui.drawText(new Position(18, 1), "T", color.getColor("BLUE"));
        gui.drawText(new Position(19, 1), "S", color.getColor("PURPLE"));

        gui.drawText(new Position(15, 3), "0000", color.getColor("WHITE"));

        gui.drawText(new Position(13, 5), "LEVEL", color.getColor("YELLOW"));
        gui.drawText(new Position(20, 5), "0", color.getColor("WHITE"));

        gui.drawText(new Position(13, 7), "LINES", color.getColor("YELLOW"));
        gui.drawText(new Position(19, 7), "00", color.getColor("WHITE"));

        //DRAW QUEUE, BOARD AND TETRIMINO
        gui.drawQueue(super.getModel().getQueueOfTetrimino());
        gui.drawBoard(super.getModel().getBoard());
        gui.drawShadowTetrimino(super.getModel().getShadowTetrimino());
        gui.drawTetrimino(super.getModel().getTetrimino());
    }
}
