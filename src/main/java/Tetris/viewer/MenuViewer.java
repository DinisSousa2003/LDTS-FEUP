package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.menu.Menu;

public class MenuViewer extends Viewer<Menu>{
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {

        gui.drawOutLine();

        gui.drawText(new Position(8, 4), "T", color.getColor("RED"));
        gui.drawText(new Position(9, 4), "E", color.getColor("ORANGE"));
        gui.drawText(new Position(10, 4), "T", color.getColor("YELLOW"));
        gui.drawText(new Position(11, 4), "R", color.getColor("GREEN"));
        gui.drawText(new Position(12, 4), "I", color.getColor("CYAN"));
        gui.drawText(new Position(13, 4), "S", color.getColor("PURPLE"));

        for (int i = 0; i < getModel().getNumEntries(); i++)
            gui.drawText(
                    new Position(4, 11 + 2*i),
                    getModel().getEntryName(i),
                    getModel().isSelected(i) ? color.getColor("RED") : color.getColor("WHITE"));
    }
}