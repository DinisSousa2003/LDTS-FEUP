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
    //TODO: DRAW THE MODEL OBJECTS ON THE INTERFACE
    protected void drawElements(GUI gui) throws IOException {
        for(int i = 0; i < 22; i++) {
            gui.drawSquare(new Position(i, 0), color.getRAINBOW().get(i % 7));
        }

        for(int i = 0; i < 22; i++) {
            gui.drawSquare(new Position(i, 21), color.getRAINBOW().get(i % 7));
        }

        for(int i = 1; i < 21; i++) {
            gui.drawSquare(new Position(0, i), color.getRAINBOW().get(i % 7));
        }

        for(int i = 1; i < 21; i++) {
            gui.drawSquare(new Position(21, i), color.getRAINBOW().get(i % 7));
        }
    }
}
