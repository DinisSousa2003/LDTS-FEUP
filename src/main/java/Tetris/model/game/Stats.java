package Tetris.model.game;

public class Stats {
    private int lines;
    private int points;
    private int level;

    public Stats(){
        lines = 0;
        points = 0;
        level = 1;
    }

    public void removedLines(int l){
        lines += l;

        switch (l){
            case 0:
                break;
            case 1:
                points += 10*level;
                break;
            case 2:
                points += 30*level;
                break;
            case 3:
                points += 50*level;
                break;
            case 4:
                points += 80*level;
        }

        if(lines - level*10 >= 0){
            level++;
        }
    }

    public int getLevel(){
         return level;
    }

    public int getLines() {
        return lines;
    }

    public int getPoints() {
        return points;
    }
}
