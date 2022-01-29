package Tetris.states;

import Tetris.controller.Controller;
import Tetris.controller.EndGameController;
import Tetris.model.endGame.EndGame;
import Tetris.viewer.EndGameViewer;
import Tetris.viewer.Viewer;

public class EndGameState extends State<EndGame> {

    public EndGameState(EndGame endGame) {super(endGame);}

    @Override
    protected Viewer<EndGame> getViewer() {
        return new EndGameViewer(getModel());
    }

    @Override
    protected Controller<EndGame> getController() {
        return new EndGameController(getModel());
    }
}
