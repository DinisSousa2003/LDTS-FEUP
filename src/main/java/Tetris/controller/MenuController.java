package Tetris.controller;

import Tetris.Main;
import Tetris.gui.GUI;
import Tetris.model.game.Game;
import Tetris.model.menu.Menu;
import Tetris.model.rules.Rules;
import Tetris.states.GameState;
import Tetris.states.RulesState;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) main.setState(null);
                if (getModel().isSelectedPlay()) main.setState(new GameState(new Game()));
                if (getModel().isSelectedRules()) main.setState(new RulesState(new Rules()));
            case QUIT:
                main.setState(null);
        }
    }
}
