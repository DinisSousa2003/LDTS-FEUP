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
        COLORS.put("LIGHT_GRAY","#B3B3B3");
        COLORS.put("GRAY","#666666");
        COLORS.put("DARKER_GRAY","#4B4B4B");

    }

    private void loadRAINBOW(){
        RAINBOW.add("#FF0000");
        RAINBOW.add("#FF7F00");
        RAINBOW.add("#FFFF00");
        RAINBOW.add("#00FF00");
        RAINBOW.add("#00FFFF");
        RAINBOW.add("#0000FF");
        RAINBOW.add("#800080");
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

