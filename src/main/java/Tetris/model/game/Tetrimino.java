package Tetris.model.game;

import Tetris.model.Color;
import Tetris.model.Position;
import com.googlecode.lanterna.TextColor;

public abstract class Tetrimino {

    protected TetriminoDirection direction;
    private Position centralPosition;
    protected  String color;

    public Tetrimino(Position position){

        this.direction = TetriminoDirection.UP;
        this.centralPosition = new Position(position.getX(), position.getY());

    }

    public abstract Position[] getPositions(TetriminoDirection direction);

    public Position getCentralPosition(){return centralPosition;}
    
    public void setDirection(TetriminoDirection direction){
        this.direction = direction;
    }

    public Position[]  rotateRight(){
        TetriminoDirection tempdirection = TetriminoDirection.UP;
        Position[] positions = new Position[4];
        switch(this.direction){
            case UP:
                tempdirection = TetriminoDirection.RIGHT;
                break;
            case RIGHT:
                tempdirection = TetriminoDirection.DOWN;
                break;
            case DOWN:
                tempdirection = TetriminoDirection.LEFT;
                break;
            case LEFT:
                tempdirection = TetriminoDirection.UP;
                break;

        }

        positions = getPositions(tempdirection);
        return positions;
    }
    public Position[] rotateLeft(){
        TetriminoDirection tempdirection = TetriminoDirection.UP;
        Position[] positions;
        switch(this.direction) {
            case UP:
                tempdirection = TetriminoDirection.LEFT;
                break;
            case LEFT:
                tempdirection = TetriminoDirection.DOWN;
                break;
            case DOWN:
                tempdirection = TetriminoDirection.RIGHT;
                break;
            case RIGHT:
                tempdirection = TetriminoDirection.UP;
                break;
        }
        positions = getPositions(tempdirection);

        return positions;
    }
    public void moveRight(){
        this.centralPosition = new Position(centralPosition.getX()+1, centralPosition.getY() );
    }
    public void moveLeft(){
        this.centralPosition = new Position(centralPosition.getX()-1, centralPosition.getY() );
    }
    public void moveDown(){
        this.centralPosition = new Position(centralPosition.getX(), centralPosition.getY()-1);
    }


}
