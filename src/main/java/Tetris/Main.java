package Tetris;

import Tetris.gui.LanternaGUI;
import Tetris.model.Menu;
import Tetris.states.MenuState;
import Tetris.states.State;

import java.io.IOException;

public class Main {
    private static Main instance;
    private State state;
    private final LanternaGUI gui;


    private Main() throws IOException {
        gui = new LanternaGUI(100, 100);
        state = new MenuState(new Menu());
    }

    public static Main getInstance() throws IOException {
        if (instance == null){
            instance = new Main();
        }
        return instance;
    }

    public static void main(String[] args) throws IOException {
        getInstance().start();
    }

    public void setState(State state){
        this.state = state;
    }

    //TODO: DEFINE FRAME RATE
    private void start() throws IOException {
        int FPS = 1;
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
