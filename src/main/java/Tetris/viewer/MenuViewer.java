package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.menu.Menu;

import java.io.IOException;

public class MenuViewer extends Viewer<Menu>{
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {

        gui.drawText(new Position(10, 3), "T", "#FF0000");
        gui.drawText(new Position(11, 3), "E", "#FF7F00");
        gui.drawText(new Position(12, 3), "T", "#FFFF00");
        gui.drawText(new Position(13, 3), "R", "#00FF00");
        gui.drawText(new Position(14, 3), "I", "#00FFFF");
        gui.drawText(new Position(15, 3), "S", "#800080");

        for (int i = 0; i < getModel().getNumEntries(); i++)
            gui.drawText(
                    new Position(5, 9 + i),
                    getModel().getEntryName(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
