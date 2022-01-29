package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.menu.Menu;
import Tetris.model.rules.Rules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;

public class RulesViewerTest {
    private GUI gui;
    private RulesViewer viewer;
    private Rules rules;

    @BeforeEach
    void setUp(){
        rules = new Rules();
        gui = Mockito.mock(GUI.class);
        viewer = new RulesViewer(rules);
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    void drawSquares() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawOutLine();
    }

    @Test
    void drawText() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(Mockito.any(Position.class), eq("Exit"), Mockito.any(String.class));
    }
}
