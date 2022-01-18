package Tetris.controller.game;

import Tetris.Main;
import Tetris.gui.GUI;
import Tetris.model.game.Screen;
import Tetris.model.menu.Menu;
import Tetris.states.MenuState;

public class TetriminoController extends GameController{

    public TetriminoController(Screen screen){
        super(screen);
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT){
            main.setState(new MenuState(new Menu()));
        }
        else{
            switch (action){
                case DOWN:
                    getModel()
                    moveDown();
                    break;
                case RIGHT:
                    moveRight();
                    break;
                case LEFT:
                    moveLeft();
                    break;
                case UP:
                    rotateRight();
                    break;
                case Z:
                    rotateLeft();
                    break;
                default:
                    break;
            }
        }
    }

}
