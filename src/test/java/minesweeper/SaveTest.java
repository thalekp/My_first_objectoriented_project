package minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import minesweeper.Easy;
import minesweeper.Field;

public class SaveTest {
    private Game game;
    private Game retreived;

    @BeforeEach
    public void setup() {
        Board brett = new Easy(false, false, false, false, false, false, false, false, false,
                false, true, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, true, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                true, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, true,
                false, false, false, false, false, false, false, false, true);
        this.game = new Game(brett);

        Board falseBrett = new Easy(false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false);
        this.retreived = new Game(falseBrett);
    }

    @Test
    public void testUntouchedGame() {
        game.setPlayer(new Player("testUntouched"));
        checkEqualGames("testUntouched");
    }

    @Test
    public void testOpen() {
        game.setPlayer(new Player("testOpen"));
        game.openField(game.getBoard().getField(6, 2));
        checkEqualGames("testOpen");
    }

    @Test
    public void testOpenAndFlags() {
        game.setPlayer(new Player("testFlags"));
        game.flagField(game.getBoard().getField(6, 2));
        game.openField(game.getBoard().getField(6, 2));
        checkEqualGames("testFlags");
    }

    @Test
    public void testLostGame() {
        game.setPlayer(new Player("TestLost"));
        game.openField(game.getBoard().getField(4, 4));
        Save lagre = new Save();
        game.save();
        assertThrows(FileNotFoundException.class, () -> {
            lagre.get("TestLost");
        });
    }

    @Test
    public void testInvalidFile() {
        Save saver = new Save();
        assertThrows(FileNotFoundException.class, () -> {
            Game invalid = saver.get("InvalidFile");
        });
    }

    public void checkEqualGames(String name) {
        Save save = new Save();
        save.write(this.game);
        try {
            this.retreived = save.get(name);
        } catch (FileNotFoundException e) {
            this.retreived.setPlayer(new Player("ugyldig"));
        }
        assertEquals(name, retreived.getPlayer().getName());
        for (int i = 0; i < 81; i++) {
            assertEquals(game.getBoard().stringArray()[i], retreived.getBoard().stringArray()[i]);

        }
    }

}
