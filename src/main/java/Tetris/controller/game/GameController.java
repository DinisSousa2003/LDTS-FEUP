package Tetris.controller.game;

import Tetris.controller.Controller;
import Tetris.model.game.Screen;

public abstract class GameController extends Controller<Screen> {
    public GameController(Screen screen) {
        super(screen);
    }
}