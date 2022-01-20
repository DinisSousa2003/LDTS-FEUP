package Tetris.controller.game;

import Tetris.Main;
import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.game.Block;
import Tetris.model.game.Screen;
import Tetris.model.menu.Menu;
import Tetris.states.MenuState;

public class ScreenController extends GameController{
    private long lastMovement;

    public ScreenController(Screen screen){
        super(screen);
        this.lastMovement = 0;
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) {
        if(time - lastMovement > 1000) {
            moveDown();
            this.lastMovement = time;
        }

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
            positions = getModel().getTetrimino().getActualPositions(getModel().getTetrimino().getCentralPosition(),getModel().getTetrimino().getDirection());
            for(Position position : positions) {
                getModel().getBoard().addBlock(position,new Block(getModel().getTetrimino().getColor()));
            }

            for (int i = getModel().getHeight() -1 ;i >= 0;i--) {
                if(getModel().getBoard().isLineFull(i)) getModel().getBoard().removeLine(i);
            }

            getModel().setTetrimino(getModel().getQueueOfTetrimino().popNext());
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
