package Tetris.controller;

import Tetris.Main;
import Tetris.controller.game.ScreenController;
import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.game.Board;
import Tetris.model.game.Screen;
import Tetris.model.game.Tetrimino;
import Tetris.model.game.TetriminoDirection;
import Tetris.model.game.Tetriminos.I;
import Tetris.model.game.Tetriminos.O;
import Tetris.model.game.Tetriminos.S;
import Tetris.model.game.Tetriminos.T;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Time;

public class ScreenControllerTest {
    private ScreenController controller;
    private Board board;
    private Tetrimino tetrimino;
    private Main main;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        main = Main.getInstance();
        controller = new ScreenController(new Screen(10,20));
        board = new Board(20, 20);
    }

    @Test
    void moveTetriminoRight(){

        tetrimino = new O(new Position(10,1));

        tetrimino.setCentralPosition(new Position(15, 15));
        controller.step(main, GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(new Position(16, 15), tetrimino.getActualPositions(tetrimino.getCentralPosition(),tetrimino.getDirection()));
        Assertions.assertEquals(TetriminoDirection.UP,tetrimino.getDirection());

        tetrimino.setCentralPosition(new Position(20, 15));
        controller.step(main, GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(new Position(20, 15), tetrimino.getActualPositions(tetrimino.getCentralPosition(),tetrimino.getDirection()));
        Assertions.assertEquals(TetriminoDirection.UP,tetrimino.getDirection());
    }

    @Test
    void moveTetriminoLeft(){
        tetrimino = new I(new Position(10,0));

        tetrimino.setCentralPosition(new Position(15, 15));
        controller.step(main, GUI.ACTION.LEFT,0);
        Assertions.assertEquals(new Position(14, 15), tetrimino.getActualPositions(tetrimino.getCentralPosition(),tetrimino.getDirection()));
        Assertions.assertEquals(TetriminoDirection.UP,tetrimino.getDirection());

        tetrimino.setCentralPosition(new Position(2, 15));
        controller.step(main, GUI.ACTION.LEFT,0);
        Assertions.assertEquals(new Position(2, 15), tetrimino.getActualPositions(tetrimino.getCentralPosition(),tetrimino.getDirection()));
        Assertions.assertEquals(TetriminoDirection.UP,tetrimino.getDirection());
    }

    @Test
    void rotateTetriminoRight(){
        tetrimino = new S(new Position(10,0));

        tetrimino.setCentralPosition(new Position(15, 15));
        controller.step(main, GUI.ACTION.UP,0);
        Assertions.assertEquals(new Position(15, 15), tetrimino.getActualPositions(tetrimino.getCentralPosition(),tetrimino.getDirection()));
        Assertions.assertEquals(TetriminoDirection.RIGHT,tetrimino.getDirection());
        controller.step(main, GUI.ACTION.UP,0);
        controller.step(main, GUI.ACTION.UP,0);
        controller.step(main, GUI.ACTION.UP,0);
        Assertions.assertEquals(TetriminoDirection.UP,tetrimino.getDirection());


    }

    @Test
    void rotateTetriminoLeft(){

    }

    void moveTetriminoDown(){

    }
}
