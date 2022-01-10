package Tetris.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {

    Menu menu;

    @BeforeEach
    void setUp(){
        menu = new Menu();
    }

    @Test
    void nextAndPreviousEntry(){
        menu.nextEntry(); //0 -> 1
        Assertions.assertEquals(1, menu.getCurrentEntry());
        menu.previousEntry(); //1 -> 0
        Assertions.assertEquals(0, menu.getCurrentEntry());

        for(int i = 0; i < menu.getNumEntries(); i++){
            menu.nextEntry();
        }
        Assertions.assertEquals(0, menu.getCurrentEntry());

        menu.previousEntry();
        Assertions.assertEquals(menu.getNumEntries() - 1, menu.getCurrentEntry());
    }
}
