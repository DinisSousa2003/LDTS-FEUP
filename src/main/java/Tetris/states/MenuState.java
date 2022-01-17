package Tetris.states;

import Tetris.controller.Controller;
import Tetris.controller.MenuController;
import Tetris.model.menu.Menu;
import Tetris.viewer.MenuViewer;
import Tetris.viewer.Viewer;


public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}

