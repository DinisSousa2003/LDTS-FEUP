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

    public String getColor() {
        return color;
    }

    public abstract Position[] getPositions(TetriminoDirection direction);

    public Position getCentralPosition(){return centralPosition;}

    public void setCentralPosition(Position position){
        this.centralPosition = position;
    }

    public void setDirection(TetriminoDirection direction){
        this.direction = direction;
    }

    public TetriminoDirection getDirection(){return this.direction;}

    public Position[]  rotateRightPositions(){
        TetriminoDirection tempdirection = TetriminoDirection.UP;
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
        return getActualPositions(this.centralPosition,tempdirection);
    }

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


    public Position[] rotateLeftPositions(){
        TetriminoDirection tempdirection = TetriminoDirection.UP;
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
        return getActualPositions(this.centralPosition,tempdirection);
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

    public void moveRight(){
        this.centralPosition = new Position(centralPosition.getX()+1, centralPosition.getY() );
    }
    public void moveLeft(){
        this.centralPosition = new Position(centralPosition.getX()-1, centralPosition.getY() );
    }
    public void moveDown(){
        this.centralPosition = new Position(centralPosition.getX(), centralPosition.getY()+1);
    }
    public Position[] moveRightPositions(){
        return getActualPositions( new Position(centralPosition.getX()+1, centralPosition.getY() ),this.direction);
    }
    public Position[] moveLeftPositions(){
        return getActualPositions( new Position(centralPosition.getX()-1, centralPosition.getY() ),this.direction);
    }
    public Position[] moveDownPositions(){
        return getActualPositions(new Position(centralPosition.getX(), centralPosition.getY()+1),this.direction);
    }

    public Position[] getActualPositions(Position centralPosition,TetriminoDirection direction){
        Position[] positions = getPositions(direction);
        for(int i = 0; i < 4;i++){
            positions[i] = new Position(positions[i].getX()+centralPosition.getX(),positions[i].getY()+centralPosition.getY());
        }
        return positions;
    }


}
