package minesweeper;

public class Player {
    private String name;
    private Game game;

    public Player(String name){
        if(name==""||name==null){
            throw new IllegalArgumentException("Spilleren må ha et navn");
        }else if(name.contains(" ")){
            throw new IllegalArgumentException("Brukernavnet kan ikke inneholde mellomrom");
        }else{this.name=name;}
    }

    public void setName(String newName){
        if(newName==""||newName==null){
            throw new IllegalArgumentException("Spilleren må ha et navn");
        }else if(newName.contains(" ")){
            throw new IllegalArgumentException("Brukernavnet kan ikke inneholde mellomrom");
        }else{this.name=newName;}
    }

    public void setGame(Game newGame){
        this.game=newGame;
    }
    
    public String getName(){
        return name;
    }

    public Game getGame(){
        return game;
    }

    
}
