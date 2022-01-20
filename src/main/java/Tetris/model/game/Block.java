package Tetris.model.game;

import Tetris.model.Color;

public class Block {

    private final String color;

    public Block(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}
