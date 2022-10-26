package minesweeper;

import java.io.FileNotFoundException;

public interface FileHandling {
    public void write(Game game);
    public Game get(String name) throws FileNotFoundException;
    
}
