package Tetris.model;

import Tetris.model.game.Block;
import Tetris.model.game.Board;
import Tetris.model.menu.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {

    Board board;

    @BeforeEach
    void setUp(){
        board = new Board(5,5);
    }

    @AfterEach
    void after(){
        board = null;
    }

    @Test
    void  canOccupy_isFull_addBlock_removeLine(){
        Block b = new Block("#FFFFFF");

        if(board.canOccupy(new Position(0,4))) board.addBlock(new Position(0,4),b);
        if(board.isLineFull(4)) board.removeLine(4);
        if(board.canOccupy(new Position(1,4))) board.addBlock(new Position(1,4),b);
        if(board.canOccupy(new Position(1,4))) board.addBlock(new Position(1,4),b);
        if(board.canOccupy(new Position(0,3))) board.addBlock(new Position(0,3),b);
        if(board.canOccupy(new Position(1,3))) board.addBlock(new Position(1,3),b);
        if(board.canOccupy(new Position(2,4))) board.addBlock(new Position(2,4),b);
        if(board.canOccupy(new Position(3,4))) board.addBlock(new Position(3,4),b);
        if(board.canOccupy(new Position(4,4))) board.addBlock(new Position(4,4),b);
        if(board.isLineFull(4)) board.removeLine(4);
        if(board.canOccupy(new Position(4,4))) board.addBlock(new Position(4,4),b);

        Assertions.assertTrue(board.canOccupy(new Position(1,3)));
        Assertions.assertTrue(board.canOccupy(new Position(0,3)));
        Assertions.assertTrue(board.canOccupy(new Position(2,4)));
        Assertions.assertTrue(board.canOccupy(new Position(3,4)));
        Assertions.assertFalse(board.canOccupy(new Position(0,4)));
        Assertions.assertFalse(board.canOccupy(new Position(1,4)));
        Assertions.assertFalse(board.canOccupy(new Position(4,4)));

        Assertions.assertFalse(board.canOccupy(new Position(-1,0)));
        Assertions.assertFalse(board.canOccupy(new Position(0,-1)));
        Assertions.assertFalse(board.canOccupy(new Position(5,0)));
        Assertions.assertFalse(board.canOccupy(new Position(0,5)));

    }
}
