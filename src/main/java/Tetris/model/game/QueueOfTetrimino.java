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
        tetreminoQueue = new ArrayDeque<>();
        for(int i = 0; i < 3; i++) tetreminoQueue.add(generateLast());
    }

    public Tetrimino popNext() {
        tetreminoQueue.add(generateLast());
        return tetreminoQueue.remove();
    }

    public ArrayList<Tetrimino> getTetreminoQueue() {
        return new ArrayList(tetreminoQueue);
    }

    private Tetrimino generateLast() {
        Random random = new Random();
        int num = random.nextInt(7);
        new Z(new Position(5, 1));
        Tetrimino next = switch (num) {
            case 0 -> new I(new Position(5, 0));
            case 1 -> new J(new Position(5, 1));
            case 2 -> new L(new Position(5, 1));
            case 3 -> new O(new Position(5, 1));
            case 4 -> new S(new Position(5, 1));
            case 5 -> new T(new Position(5, 1));
            default -> new Z(new Position(5, 1));
        };

        return next;
    }
}
