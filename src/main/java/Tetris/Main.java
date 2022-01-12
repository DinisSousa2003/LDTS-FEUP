package Tetris;

import Tetris.gui.LanternaGUI;
import Tetris.model.menu.Menu;
import Tetris.model.rules.Rules;
import Tetris.states.MenuState;
import Tetris.states.RulesState;
import Tetris.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    private static Main instance;
    private State state;
    private final LanternaGUI gui;


    private Main() throws IOException, URISyntaxException, FontFormatException {
        gui = new LanternaGUI(22, 22);
        state = new MenuState(new Menu());
        //state = new RulesState(new Rules()); used for testing
    }

    public static Main getInstance() throws IOException, URISyntaxException, FontFormatException {
        if (instance == null){
            instance = new Main();
        }
        return instance;
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        getInstance().start();
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState() {return state;}

    private void start() throws IOException {
        int FPS = 40;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }

}
