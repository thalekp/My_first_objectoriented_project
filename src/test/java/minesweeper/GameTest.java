package minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import minesweeper.Easy;
import minesweeper.Field;


public class GameTest {
    private Board board;
    private Game game;
    private Player player;

    @BeforeEach
    public void setup(){
        this.board = new Easy(false, false,false,false,false,false,false,false,false,
        false,true,false,false,false,false,false,false,false,
        false,false,false,false,false,false,false,false,false,
        false,false,false,false,false,false,false,false,false,
        false,false,false,false,true,false,false,false,false,
        false,false,false,false,false,false,false,false,false,
        true,false,false,false,false,false,false,false,false,
        false,false,false,false,false,false,false,false,true,
        false,false,false,false,false,false,false,false,true);
        this.game=new Game(board);
        this.player = new Player("Ola");
        game.setPlayer(player);
    }

    @Test
    public void testConstructor(){
        assertEquals(board, game.getBoard());
        assertEquals(player, game.getPlayer());
        assertEquals(false, game.getLost());

    }

    @Test
    public void testOpen(){
        game.openField(board.getField(6, 2));
        assertEquals(false, game.getLost());
        assertEquals(true, game.getBoard().getField(6, 2).getOpen());
        assertEquals(true, game.getBoard().getField(6, 0).getOpen());
        assertEquals(true, game.getBoard().getField(6, 1).getOpen());
        assertEquals(true, game.getBoard().getField(6, 3).getOpen());
        assertEquals(true, game.getBoard().getField(7, 2).getOpen());
        assertEquals(true, game.getBoard().getField(7, 0).getOpen());
        assertEquals(true, game.getBoard().getField(7, 1).getOpen());
        assertEquals(true, game.getBoard().getField(7, 3).getOpen());
        assertEquals(true, game.getBoard().getField(2, 2).getOpen());
        assertEquals(true, game.getBoard().getField(2, 0).getOpen());
        assertEquals(true, game.getBoard().getField(2, 1).getOpen());

        assertEquals(false, game.getBoard().getField(4, 4).getOpen());
        game.openField(board.getField(4,4));
        assertEquals(true, game.getLost());
        assertEquals(true, game.getBoard().getField(4, 4).getOpen());
        assertEquals(false, game.getBoard().getField(0, 0).getOpen());
        game.openField(board.getField(0,0));
        assertEquals(false, game.getBoard().getField(0, 0).getOpen());

    }

    @Test
    public void testFlag(){
        game.flagField(board.getField(4,7));
        game.openField(board.getField(4,7));
        assertEquals(true, game.getBoard().getField(4,7).getFlag());
        assertEquals(false, game.getBoard().getField(4, 7).getOpen());
        game.openField(board.getField(5,7));
        assertEquals(true, game.getBoard().getField(5, 7).getOpen());
        assertEquals(true, game.getBoard().getField(5, 6).getOpen());
        assertEquals(true, game.getBoard().getField(5, 8).getOpen());
        assertEquals(true, game.getBoard().getField(4, 6).getOpen());
        assertEquals(true, game.getBoard().getField(5, 8).getOpen());
        assertEquals(false, game.getBoard().getField(4, 7).getOpen());

        game.flagField(board.getField(8,8));
        assertEquals(4, game.getBoard().getUndetected());

    }


    
}
