package Tetris.model.game.Tetriminos;

import Tetris.model.Position;
import Tetris.model.game.Tetrimino;
import Tetris.model.game.TetriminoDirection;

public class I extends Tetrimino {

    public I(Position position) {
        super(position);
        this.color = "CYAN";
    }

    public I(Tetrimino tetrimino) {
        super(tetrimino.getCentralPosition());
        this.color = "CYAN";
    }

    public Position[] getPositions(TetriminoDirection direction){
        Position[] positions = new Position[4];
        switch(direction){
            case UP -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(-1, 0);
                positions[2] = new Position(1, 0);
                positions[3] = new Position(-2, 0);
            }
            case RIGHT -> {
                positions[0] = new Position(-1, 0);
                positions[1] = new Position(-1, -1);
                positions[2] = new Position(-1, -2);
                positions[3] = new Position(-1, 1);
            }
            case DOWN -> {
                positions[0] = new Position(-1, -1);
                positions[1] = new Position(0, -1);
                positions[2] = new Position(1, -1);
                positions[3] = new Position(-2, -1);
            }
            case LEFT -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(0, -1);
                positions[2] = new Position(0, -2);
                positions[3] = new Position(0, 1);
            }
        }
        return positions;
    }
}
