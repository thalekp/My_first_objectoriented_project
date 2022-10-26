package minesweeper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Field{
    private boolean flag;
    private boolean open;
    private boolean bomb;
    private int x;
    private int y;
    private Easy board;
    private int display;

    public Field(int x, int y, Easy board, boolean hasBomb){
        this.board = board;
        checkBoardLimits(x);
        checkBoardLimits(y);
        this.x = x;
        this.y = y;
        this.bomb=hasBomb;
        this.flag = false;
        this.open = false;
        this.display = -1;
    }

    public Field(int x, int y, boolean hasBomb){
        this.x = x;
        this.y = y;
        this.bomb=hasBomb;
        this.flag = false;
        this.open = false;
        this.display = -1;
    }  
    
    private void checkBoardLimits(int value) throws IllegalArgumentException{
        if(this.board!=null){
            if(value>this.board.getMax()){
                throw new IllegalArgumentException("This field is outside the limits of the board");
            }
        }
    }

    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }

    public void open(){
        if(!this.flag){
            this.open = true;
            if(this.bomb){
                this.display = 10;
            }else{
                if(this.board!=null){
                    this.display = surroundingBombs();
                }
            }
        }
    }

    public void flag(){
        if(this.flag==true){
            this.flag=false;
            this.display=-1;
        }
        else{
            this.flag=true;
            this.display=20;
        }
    }
    
    public boolean getFlag(){
        return flag;
    }

    public boolean getOpen(){
        return open;
    }

    public boolean bomb(){
        return this.bomb;
    }

    public List<Field> findClose(){
        List<Field> fields = new ArrayList<>();
        if(!(this.x==0)){
            fields.add(board.getField(this.x-1, this.y));
            if(!(this.y==0)){
                fields.add(board.getField(this.x-1, this.y-1));
            }if(!(this.y==this.board.getMax())){
                fields.add(board.getField(this.x-1, this.y+1));
            }
        }if(!(this.x==this.board.getMax())){
            fields.add(board.getField(this.x+1, this.y));
            if(!(this.y==0)){
                fields.add(board.getField(this.x+1, this.y-1));
            }if(!(this.y==this.board.getMax())){
                fields.add(board.getField(this.x+1, this.y+1));
            }
        }if(!(this.y==0)){
            fields.add(board.getField(this.x, this.y-1));
        }if(!(this.y==this.board.getMax())){
            fields.add(board.getField(this.x, this.y+1));
        }return fields;
    }

    private int surroundingBombs(){
        int bombCount = 0;
        for (int i=0; i<findClose().size(); i++){
            if(findClose().get(i).bomb){
                bombCount+=1;
            }
        }return bombCount;
    }

    public int getDisplay(){
        return this.display;
    }

    public String toString(){
        return String.valueOf(this.bomb)+","+String.valueOf(this.flag)+","+String.valueOf(this.open);
    }

}

