package Tetris.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Color{
    private final Map<String, String> COLORS = new HashMap<String, String>();
    private final Map<String, String> SHADOW_COLORS = new HashMap<String, String>();
    private final List<String> RAINBOW = new ArrayList<>();

    public Color(){
        loadCOLORS();
        loadRAINBOW();
        loadShadowColors();
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

    private void loadShadowColors() {   //mudar as cores
        SHADOW_COLORS.put("CYAN", "#004444");
        SHADOW_COLORS.put("YELLOW", "#444400");
        SHADOW_COLORS.put("PURPLE", "#330033");
        SHADOW_COLORS.put("GREEN", "#004400");
        SHADOW_COLORS.put("RED", "#440000");
        SHADOW_COLORS.put("BLUE", "#000044");
        SHADOW_COLORS.put("ORANGE", "#552200");
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

    public String getShadowColor(String color){
        return SHADOW_COLORS.get(color);
    }
}

