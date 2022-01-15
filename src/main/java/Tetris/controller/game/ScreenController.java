package Tetris.controller.game;

import Tetris.Main;
import Tetris.gui.GUI;
import Tetris.model.game.Screen;
import Tetris.model.menu.Menu;
import Tetris.states.MenuState;

public class ScreenController extends GameController{
    //private final TetriminoController tetriminoController

    public ScreenController(Screen screen){
        super(screen);
        //this.tetriminoController = new TetriminoController(screen);
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT){
            main.setState(new MenuState(new Menu()));
        }
        else{
            //tetriminoController.step(main, action, time);
        }
    }
}
