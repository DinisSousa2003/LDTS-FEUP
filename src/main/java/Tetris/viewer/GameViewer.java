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

        //DRAW QUEUE, BOARD AND TETRIMINO
        gui.drawStats(super.getModel().getStats());
        gui.drawQueue(super.getModel().getQueueOfTetrimino());
        gui.drawBoard(super.getModel().getBoard());
        gui.drawShadowTetrimino(super.getModel().getShadowTetrimino());
        gui.drawTetrimino(super.getModel().getTetrimino());
    }
}
