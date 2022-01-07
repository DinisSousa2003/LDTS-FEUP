package gui;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    /*
    void drawBoard();

    void drawQueue();

    void drawTetrimino();

    void drawStats();
     */

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
