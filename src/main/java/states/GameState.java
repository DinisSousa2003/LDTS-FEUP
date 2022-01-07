package states;

import controller.Controller;
import model.Game;
import viewer.Viewer;

public class GameState extends State<Game> {
    public GameState(Game game) {
        super(game);
    }

    @Override
    protected Viewer<Game> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Game> getController() {
        return new GameController(getModel());
    }
}