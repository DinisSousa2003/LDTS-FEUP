package Tetris.viewer;

import Tetris.gui.GUI;
import Tetris.model.Color;

import java.io.IOException;
import java.util.Map;

public abstract class Viewer <T>{
    private final T model;
    protected final Color color = new Color();

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui) throws IOException;
}