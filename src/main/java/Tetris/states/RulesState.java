package Tetris.states;

import Tetris.controller.Controller;
import Tetris.controller.RulesController;
import Tetris.model.Rules;
import Tetris.viewer.RulesViewer;
import Tetris.viewer.Viewer;

public class RulesState extends State<Rules>{
    public RulesState(Rules model){
        super(model);
    }

    @Override
    protected Viewer<Rules> getViewer() {
        return new RulesViewer(getModel());
    }

    @Override
    protected Controller<Rules> getController() {
        return new RulesController(getModel());
    }
}
