package Tetris.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {

    private final List<String> entries;
    private int currentEntry = 0;

    public Menu(){
        this.entries = Arrays.asList("Play", "Controls", "Exit");
    }

    public int getCurrentEntry() {
        return currentEntry;
    }

    public boolean isSelected(int i){
        return i == getCurrentEntry();
    }

    public boolean isSelectedPlay(){
        return isSelected(0);
    }

    public boolean isSelectedRules(){
        return isSelected(1);
    }

    public boolean isSelectedExit(){
        return isSelected(2);
    }

    public int getNumEntries() {
        return entries.size();
    }

    public void nextEntry(){
        currentEntry++;
        if (currentEntry > getNumEntries() - 1){
            currentEntry = 0;
        }
    }

    public void previousEntry(){
        currentEntry--;
        if (currentEntry < 0){
            currentEntry = getNumEntries() -1;
        }
    }

    public String getEntryName(int i){
        return entries.get(i);
    }
}
