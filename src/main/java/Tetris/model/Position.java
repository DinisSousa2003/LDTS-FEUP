package Tetris.model;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        final Position position = (Position) obj;
        //return super.equals(position);
        return (this.x == position.getX() && this.y == position.getY());
    }

}