package Tetris.model.game.Tetriminos;

import Tetris.model.Position;
import Tetris.model.game.Tetrimino;
import Tetris.model.game.TetriminoDirection;

public class J extends Tetrimino {


    public J(Position position) {
        super(position);
        this.color = "BLUE";
    }

    public J(Tetrimino tetrimino) {
        super(tetrimino.getCentralPosition());
        this.color = "BLUE";
    }

    public Position[] getPositions(TetriminoDirection direction){
        Position[] positions = new Position[4];
        switch (direction) {
            case UP -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(-1, 0);
                positions[2] = new Position(-1, -1);
                positions[3] = new Position(1, 0);
            }
            case RIGHT -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(0, -1);
                positions[2] = new Position(1, -1);
                positions[3] = new Position(0, 1);
            }
            case DOWN -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(1, 0);
                positions[2] = new Position(1, 1);
                positions[3] = new Position(-1, 0);
            }
            case LEFT -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(0, 1);
                positions[2] = new Position(0, -1);
                positions[3] = new Position(-1, 1);
            }
        }
        return positions;
    }
}
