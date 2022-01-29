package Tetris.controller;

import Tetris.Main;
import Tetris.gui.GUI;
import Tetris.model.endGame.EndGame;
import Tetris.model.menu.Menu;
import Tetris.states.MenuState;

public class EndGameController extends Controller<EndGame> {
    public EndGameController(EndGame endGame) {
        super(endGame);
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.SELECT) main.setState(new MenuState(new Menu()));
    }
}
