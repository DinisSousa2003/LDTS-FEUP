package Tetris.model.game;

import Tetris.model.Position;
import Tetris.model.game.Tetriminos.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

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
        Random random = new Random();
        int num = random.nextInt(7);
        Tetrimino next = new Z(new Position(5,1));;

        switch (num){
            case 0:
                next = new I(new Position(5,0));
                break;
            case 1:
                next = new J(new Position(5,1));
                break;
            case 2:
                next = new L(new Position(5,1));
                break;
            case 3:
                next = new O(new Position(5,1));
                break;
            case 4:
                next = new S(new Position(5,1));
                break;
            case 5:
                next = new T(new Position(5,1));
                break;
        }
        return next;
    }
}
