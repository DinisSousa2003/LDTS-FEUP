package Tetris.model.game;

import Tetris.model.Position;
import com.googlecode.lanterna.TextColor;

public abstract class Tetrimino {

    protected TetriminoDirection direction;
    private Position centralPosition;

    public Tetrimino(Position position){
        this.direction = TetriminoDirection.UP;
        this.centralPosition = new Position(position.getX(), position.getY());

    }

    public abstract Position[] getPositions();



    public void  rotateRight(){
        switch(this.direction){
            case UP:
                this.direction = TetriminoDirection.RIGHT;
                break;
            case RIGHT:
                this.direction = TetriminoDirection.DOWN;
                break;
            case DOWN:
                this.direction = TetriminoDirection.LEFT;
                break;
            case LEFT:
                this.direction = TetriminoDirection.UP;
                break;

        }


    }
    public void rotateLeft(){
        switch(this.direction) {
            case UP:
                this.direction = TetriminoDirection.LEFT;
                break;
            case LEFT:
                this.direction = TetriminoDirection.DOWN;
                break;
            case DOWN:
                this.direction = TetriminoDirection.RIGHT;
                break;
            case RIGHT:
                this.direction = TetriminoDirection.UP;
                break;
        }
    }
}
