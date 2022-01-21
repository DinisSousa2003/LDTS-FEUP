package Tetris.model.game.Tetriminos;

import Tetris.model.Position;
import Tetris.model.game.Tetrimino;
import Tetris.model.game.TetriminoDirection;

public class O extends Tetrimino {

    public O(Position position) {
        super(position);
        this.color = "YELLOW";
    }

    public O(Tetrimino tetrimino) {
        super(tetrimino.getCentralPosition());
        this.color = "YELLOW";
    }

    public Position[] getPositions(TetriminoDirection direction) {
        Position[] positions = new Position[4];
        switch (direction) {
            case UP, LEFT, DOWN, RIGHT -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(-1, 0);
                positions[2] = new Position(0, -1);
                positions[3] = new Position(-1, -1);
            }
        }
        return positions;
    }
}
