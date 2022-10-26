package minesweeper;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Easy implements Board{
    private Field[][] board;
    private boolean lost;
    private int max=8;
    private Game game;
    private List<Field> bombs;
    private int undetected;

    public Easy(Game game){
        this.game=game;
        this.undetected=10;
        Field[][] newBoard = new Field[9][9];
        this.lost=false;
        Random random = new Random();
        List<Integer> bombs = new ArrayList<>();
        List<Field> bombFields = new ArrayList<>();
        while (bombs.size()<10){
            int field = random.nextInt(80);
            if(!bombs.contains(field)){
                bombs.add(field);
            }     
        }
        int fieldNumber= 0;
        boolean hasBomb = false;
        for (int i=0; i<9;i++){
            for (int j=0; j<9; j++){
                if(bombs.contains(fieldNumber)){
                    hasBomb=true;
                }else{
                    hasBomb=false;
                }
                Field newField = new Field(i, j, this, hasBomb);
                if(hasBomb){
                    bombFields.add(newField);
                }
                newBoard[i][j]=newField;
                fieldNumber+=1;
            }

        }
        this.bombs=bombFields;
        this.board=newBoard;
    }

    public Easy(boolean... board){
        checkBoardSize(board);
        this.undetected=0;
        Field[][] newBoard = new Field[9][9];
        List<Field> bombFields = new ArrayList<>();
        int i=0;
        for (int y=0; y<9; y++){
            for(int x=0; x<9; x++){
                Field newField = new Field(x, y, this, board[i]);
                if(board[i]){
                    bombFields.add(newField);
                    this.undetected+=1;
                }
                newBoard[x][y]=newField;
                i+=1;
            }
        }
        this.board = newBoard;
        this.bombs=bombFields;
    }

    private void checkBoardSize(boolean[] array) throws IllegalArgumentException{
        if(array.length!=81){
            throw new IllegalArgumentException("The board is the wrong size");
        }
    }

    public void openField(Field field){
        checkContains(field);
        field.open();
        if(game!=null){
            game.updateField(field, field.getDisplay());
        }
        if(field.bomb()&&(!(field.getFlag()))){
            lost=true;
            if(this.game!=null){
                game.lost();}
        }else{
            if(field.getDisplay()==0){
                for(int i=0; i<field.findClose().size(); i++){
                    Field thisField = field.findClose().get(i);
                    if(!(thisField.getOpen())){
                        openField(thisField);
                    }
                }
            }

        }
    }

    private void checkContains(Field field) throws IllegalArgumentException{
        boolean contains = false;
        Iterator<Field> iterator = this.iterator();
        while(iterator.hasNext()){
            if(iterator.next()==field){
                contains=true;
            }
        }
        if(!contains){
            throw new IllegalArgumentException("The board does not contains this field");
        }
    
    }

    public void flagField(Field field){
        checkContains(field);
        field.flag();
        if(game!=null){
            game.updateField(field, field.getDisplay());
        }
        if(field.getFlag()){
            if(this.bombs.contains(field)){
                int newUndetected = this.undetected-1;
                this.undetected=newUndetected;
            }if(this.undetected==0&&this.game!=null){
                this.game.win();
            }
        }else{
            if(this.bombs.contains(field)){
                int nyUdetektert = this.undetected+1;
                this.undetected=nyUdetektert;
            }
        }
    }

    private void checkSize(int i) throws IllegalArgumentException{
        if(i>8||i<0){
            throw new IllegalArgumentException("This if outside of the bounds of the board");
        }
    }
    
    public Field getField(int x, int y){
        checkSize(x);
        checkSize(y);
        return board[x][y];
    }

    public int getMax(){
    return this.max;
    }

    public Field[][] getArray(){
        return this.board;
    }

    public boolean getLost(){
        return this.lost;
    }

    public String[] stringArray(){
        String[] fields = new String[81];
        int index = 0;
        Iterator<Field> iterator = this.iterator();
        while(iterator.hasNext()){
            fields[index]=iterator.next().toString();
            index+=1;
        }return fields;
    }

    public void setGame(Game game){
        this.game=game;
    }

    public int getUndetected(){
        return this.undetected;
    }

    @Override
    public Iterator<Field> iterator() {
        List<Field> boardAsList = new ArrayList<>();
        for(int y=0; y<9; y++){
            for(int x=0; x<9; x++){
                boardAsList.add(getField(x, y));
            }
        }
        return boardAsList.iterator();
    }
}

