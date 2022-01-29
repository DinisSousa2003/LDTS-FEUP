package Tetris.states;

import Tetris.Main;
import Tetris.controller.EndGameController;
import Tetris.controller.MenuController;
import Tetris.controller.RulesController;
import Tetris.controller.game.GameController;
import Tetris.controller.game.ScreenController;
import Tetris.gui.GUI;
import Tetris.model.endGame.EndGame;
import Tetris.model.game.Screen;
import Tetris.model.menu.Menu;
import Tetris.model.rules.Rules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class StatesTest {

    GameController gameController;
    RulesController rulesController;
    MenuController menuController;
    EndGameController endGameController;
    Menu menu;
    Main main;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        main = Main.getInstance();
        menu = new Menu();
        menuController = new MenuController(menu);
        gameController = new ScreenController(new Screen(22, 22));
        rulesController = new RulesController(new Rules());
        endGameController = new EndGameController(new EndGame());
    }

    @AfterEach
    void after(){
        main.setState(new MenuState(new Menu()));
        menu = null;
        menuController = null;
    }


    @Test
    void actionDown(){
        menuController.step(main, GUI.ACTION.DOWN, 0);
        Assertions.assertTrue(menuController.getModel().isSelectedRules());
    }

    @Test
    void actionUp(){
        menuController.step(main, GUI.ACTION.UP, 0);
        Assertions.assertTrue(menuController.getModel().isSelectedExit());
    }

    @Test
    void actionQuit(){
        menuController.step(main, GUI.ACTION.QUIT, 0);
        Assertions.assertNull(main.getState());
    }

    @Test
    void actionSelect(){
        menuController.step(main, GUI.ACTION.DOWN, 0);
        menuController.step(main, GUI.ACTION.SELECT, 0);
        Assertions.assertEquals(Tetris.states.RulesState.class, main.getState().getClass());
    }

    @Test
    void menuToGameToMenu(){
        menuController.step(main, GUI.ACTION.SELECT, 0);
        Assertions.assertEquals(Tetris.states.GameState.class, main.getState().getClass());
        gameController.step(main, GUI.ACTION.QUIT, 0);
        Assertions.assertEquals(Tetris.states.MenuState.class, main.getState().getClass());
    }

    @Test
    void menuToRulesToMenu(){
        menuController.step(main, GUI.ACTION.DOWN, 0);
        menuController.step(main, GUI.ACTION.SELECT, 0);
        Assertions.assertEquals(Tetris.states.RulesState.class, main.getState().getClass());
        rulesController.step(main, GUI.ACTION.SELECT, 0);
        Assertions.assertEquals(Tetris.states.MenuState.class, main.getState().getClass());
    }

    @Test
    void endGameToMenu(){
        main.setState(new EndGameState(new EndGame()));
        endGameController.step(main, GUI.ACTION.SELECT, 0);
        Assertions.assertEquals(Tetris.states.MenuState.class, main.getState().getClass());
    }



}
