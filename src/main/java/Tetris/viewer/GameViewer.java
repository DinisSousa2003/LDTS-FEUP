package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.game.Screen;

import java.io.IOException;

public class GameViewer extends Viewer<Screen> {
    public GameViewer(Screen screen){
        super(screen);
    }

    @Override
    //TODO: DRAW THE MODEL OBJECTS ON THE INTERFACE
    protected void drawElements(GUI gui) throws IOException {
        
    }
}
