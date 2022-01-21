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
    }

    public Block[][] getBoard(){
        return board;
    }

    public boolean canOccupy(Position pos) {
        if (pos.getX()<0 || pos.getX()>=board[0].length) return false;
        if (pos.getY()<0 || pos.getY()>=board.length) return false;
        if (board[pos.getY()][pos.getX()] == null) return true;
        return false;
    }

    public boolean isLineFull(int line){
        boolean full = true;

        for (Block block : board[line]){
            if (block == null) {
                full = false;
                break;
            }
        }

        return full;
    }

    public boolean canMove(Position[] positions){
        boolean canMove = true;
        for (Position p : positions) {
            if (!canOccupy(p)) {
                canMove = false;
                break;
            }
        }
        return canMove;
    }

    public void removeLine(int line){
        for (int j = line; j > 0;j--){
            for (int i = 0; i < board[0].length; i++) {
                board[j][i] = board[j-1][i];
                System.out.println(board[j][i] + " , " + board[j-1][i]);
            }
        }
        for (int i = 0; i < board[0].length; i++) board[0][i] = null;

    }

    public void addBlock(Position pos, Block block){
        board[pos.getY()][pos.getX()] = block;
    }

    //public boolean isEmpty(Position pos){return true;}

    //public void removeBlock(Position pos){;}

}