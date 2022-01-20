package Tetris.model.game;

import Tetris.model.Position;
import Tetris.model.game.Tetriminos.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class QueueOfTetrimino {

    private Queue<Tetrimino> tetreminoQueue;

    public QueueOfTetrimino() {
        tetreminoQueue = new ArrayDeque<Tetrimino>();
        for(int i = 0; i < 3; i++) tetreminoQueue.add(generateLast());
    }

    public Tetrimino popNext() {
        tetreminoQueue.add(generateLast());
        return tetreminoQueue.remove();
    }

    private Tetrimino generateLast() {
        int num = (int) (7 * Math.random()) % 7;
        Tetrimino next = new Z(new Position(6,1));;

        switch (num){
            case 0:
                next = new I(new Position(6,0));
                break;
            case 1:
                next = new J(new Position(6,1));
                break;
            case 2:
                next = new L(new Position(6,1));
                break;
            case 3:
                next = new O(new Position(6,1));
                break;
            case 4:
                next = new S(new Position(6,1));
                break;
            case 5:
                next = new T(new Position(6,1));
                break;
        }
        return next;
    }
}
