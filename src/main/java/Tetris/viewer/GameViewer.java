package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.game.Game;

import java.io.IOException;

public class GameViewer extends Viewer<Game> {
    public GameViewer(Game game){
        super(game);
    }

    @Override
    //TODO: DRAW THE MODEL OBJECTS ON THE INTERFACE
    protected void drawElements(GUI gui) throws IOException {
        ;
    }
}
