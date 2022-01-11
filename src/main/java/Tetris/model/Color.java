package Tetris.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Color{
    private Map<String, String> COLORS = new HashMap<String, String>();
    private List<String> RAINBOW = new ArrayList<>();

    public Color(){
        loadCOLORS();
        loadRAINBOW();
    }

    private void loadCOLORS(){
        COLORS.put("CYAN", "#00FFFF");
        COLORS.put("YELLOW", "#FFFF00");
        COLORS.put("PURPLE", "#800080");
        COLORS.put("GREEN", "#00FF00");
        COLORS.put("RED", "#FF0000");
        COLORS.put("BLUE", "#0000FF");
        COLORS.put("ORANGE", "#FF7F00");
        COLORS.put("WHITE", "#FFFFFF");
    }

    private void loadRAINBOW(){
        RAINBOW.add("#00FFFF");
        RAINBOW.add("#FFFF00");
        RAINBOW.add("#800080");
        RAINBOW.add("#00FF00");
        RAINBOW.add("#FF0000");
        RAINBOW.add("#0000FF");
        RAINBOW.add("#FF7F00");
    }

    public Map<String, String> getCOLORS() {
        return COLORS;
    }

    public List<String> getRAINBOW(){
        return RAINBOW;
    }

    public String getColor(String color){
        return COLORS.get(color);
    }
}

