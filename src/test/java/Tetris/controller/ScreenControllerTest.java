package Tetris.controller;

import Tetris.Main;
import Tetris.controller.game.ScreenController;
import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.game.Screen;
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

public class ScreenControllerTest {
    private ScreenController controller;
    private Main main;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        main = Main.getInstance();
        controller = new ScreenController(new Screen(10,20));
    }



    @Test
    void moveTetriminoRight(){

        controller.getModel().setTetrimino(new O(new Position(6,1)));

        controller.getModel().getTetrimino().setCentralPosition(new Position(5, 15));
        controller.step(main, GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(new Position(6, 15), controller.getModel().getTetrimino().getCentralPosition());
        Assertions.assertEquals(TetriminoDirection.UP,controller.getModel().getTetrimino().getDirection());

        controller.getModel().getTetrimino().setCentralPosition(new Position(10, 15));
        controller.step(main, GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(new Position(10, 15), controller.getModel().getTetrimino().getCentralPosition());
        Assertions.assertEquals(TetriminoDirection.UP,controller.getModel().getTetrimino().getDirection());
    }

    @Test
    void moveTetriminoLeft(){

        controller.getModel().setTetrimino(new I(new Position(6,0)));

        controller.getModel().getTetrimino().setCentralPosition(new Position(5, 15));
        controller.step(main, GUI.ACTION.LEFT,0);
        Assertions.assertEquals(new Position(4, 15), controller.getModel().getTetrimino().getCentralPosition());
        Assertions.assertEquals(TetriminoDirection.UP,controller.getModel().getTetrimino().getDirection());

        controller.getModel().getTetrimino().setCentralPosition(new Position(2, 15));
        controller.step(main, GUI.ACTION.LEFT,0);
        controller.getModel().getTetrimino().getCentralPosition();
        Assertions.assertEquals(new Position(2, 15), controller.getModel().getTetrimino().getCentralPosition());
        Assertions.assertEquals(TetriminoDirection.UP,controller.getModel().getTetrimino().getDirection());
    }

    @Test
    void rotateTetriminoRight(){

        controller.getModel().setTetrimino(new S(new Position(5,0)));

        controller.getModel().getTetrimino().setCentralPosition(new Position(5, 15));
        controller.step(main, GUI.ACTION.UP,0);
        Assertions.assertEquals(new Position(5, 15), controller.getModel().getTetrimino().getCentralPosition());
        Assertions.assertEquals(TetriminoDirection.RIGHT,controller.getModel().getTetrimino().getDirection());
        controller.step(main, GUI.ACTION.UP,0);
        controller.step(main, GUI.ACTION.UP,0);
        controller.step(main, GUI.ACTION.UP,0);
        Assertions.assertEquals(TetriminoDirection.UP,controller.getModel().getTetrimino().getDirection());


    }

    @Test
    void moveTetriminoDownAuto(){
        controller.getModel().setTetrimino(new T(new Position(5,0)));

        controller.getModel().getTetrimino().setCentralPosition(new Position(5, 15));
        controller.step(main, GUI.ACTION.DOWN, 1500);
        Assertions.assertEquals(new Position(5, 17),controller.getModel().getTetrimino().getCentralPosition());
    }



    /*
    @Test
    void rotateTetriminoLeft(){

    }

    @Test
    void moveTetriminoDown(){

    }
     */
}
