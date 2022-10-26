package minesweeper;

public interface Board extends Iterable<Field>{
    public void openField(Field field);
    public void flagField(Field field);
    public Field getField(int x, int y);
    public int getMax();
    public Field[][] getArray();
    public boolean getLost();
    public String[] stringArray();
    public void setGame(Game spill);
    public int getUndetected();
}
