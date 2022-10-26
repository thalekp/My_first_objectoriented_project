package minesweeper;

import java.util.Iterator;

public class Game {
    private Board board;
    private EasyController controller;
    private boolean lost;
    private Player player;

    public Game(EasyController controller, Player player){
        this.controller = controller;
        this.lost=false;
        this.player = player;
    }

    public Game(Board board){
        board.setGame(this);
        this.board=board;
        this.lost=false;
    }

    public void randomBoard(char level){
        this.board = new Easy(this);
    }

    public void openField(Field field){
        if(!lost){
            board.openField(field);}
    }

    public void updateField(Field field, int content){
        if(this.controller!=null){
            int fieldNumber = 9*field.gety()+field.getx();
            controller.updateArea(fieldNumber, content);
        }
    }

    public void flagField(Field field){
        board.flagField(field);   
    }

    public void lost(){
        this.lost=true;
        if(this.controller!=null){
            controller.lost();
        }
    }

    public void setPlayer(Player player){
        this.player = player;
    }
    
    public Player getPlayer(){
        return this.player;
    }

    public Board getBoard(){
        return this.board;
    }

    public void save(){
        if(!board.getLost()){
            Save saver = new Save();
            saver.write(this);
        }
    }

    public void win(){
        this.controller.win();
    }

    public void setController(EasyController controller){
        this.controller=controller;
        Iterator<Field> iterator = this.board.iterator();
        while(iterator.hasNext()){
            Field field = iterator.next();
            updateField(field, field.getDisplay());
        }
    }

    public boolean getLost(){
        return this.lost;
    }
}
