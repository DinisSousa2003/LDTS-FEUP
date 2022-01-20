package Tetris.model.game;

import java.util.ArrayList;
import java.util.Queue;

public class QueueOfTetrimino {

    private Queue<Tetrimino> tetreminoQueue;

    public QueueOfTetrimino() {
        for(int i = 0; i < 3; i++) tetreminoQueue.add(generateLast());
    }

    public Tetrimino popNext() {
        tetreminoQueue.add(generateLast());
        return tetreminoQueue.remove();
    }

    private Tetrimino generateLast() {
        int num = (int) (7 * Math.random()) % 7;
        Tetrimino next = new Tetrimino();

        switch (num){
            case 0:
                next = new I();
                break;
            case 1:
                next = new J();
                break;
            case 2:
                next = new L();
                break;
            case 3:
                next = new O();
                break;
            case 4:
                next = new S();
                break;
            case 5:
                next = new T();
                break;
            case 6:
                next = new Z();
                break;
        }
        return next;
    }
}
