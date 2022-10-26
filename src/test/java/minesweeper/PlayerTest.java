package minesweeper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import minesweeper.Easy;
import minesweeper.Field;


public class PlayerTest {
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setup(){
        this.player1= new Player("Player1");
        this.player2= new Player("Player2");
    }

    @Test
    public void testName(){
        assertThrows(IllegalArgumentException.class, ()->{
            Player illegalPlayer = new Player("");
        });

        assertThrows(IllegalArgumentException.class, ()->{
            Player illegalPlayer = new Player(null);
        });

        assertThrows(IllegalArgumentException.class, ()->{
            Player illegalPlayer = new Player("Ola Norman");
        });

        assertThrows(IllegalArgumentException.class, ()->{
            player1.setName("");
        });

        assertThrows(IllegalArgumentException.class, ()->{
            player1.setName(null);
        });

        assertThrows(IllegalArgumentException.class, ()->{
            player1.setName("Ola Norman");
        });
    }


}   
