package Tetris.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {

    Menu menu;

    @BeforeEach
    void setUp(){
        menu = Menu();
    }

    @Test
    void nextAndPreviousEntry(){
        menu.nextEntry(); //0 -> 1
        Assertions.assertTrue(menu.getEntry(), 1);
        menu.previousEntry(); //1 -> 0
        Assertions.assertFalse(menu.getEntry(), 0);
    }
}
