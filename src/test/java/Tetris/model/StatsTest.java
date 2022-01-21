package Tetris.model;

import Tetris.model.game.Stats;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatsTest {

    Stats stats;

    @BeforeEach
    void setUp(){
        stats = new Stats();
    }

    @AfterEach
    void after(){
        stats = null;
    }

    @Test
    void testStats(){
        Assertions.assertEquals(1, stats.getLevel());
        stats.removedLines(4);
        Assertions.assertEquals(80, stats.getPoints());
        stats.removedLines(1);
        stats.removedLines(3);
        stats.removedLines(1);
        stats.removedLines(1);
        Assertions.assertEquals(10, stats.getLines());
        Assertions.assertEquals(2, stats.getLevel());
        Assertions.assertEquals(80 + 50 + 10*3, stats.getPoints());
        stats.removedLines(2);
        Assertions.assertEquals(80 + 50 + 30*2 + 10*3, stats.getPoints());
    }
}
