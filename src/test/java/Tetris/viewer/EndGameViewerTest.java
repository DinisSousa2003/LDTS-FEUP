package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.endGame.EndGame;
import Tetris.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class EndGameViewerTest {
    private GUI gui;
    private EndGameViewer viewer;
    private EndGame endGame;

    @BeforeEach
    void setUp(){
        endGame = new EndGame();
        gui = Mockito.mock(GUI.class);
        viewer = new EndGameViewer(endGame);
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        //The screen shall not be cleaned for the game to appear on the background
        Mockito.verify(gui, Mockito.times(0)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    void drawText() throws IOException {
        viewer.draw(gui);

        //G A M E O V E R & EXIT (9)
        Mockito.verify(gui, Mockito.times(9)).drawText(Mockito.any(Position.class), Mockito.any(String.class), Mockito.any(String.class));
    }

}
