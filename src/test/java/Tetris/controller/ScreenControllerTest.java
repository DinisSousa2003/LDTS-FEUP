package Tetris.controller;

import Tetris.Main;
import Tetris.controller.game.ScreenController;
import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.game.Block;
import Tetris.model.game.Screen;
import Tetris.model.game.TetriminoDirection;
import Tetris.model.game.Tetriminos.*;

import Tetris.states.EndGameState;
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




    @Test
    void rotateTetriminoLeft(){
        controller.getModel().setTetrimino(new J(new Position(5,0)));

        controller.getModel().getTetrimino().setCentralPosition(new Position(5, 15));
        controller.step(main, GUI.ACTION.Z,0);
        Assertions.assertEquals(new Position(5, 15), controller.getModel().getTetrimino().getCentralPosition());
        Assertions.assertEquals(TetriminoDirection.LEFT,controller.getModel().getTetrimino().getDirection());
        controller.step(main, GUI.ACTION.Z,0);
        controller.step(main, GUI.ACTION.Z,0);
        controller.step(main, GUI.ACTION.Z,0);
        Assertions.assertEquals(TetriminoDirection.UP,controller.getModel().getTetrimino().getDirection());

    }

    @Test
    void moveTetriminoDown(){
        controller.getModel().setTetrimino(new L(new Position(5,0)));

        controller.getModel().getTetrimino().setCentralPosition(new Position(5, 15));
        controller.step(main, GUI.ACTION.DOWN,0);
        Assertions.assertEquals(new Position(5, 16),controller.getModel().getTetrimino().getCentralPosition());

        controller.getModel().getTetrimino().setCentralPosition(new Position(5, 19));


        Position[] positions = controller.getModel().getTetrimino().getActualPositions(controller.getModel().getTetrimino().getCentralPosition(),controller.getModel().getTetrimino().getDirection());

        controller.step(main,GUI.ACTION.DOWN,0);

        for(int i= 0; i < 4;i++){
            Assertions.assertFalse(controller.getModel().getBoard().canOccupy(positions[i]));
        }

        if(controller.getModel().getTetrimino().getClass() == I.class){
            Assertions.assertEquals(new Position(5,0),controller.getModel().getTetrimino().getCentralPosition());
        }
        else{
            Assertions.assertEquals(new Position(5,1),controller.getModel().getTetrimino().getCentralPosition());
        }

        controller.getModel().setTetrimino(new Z(new Position(5,18)));
        positions = controller.getModel().getTetrimino().getActualPositions(controller.getModel().getTetrimino().getCentralPosition(),controller.getModel().getTetrimino().getDirection());
        controller.step(main,GUI.ACTION.DOWN,0);
        for(int i= 0; i < 4;i++){
            Assertions.assertFalse(controller.getModel().getBoard().canOccupy(positions[i]));
        }


    }

    @Test
    void dropTetriminoDown(){
        controller.getModel().setTetrimino(new I(new Position(5,0)));

        controller.getModel().getTetrimino().setCentralPosition(new Position(5, 15));
        Position[] positions = controller.getModel().getTetrimino().getActualPositions(new Position(5,19),controller.getModel().getTetrimino().getDirection());
        controller.step(main, GUI.ACTION.SPACE,0);
        for(int i= 0; i < 4;i++){
            Assertions.assertFalse(controller.getModel().getBoard().canOccupy(positions[i]));
        }

        for(int i = 0; i< 4;i++){
            controller.getModel().getBoard().addBlock(new Position(i + 3,1),new Block("WHITE"));
            controller.getModel().getBoard().addBlock(new Position(i + 3 ,0),new Block("WHITE"));
        }

        controller.step(main, GUI.ACTION.SPACE,0);
        Assertions.assertEquals(EndGameState.class,main.getState().getClass());

    }

    @Test
    void fullLines() {

        for(int i= 0; i < 3;i++){
            controller.getModel().getBoard().addBlock(new Position(i,19),new Block("WHITE"));
        }
        for(int i= 7; i < 10;i++){
            controller.getModel().getBoard().addBlock(new Position(i,19),new Block("WHITE"));
        }
        controller.getModel().setTetrimino(new I(new Position(5,0)));
        controller.step(main,GUI.ACTION.SPACE,0);

        for(int i = 0; i< 9;i++){
            Assertions.assertTrue(controller.getModel().getBoard().canOccupy(new Position(i,10)));
        }

    }

    @Test
    void fallWithTime() {
        for(int i= 0; i < 9;i++){
            controller.getModel().getBoard().addBlock(new Position(i,1),new Block("WHITE"));
        }
        controller.getModel().setTetrimino(new I(new Position(5,0)));
        controller.step(main,GUI.ACTION.NONE,10000);
        Assertions.assertEquals(EndGameState.class,main.getState().getClass());

    }

}
