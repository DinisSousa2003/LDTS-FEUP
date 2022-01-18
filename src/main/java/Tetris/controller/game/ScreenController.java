package Tetris.controller.game;

import Tetris.Main;
import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.game.Screen;
import Tetris.model.menu.Menu;
import Tetris.states.MenuState;

public class ScreenController extends GameController{
    private final TetriminoController tetriminoController;

    public ScreenController(Screen screen){
        super(screen);
        this.tetriminoController = new TetriminoController(screen);
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) {
        switch (action){
            case QUIT:
                main.setState(new MenuState(new Menu()));
                break;
            case DOWN:
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

    private void moveDown() {
        Position[] positions = getModel().getTetrimino().moveDownPositions();
        boolean canMove = getModel().getBoard().canMove(positions);
        if (canMove) getModel().getTetrimino().moveDown();
        else {
            //drop block

            //check for full lines
        }
    }

    private void moveRight() {
        Position[] positions = getModel().getTetrimino().moveRightPositions();
        boolean canMove = getModel().getBoard().canMove(positions);
        if (canMove) getModel().getTetrimino().moveRight();
    }

    private void moveLeft() {
        Position[] positions = getModel().getTetrimino().moveLeftPositions();
        boolean canMove = getModel().getBoard().canMove(positions);
        if (canMove) getModel().getTetrimino().moveLeft();
    }

    private void rotateRight() {
        Position[] positions = getModel().getTetrimino().rotateRightPositions();
        boolean canMove = getModel().getBoard().canMove(positions);
        if (canMove) getModel().getTetrimino().rotateRight();
        // ver se se pode mexer pros lados
    }

    private void rotateLeft() {
        Position[] positions = getModel().getTetrimino().rotateLeftPositions();
        boolean canMove = getModel().getBoard().canMove(positions);
        if (canMove) getModel().getTetrimino().rotateLeft();
        // ver se se pode mexer pros lados
    }

}
