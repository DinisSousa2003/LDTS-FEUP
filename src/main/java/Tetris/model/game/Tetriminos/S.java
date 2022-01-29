package Tetris.model.game.Tetriminos;

import Tetris.model.Position;
import Tetris.model.game.Tetrimino;
import Tetris.model.game.TetriminoDirection;

public class S extends Tetrimino {

    public S(Position position) {
        super(position);
        this.color = "GREEN";
    }

    public S(Tetrimino tetrimino) {
        super(tetrimino.getCentralPosition());
        this.color = "GREEN";
    }

    public Position[] getPositions(TetriminoDirection direction) {
        Position[] positions = new Position[4];
        switch (direction) {
            case UP:
                positions[0] = new Position(0, 0);
                positions[1] = new Position(0, -1);
                positions[2] = new Position(1, -1);
                positions[3] = new Position(-1, 0);
                break;
            case RIGHT:
                positions[0] = new Position(0, 0);
                positions[1] = new Position(0, -1);
                positions[2] = new Position(1, 0);
                positions[3] = new Position(1, 1);
                break;
            case DOWN:
                positions[0] = new Position(0, 0);
                positions[1] = new Position(0, 1);
                positions[2] = new Position(1, 0);
                positions[3] = new Position(-1, 1);
                break;
            case LEFT:
                positions[0] = new Position(0, 0);
                positions[1] = new Position(0, 1);
                positions[2] = new Position(-1, 0);
                positions[3] = new Position(-1, -1);
                break;
        }
        return positions;
    }
}
