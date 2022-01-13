package Tetris.model.game;

import Tetris.model.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Board {

    private Block[][] board;

    public Board(int width, int height) {
         board = new Block[height][width];

        for (Block[] v1 : board) {
            for (Block b : v1) b = null;
        }

        /* codigo para vectors
        Vector<Vector<Block>> board = new Vector<Vector<Block>>();

        for (Vector<Block> v2 : board) {
            for (Block b : v2) b = null;
        }
         */
    }

    //public boolean isEmpty(Position pos){return true;}

    public boolean canOccupy(Position pos) {return true;}

    public boolean isLineFull(int line){return false;}

    public void removeLine(int line){;}

    public void addBlock(Position pos){;}



    //public void removeBlock(Position pos){;}

}