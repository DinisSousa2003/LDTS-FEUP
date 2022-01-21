package Tetris.controller.game;

import Tetris.Main;
import Tetris.gui.GUI;
import Tetris.model.EndGame;
import Tetris.model.Position;
import Tetris.model.game.Block;
import Tetris.model.game.Screen;
import Tetris.model.menu.Menu;
import Tetris.states.EndGameState;
import Tetris.states.MenuState;

public class ScreenController extends GameController{
    private long lastMovement;

    public ScreenController(Screen screen){
        super(screen);
        this.lastMovement = 0;
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) {
        int endOfGame = 1;
        if(time - lastMovement > (1000/getModel().getStats().getLevel())) {
            endOfGame = moveDown();
            if (endOfGame == -1) {
                this.getModel().stopMusic();
                main.setState(new EndGameState(new EndGame()));
            }
            this.lastMovement = time;
        }

        switch (action){
            case QUIT:
                this.getModel().stopMusic();
                main.setState(new MenuState(new Menu()));
                break;
            case DOWN:
                endOfGame = moveDown();
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
            case SPACE:
                endOfGame = dropDown();
                break;
            default:
                break;
        }

        dropShadow();
        if (endOfGame == -1) {
            this.getModel().stopMusic();
            main.setState(new EndGameState(new EndGame()));
        }
    }

    private int moveDown() {
        Position[] positions = getModel().getTetrimino().moveDownPositions();
        boolean canMove = getModel().getBoard().canMove(positions);
        if (canMove) {
            getModel().getTetrimino().moveDown();
            return 1;
        }
        else {
            positions = getModel().getTetrimino().getActualPositions(getModel().getTetrimino().getCentralPosition(),getModel().getTetrimino().getDirection());
            for(Position position : positions) {
                //System.out.println(getModel().getTetrimino().getColor() + " : " + position.getX() + " , " + position.getY());
                getModel().getBoard().addBlock(position,new Block(getModel().getTetrimino().getColor()));
            }

            int lines = 0;

            for (int i = getModel().getHeight() -1 ;i >= 0;i--) {
                if(getModel().getBoard().isLineFull(i)) {
                    getModel().getBoard().removeLine(i);
                    i++;
                    lines++;
                }
            }

            getModel().getStats().removedLines(lines);
            System.out.print(getModel().getStats().getLines());
            System.out.print("   ");
            System.out.print(getModel().getStats().getPoints());
            System.out.print("   ");
            System.out.println(getModel().getStats().getLevel());

            getModel().setTetrimino(getModel().getQueueOfTetrimino().popNext());
            getModel().setShadowTetrimino(getModel().getTetrimino().copy());

            positions = getModel().getTetrimino().getActualPositions(getModel().getTetrimino().getCentralPosition(),getModel().getTetrimino().getDirection());
            canMove = getModel().getBoard().canMove(positions);
            if(!canMove){
                getModel().setTetrimino(null);
                return -1;
            }

            return 0;
        }
    }

    private int dropDown() {
        int canMove = moveDown();
        while (canMove != 0){
            if(canMove == -1) return -1;
            canMove = moveDown();
        }
        return 0;
    }

    private void dropShadow() {
        if (getModel().getTetrimino() == null) return;
        getModel().getShadowTetrimino().setCentralPosition(getModel().getTetrimino().getCentralPosition());
        getModel().getShadowTetrimino().setDirection(getModel().getTetrimino().getDirection());
        boolean canMove = true;
        Position[] positions;
        while (canMove){
            positions = getModel().getShadowTetrimino().moveDownPositions();
            canMove = getModel().getBoard().canMove(positions);
            if (canMove) getModel().getShadowTetrimino().moveDown();
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
