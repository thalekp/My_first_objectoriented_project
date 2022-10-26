package minesweeper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Iterator;

public class Save implements FileHandling {
    private Player player;

    public Save() {
    }

    public void write(Game game) {
        try {
            PrintWriter writer = new PrintWriter(new File(game.getPlayer().getName() + ".txt"));
            writer.println(game.getPlayer().getName());
            for (String item : game.getBoard().stringArray()) {
                writer.println(item);
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public Game get(String navn) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(navn + ".txt"));
        boolean[] bombs = new boolean[81];
        boolean[] flags = new boolean[81];
        boolean[] opened = new boolean[81];
        int i = 0;
        while (scanner.hasNextLine()) {
            if (i == 0) {
                this.player = new Player(scanner.nextLine());
                checkName(this.player.getName());
            } else {
                String output = scanner.nextLine();
                String[] info = output.split(",", 0);
                checkLine(info);
                bombs[i - 1] = toBoolean(info[0]);
                flags[i - 1] = toBoolean(info[1]);
                opened[i - 1] = toBoolean(info[2]);
            }
            i += 1;
        }
        checkLength(i);
        Board board = new Easy(bombs);
        Game newGame = new Game(board);
        newGame.setPlayer(player);
        Iterator<Field> flagIterator = board.iterator();
        int flag_index = 0;
        while (flagIterator.hasNext()) {
            Field flagField = flagIterator.next();
            if (flags[flag_index]) {
                newGame.flagField(flagField);
            }
            flag_index += 1;
        }
        int open_index = 0;
        Iterator<Field> openIterator = board.iterator();
        while (openIterator.hasNext()) {
            Field openField = openIterator.next();
            if (opened[open_index]) {
                newGame.openField(openField);
            }
            open_index += 1;
        }
        return newGame;

    }

    private void checkName(String input) throws FileNotFoundException {
        if (input.contains(" ")) {
            throw new FileNotFoundException("The name can only contain one word");
        }
    }

    private void checkLength(int i) throws FileNotFoundException {
        if (i != 82) {
            throw new FileNotFoundException("The length of this file is invalid");
        }
    }

    private void checkLine(String[] line) throws FileNotFoundException {
        if (line.length != 3) {
            throw new FileNotFoundException("a line in the file is invalid");
        }
    }

    private boolean toBoolean(String input) {
        if (input.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

}
