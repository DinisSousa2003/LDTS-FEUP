package Tetris.model.game;

import Tetris.model.Position;

import java.util.Arrays;

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
        return board[pos.getY()][pos.getX()] == null;
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
            System.arraycopy(board[j - 1], 0, board[j], 0, board[0].length);
        }
        Arrays.fill(board[0], null);

    }

    public void addBlock(Position pos, Block block){
        board[pos.getY()][pos.getX()] = block;
    }

}