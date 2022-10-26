package minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import minesweeper.Easy;
import minesweeper.Field;

public class FieldTest{
    private Field field1;
    private Field field2;
    
    @BeforeEach
    public void setup(){
        this.field1 = new Field(1, 1, false);
        this.field2 = new Field(4, 4, true);
    }

    @Test 
    public void testConstructor(){
        assertEquals(false, field1.getFlag());
        assertEquals(false, field1.getOpen());
        assertEquals(false, field1.bomb());
        assertEquals(1, field1.getx());
        assertEquals(1, field1.gety());
        assertEquals(true, (field1.getDisplay()==-1));

        assertEquals(false, field2.getFlag());
        assertEquals(false, field2.getOpen());
        assertEquals(true, field2.bomb());
        assertEquals(4, field2.getx());
        assertEquals(4, field2.gety());
        assertEquals(true, (field2.getDisplay()==-1));
    }

    @Test
    public void testOpen(){
        field1.open();
        assertEquals(true, field1.getOpen());
        assertEquals("false,false,true", field1.toString());

        field2.open();
        assertEquals(true, field2.getOpen());
        assertEquals(10, field2.getDisplay());
        assertEquals("true,false,true", field2.toString());
    }

    @Test
    public void testFlag(){
        field1.flag();
        field1.open();
        assertEquals(true, field1.getFlag());
        assertEquals(false, field1.getOpen());
        assertEquals(20, field1.getDisplay());
        assertEquals("false,true,false", field1.toString());

        field2.open();
        assertEquals(true, field2.getOpen());
        assertEquals(10, field2.getDisplay());
        assertEquals("true,false,true", field2.toString());
    }

}