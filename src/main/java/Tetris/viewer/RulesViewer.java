package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.Position;
import Tetris.model.rules.Rules;

public class RulesViewer extends Viewer<Rules>{
    public RulesViewer(Rules rules){
        super(rules);
    }

    @Override
    protected void drawElements(GUI gui) {

        gui.drawOutLine();

        gui.drawText(new Position(7, 2), "C", color.getColor("RED"));
        gui.drawText(new Position(8, 2), "O", color.getColor("ORANGE"));
        gui.drawText(new Position(9, 2), "N", color.getColor("YELLOW"));
        gui.drawText(new Position(10, 2), "T", color.getColor("GREEN"));
        gui.drawText(new Position(11, 2), "R", color.getColor("CYAN"));
        gui.drawText(new Position(12, 2), "O", color.getColor("PURPLE"));
        gui.drawText(new Position(13, 2), "L", color.getColor("RED"));
        gui.drawText(new Position(14, 2), "S", color.getColor("ORANGE"));

        gui.drawText(new Position(2, 5), "UP/X", color.getColor("YELLOW"));
        gui.drawText(new Position(8, 5), "ROTATE LEFT", color.getColor("WHITE"));
        gui.drawText(new Position(2, 7), "Z", color.getColor("YELLOW"));
        gui.drawText(new Position(8, 7), "ROTATE RIGHT", color.getColor("WHITE"));
        gui.drawText(new Position(2, 9), "LEFT", color.getColor("YELLOW"));
        gui.drawText(new Position(8, 9), "MOVE LEFT", color.getColor("WHITE"));
        gui.drawText(new Position(2, 11), "RIGHT", color.getColor("YELLOW"));
        gui.drawText(new Position(8, 11), "MOVE RIGHT", color.getColor("WHITE"));
        gui.drawText(new Position(2, 13), "DOWN", color.getColor("YELLOW"));
        gui.drawText(new Position(8, 13), "MOVE DOWN", color.getColor("WHITE"));
        gui.drawText(new Position(2, 15), "SPACE", color.getColor("YELLOW"));
        gui.drawText(new Position(8, 15), "DROP PIECE", color.getColor("WHITE"));
        gui.drawText(new Position(2, 17), "Q/ESC", color.getColor("YELLOW"));
        gui.drawText(new Position(8, 17), "EXIT TO MENU", color.getColor("WHITE"));


        gui.drawText(new Position(9, 19),getModel().getEntryName(),color.getColor("RED"));

    }
}