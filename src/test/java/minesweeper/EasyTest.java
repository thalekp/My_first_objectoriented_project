package minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

import minesweeper.Easy;
import minesweeper.Field;

public class EasyTest {
    private Easy board;
    private List<Field> fieldList;


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
        this.fieldList = new ArrayList<>();
        Iterator<Field> iterator = board.iterator();
        while(iterator.hasNext()){
            fieldList.add(iterator.next());
        }

    }
    

    @Test
    public void testConstructor(){
        assertEquals(81, board.stringArray().length);
        assertThrows(IllegalArgumentException.class, ()->{
            Easy illegalBoard = new Easy(true, true, false);
        });

        List<Field> bombs = this.fieldList.stream().filter(field -> field.bomb()).toList();
        List<Field> opened = this.fieldList.stream().filter(field -> field.getOpen()).toList();
        List<Field> flagged = this.fieldList.stream().filter(field -> field.getFlag()).toList();
    
        assertEquals(5, bombs.size());
        assertEquals(0, opened.size());
        assertEquals(0, flagged.size());

        assertEquals(true, board.getField(1, 1).bomb());
        assertEquals(true, board.getField(4, 4).bomb());
        assertEquals(true, board.getField(0, 6).bomb());
        assertEquals(true, board.getField(8, 7).bomb());
        assertEquals(true, board.getField(8, 8).bomb());

    }

    @Test
    public void testFieldLimits(){
        assertThrows(IllegalArgumentException.class, () ->{
            Field illegalField = new Field(10, 1, board, true);
        });
    }

    @Test
    public void testFieldCloseFields(){
        assertEquals(8, board.getField(2, 2).findClose().size());
        assertEquals(3, board.getField(0, 0).findClose().size());
        assertEquals(3, board.getField(0, 8).findClose().size());
        assertEquals(3, board.getField(8, 0).findClose().size());
        assertEquals(3, board.getField(8, 8).findClose().size());
        assertEquals(5, board.getField(0, 2).findClose().size());
        assertEquals(5, board.getField(8, 2).findClose().size());   
    }

    @Test
    public void testFieldDisplay(){
        assertEquals(-1, board.getField(6, 6).getDisplay());
        board.openField(board.getField(6,6));
        assertEquals(0, board.getField(6, 6).getDisplay());
        assertEquals(-1, board.getField(8, 8).getDisplay());
        assertEquals(-1, board.getField(4, 4).getDisplay());
        assertEquals(0, board.getField(3, 2).getDisplay());
        assertEquals(1, board.getField(4, 5).getDisplay());
        board.flagField(board.getField(4, 4));
        assertEquals(20, board.getField(4, 4).getDisplay());
        board.openField(board.getField(4, 4));
        assertEquals(20, board.getField(4, 4).getDisplay());
        board.flagField(board.getField(4, 4));
        assertEquals(-1, board.getField(4, 4).getDisplay());
        board.openField(board.getField(4, 4));
        assertEquals(10, board.getField(4, 4).getDisplay());

    }

    @Test
    public void testOpenRute(){
        assertThrows(IllegalArgumentException.class, () ->{
            board.openField(new Field(8, 10, board, true));
        });
        assertThrows(IllegalArgumentException.class, () ->{
            board.openField(new Field(8, 1, board, true));
        });

        for(Field field:fieldList){
            assertEquals(false, field.getOpen());
            assertEquals(-1, field.getDisplay());
        }

        board.openField(board.getField(4, 7));
        assertEquals(true, board.getField(4, 7).getOpen());
        assertEquals(true, board.getField(4, 8).getOpen());
        assertEquals(true, board.getField(4, 6).getOpen());
        assertEquals(true, board.getField(4, 5).getOpen());
        assertEquals(true, board.getField(3, 7).getOpen());
        assertEquals(true, board.getField(2, 7).getOpen());
        assertEquals(true, board.getField(1, 7).getOpen());
        assertEquals(true, board.getField(0, 7).getOpen());
        assertEquals(true, board.getField(5, 7).getOpen());
        assertEquals(true, board.getField(6, 7).getOpen());
        assertEquals(true, board.getField(0, 8).getOpen());
        assertEquals(true, board.getField(1, 8).getOpen());
        assertEquals(true, board.getField(2, 8).getOpen());
        assertEquals(true, board.getField(3, 8).getOpen());
        assertEquals(true, board.getField(5, 8).getOpen());
        assertEquals(true, board.getField(6, 8).getOpen());
        assertEquals(true, board.getField(7, 8).getOpen());
        assertEquals(true, board.getField(0, 8).getOpen());

        assertEquals(-1, board.getField(0, 0).getDisplay());
        assertEquals(2, board.getField(7, 7).getDisplay());

        board.openField(board.getField(4, 4));
        assertEquals(10, board.getField(4, 4).getDisplay());
        assertEquals(true, board.getLost());
    }

    @Test
    public void testFlag(){
        assertThrows(IllegalArgumentException.class, () ->{
            board.flagField(new Field(8, 10, board, true));
        });
        assertThrows(IllegalArgumentException.class, () ->{
            board.flagField(new Field(8, 1, board, true));
        });

        board.flagField(board.getField(4, 7));
        board.openField(board.getField(4, 7));
        assertEquals(false, board.getField(4, 7).getOpen());
        assertEquals(20, board.getField(4, 7).getDisplay());
        board.flagField(board.getField(4, 7));
        assertEquals(false, board.getField(4,7).getOpen());
        assertEquals(-1, board.getField(4,7).getDisplay());

        board.flagField(board.getField(4, 4));
        assertEquals(true, board.getField(4, 4).getFlag());
        assertEquals(20, board.getField(4, 4).getDisplay());
        assertEquals(4, board.getUndetected());
        board.openField(board.getField(4, 4));
        assertEquals(true, board.getField(4, 4).getFlag());
        assertEquals(20, board.getField(4, 4).getDisplay());
        assertEquals(4, board.getUndetected());
        assertEquals(false, board.getLost());
        board.flagField(board.getField(4, 4));
        assertEquals(false, board.getField(4, 4).getFlag());
        assertEquals(-1, board.getField(4, 4).getDisplay());
        assertEquals(5, board.getUndetected());
        assertEquals(false, board.getLost());
        board.openField(board.getField(4, 4));
        assertEquals(false, board.getField(4, 4).getFlag());
        assertEquals(10, board.getField(4, 4).getDisplay());
        assertEquals(true, board.getLost());
    }

    @Test
    public void testGetField(){
        assertThrows(IllegalArgumentException.class, () ->{
            board.getField(-1, 0);
        });
        assertThrows(IllegalArgumentException.class, () ->{
            board.getField(10, 0);
        });
        assertThrows(IllegalArgumentException.class, () ->{
            board.getField(1, 20);
        });

        assertEquals(this.fieldList.get(0), board.getField(0, 0));
        assertEquals(this.fieldList.get(80), board.getField(8, 8));
        assertEquals(this.fieldList.get(5), board.getField(5, 0));
        assertEquals(this.fieldList.get(10), board.getField(1, 1));
    }

    @Test
    public void testStringArray(){
        for(int i=0; i<81; i++){
            assertEquals(this.fieldList.get(i).toString(), board.stringArray()[i]);
        }
    }

    
}
