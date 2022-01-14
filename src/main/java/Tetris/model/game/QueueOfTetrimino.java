package Tetris.model.game;

import java.util.Queue;

public class QueueOfTetrimino {

    private Queue<Tetrimino> tetreminoQueue;

    public QueueOfTetrimino() {;}

    public Tetrimino popNext() { return new Tetrimino();}

    private Tetrimino generateLast() { return new Tetrimino();}
}
