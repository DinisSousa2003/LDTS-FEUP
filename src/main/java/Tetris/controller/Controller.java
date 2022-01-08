package Tetris.controller;

import Tetris.Main;
import Tetris.gui.GUI;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Main main, GUI.ACTION action, long time);
}
