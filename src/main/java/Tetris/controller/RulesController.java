package Tetris.controller;

import Tetris.Main;
import Tetris.gui.GUI;
import Tetris.model.rules.Rules;
import Tetris.states.MenuState;
import Tetris.model.menu.Menu;

public class RulesController extends Controller<Rules> {
    public RulesController(Rules rules) {
        super(rules);
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.SELECT) main.setState(new MenuState(new Menu()));
    }
}
