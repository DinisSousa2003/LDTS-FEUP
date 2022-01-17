package Tetris.states;

import Tetris.controller.Controller;
import Tetris.controller.GameController;
import Tetris.model.game.Screen;
import Tetris.viewer.GameViewer;
import Tetris.viewer.Viewer;

public class GameState extends State<Screen> {
    public GameState(Screen screen) {super(screen);}

    @Override
    protected Viewer<Screen> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Screen> getController() {
        return new GameController(getModel());
    }
}