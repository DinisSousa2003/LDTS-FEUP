package Tetris.model.game;

public class Screen {

    private final int width;
    private final int height;

    private QueueOfTetrimino queueOfTetrimino;
    private Board board;
    private Stats stats;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        this.board = new Board(width, height);
        this.queueOfTetrimino = new QueueOfTetrimino();
        this.stats = new Stats();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public QueueOfTetrimino getQueueOfTetrimino() {
        return queueOfTetrimino;
    }

    public Board getBoard() {
        return board;
    }

    public Stats getStats() {
        return stats;
    }
}
