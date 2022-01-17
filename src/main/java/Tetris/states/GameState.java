package Tetris.states;

import Tetris.controller.Controller;
import Tetris.controller.GameController;
import Tetris.model.Game;
import Tetris.viewer.GameViewer;
import Tetris.viewer.Viewer;

public class GameState extends State<Game> {
    public GameState(Game game) {
        super(game);
    }

    @Override
    protected Viewer<Game> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Game> getController() {
        return new GameController(getModel());
    }
}