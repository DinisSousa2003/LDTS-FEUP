import gui.LanternaGUI;
import model.Game;
import model.Menu;
import states.MenuState;
import states.State;

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

    private void start() throws IOException {
        int FPS = 1; //we can change the frame time anytime
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
