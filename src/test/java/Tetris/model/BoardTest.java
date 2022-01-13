package Tetris.model;

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
        if(board.canOccupy(new Position(0,0))) board.addBlock(new Position(0,0));
        if(board.isLineFull(0)) board.removeLine(0);
        if(board.canOccupy(new Position(1,0))) board.addBlock(new Position(1,0));
        if(board.canOccupy(new Position(1,0))) board.addBlock(new Position(1,0));
        if(board.canOccupy(new Position(0,1))) board.addBlock(new Position(0,1));
        if(board.canOccupy(new Position(1,1))) board.addBlock(new Position(1,1));
        if(board.canOccupy(new Position(2,0))) board.addBlock(new Position(2,0));
        if(board.canOccupy(new Position(3,0))) board.addBlock(new Position(3,0));
        if(board.canOccupy(new Position(4,0))) board.addBlock(new Position(4,0));
        if(board.isLineFull(0)) board.removeLine(0);
        if(board.canOccupy(new Position(0,0))) board.addBlock(new Position(0,0));

        Assertions.assertTrue(board.canOccupy(new Position(1,0)));
        Assertions.assertTrue(board.canOccupy(new Position(2,0)));
        Assertions.assertTrue(board.canOccupy(new Position(3,0)));
        Assertions.assertTrue(board.canOccupy(new Position(4,0)));
        Assertions.assertFalse(board.canOccupy(new Position(0,0)));
        Assertions.assertFalse(board.canOccupy(new Position(0,1)));
        Assertions.assertFalse(board.canOccupy(new Position(1,1)));

        Assertions.assertFalse(board.canOccupy(new Position(-1,0)));
        Assertions.assertFalse(board.canOccupy(new Position(0,-1)));
        Assertions.assertFalse(board.canOccupy(new Position(5,0)));
        Assertions.assertFalse(board.canOccupy(new Position(0,5)));

    }
}
