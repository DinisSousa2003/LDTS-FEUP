package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.game.*;
import Tetris.model.game.Tetriminos.T;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Screen screen;

    @BeforeEach
    void setUp(){
        screen = new Screen(10, 20);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(screen);

        screen.setTetrimino(new T(new Position(3, 10)));
    }

    @Test
    void drawTetrimino() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawTetrimino(screen.getTetrimino());
        Mockito.verify(gui, Mockito.times(1)).drawTetrimino(Mockito.any(Tetrimino.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();

    }

    @Test
    void drawElements() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawStats(Mockito.any(Stats.class));
        Mockito.verify(gui, Mockito.times(1)).drawQueue(Mockito.any(QueueOfTetrimino.class));
        Mockito.verify(gui, Mockito.times(1)).drawBoard(Mockito.any(Board.class));
    }
}
