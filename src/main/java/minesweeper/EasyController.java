package minesweeper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class EasyController implements Initializable{
    private Game game;
    private Player player;

    @FXML
    private AnchorPane root;

    @FXML
    private GridPane grid;
    
    @FXML
    private Pane enen, enfire, ennull;

    @FXML
    private Pane ento;

    @FXML
    private Pane entre;

    @FXML
    private Pane enfem;

    @FXML
    private Pane enseks;

    @FXML
    private Pane ensyv;

    @FXML
    private Pane enåtte;

    @FXML
    private TextField filename;

    @FXML
    private Pane fireen;

    @FXML
    private Pane firefire;

    @FXML
    private Pane firenull;

    @FXML
    private Pane fireto;

    @FXML
    private Pane firefem;

    @FXML
    private Pane fireseks;

    @FXML
    private Pane firesyv;

    @FXML
    private Pane fireåtte;

    @FXML
    private Pane firetre;

    @FXML
    private Pane nullen;

    @FXML
    private Pane nullfire;

    @FXML
    private Pane nullnull;

    @FXML
    private Pane nullto;

    @FXML
    private Pane nulltre;

    @FXML
    private Pane toen;

    @FXML
    private Pane tofire;

    @FXML
    private Pane tonull;

    @FXML
    private Pane toto;

    @FXML
    private Pane tofem;

    @FXML
    private Pane toseks;

    @FXML
    private Pane tosyv;

    @FXML
    private Pane toåtte;

    @FXML
    private Pane totre;

    @FXML
    private Pane treen;

    @FXML
    private Pane trefire;

    @FXML
    private Pane trenull;

    @FXML
    private Pane treto;

    @FXML
    private Pane trefem;

    @FXML
    private Pane treseks;

    @FXML
    private Pane tresyv;

    @FXML
    private Pane treåtte;

    @FXML
    private Pane tretre;

    @FXML
    private Pane nullfem;

    @FXML
    private Pane nullseks;

    @FXML
    private Pane nullsyv;

    @FXML
    private Pane nullåtte;

    @FXML
    private Pane femnull;

    @FXML
    private Pane femen;

    @FXML
    private Pane femto;

    @FXML
    private Pane femtre;

    @FXML
    private Pane femfire;

    @FXML
    private Pane femfem;

    @FXML
    private Pane femseks;

    @FXML
    private Pane femsyv;

    @FXML
    private Pane femåtte;

    @FXML
    private Pane seksnull;

    @FXML
    private Pane seksen;

    @FXML
    private Pane seksto;

    @FXML
    private Pane sekstre;

    @FXML
    private Pane seksfire;

    @FXML
    private Pane seksfem;

    @FXML
    private Pane seksseks;

    @FXML
    private Pane sekssyv;

    @FXML
    private Pane seksåtte;

    @FXML
    private Pane syvnull;

    @FXML
    private Pane syven;

    @FXML
    private Pane syvto;

    @FXML
    private Pane syvtre;

    @FXML
    private Pane syvfire;

    @FXML
    private Pane syvfem;

    @FXML
    private Pane syvseks;

    @FXML
    private Pane syvsyv;

    @FXML
    private Pane syvåtte;

    @FXML
    private Pane åttenull;

    @FXML
    private Pane åtteen;

    @FXML
    private Pane åtteto;

    @FXML
    private Pane åttetre;

    @FXML
    private Pane åttefire;

    @FXML
    private Pane åttefem;

    @FXML
    private Pane åtteseks;

    @FXML
    private Pane åttesyv;

    @FXML
    private Pane åtteåtte;

    @FXML
    private Button lagre;
    
    private Pane[] panes;

    public void initialize(URL url, ResourceBundle bundle){
        Pane[] newPanes = {nullnull, ennull, tonull, trenull, firenull, femnull, seksnull, syvnull, åttenull, nullen, enen, toen, treen, fireen, femen, seksen, syven, åtteen, nullto, ento, toto, treto, fireto, femto, seksto, syvto, åtteto, nulltre, entre, totre, tretre, firetre, femtre, sekstre, syvtre, åttetre, nullfire, enfire, tofire, trefire, firefire, femfire, seksfire, syvfire, åttefire, nullfem, enfem, tofem, trefem, firefem, femfem, seksfem, syvfem, åttefem, nullseks, enseks, toseks, treseks, fireseks, femseks, seksseks, syvseks, åtteseks, nullsyv, ensyv, tosyv, tresyv, firesyv, femsyv, sekssyv, syvsyv, åttesyv, nullåtte, enåtte, toåtte, treåtte, fireåtte, femåtte, seksåtte, syvåtte, åtteåtte};
        this.panes = newPanes;
        for(Pane pane: panes){
            ImageView iv= new ImageView();
            Image lukket = new Image(getClass().getResourceAsStream("lukket.png"));
            iv.setImage(lukket);
            iv.fitWidthProperty().bind(pane.widthProperty());
            iv.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv);
        }
    }

    public void setGame(Game game){
        this.game=game;
        game.setController(this);
    }

    public void randomBoard(Player player){
        this.player = player;
        this.game= new Game(this, this.player);
        this.game.randomBoard('l');
    }


    private void delegate(MouseEvent event, int x, int y){
        if(event.getButton() == MouseButton.PRIMARY){
            game.openField(this.game.getBoard().getField(x, y));
        } else if(event.getButton() == MouseButton.SECONDARY){
            game.flagField(this.game.getBoard().getField(x, y));
        }
    }
    
    @FXML
    void enen(MouseEvent event) {
        delegate(event, 1,1);
    }

    @FXML
    void enfem(MouseEvent event) {
        delegate(event, 1, 5);
    }

    @FXML
    void enfire(MouseEvent event) {
        delegate(event, 1, 4);
    }

    @FXML
    void ennull(MouseEvent event) {
        delegate(event, 1, 0);
    }

    @FXML
    void enseks(MouseEvent event) {
        delegate(event, 1, 6);
    }

    @FXML
    void ensyv(MouseEvent event) {
        delegate(event, 1, 7);
    }

    @FXML
    void ento(MouseEvent event) {
        delegate(event, 1, 2);
    }

    @FXML
    void entre(MouseEvent event) {
        delegate(event, 1, 3);
    }

    @FXML
    void enåtte(MouseEvent event) {
        delegate(event, 1, 8);
    }

    @FXML
    void femen(MouseEvent event) {
        delegate(event, 5, 1);
    }

    @FXML
    void femfem(MouseEvent event) {
        delegate(event, 5, 5);
    }

    @FXML
    void femfire(MouseEvent event) {
        delegate(event, 5, 4);
    }

    @FXML
    void femnull(MouseEvent event) {
        delegate(event, 5, 0);
    }

    @FXML
    void femseks(MouseEvent event) {
        delegate(event, 5, 6);
    }

    @FXML
    void femsyv(MouseEvent event) {
        delegate(event, 5, 7);
    }

    @FXML
    void femto(MouseEvent event) {
        delegate(event, 5, 2);
    }

    @FXML
    void femtre(MouseEvent event) {
        delegate(event, 5, 3);
    }

    @FXML
    void femåtte(MouseEvent event) {
        delegate(event, 5, 8);
    }

    @FXML
    void fireen(MouseEvent event) {
        delegate(event, 4, 1);
    }

    @FXML
    void firefem(MouseEvent event) {
        delegate(event, 4, 5);
    }

    @FXML
    void firefire(MouseEvent event) {
        delegate(event, 4, 4);
    }

    @FXML
    void firenull(MouseEvent event) {
        delegate(event, 4, 0);
    }

    @FXML
    void fireseks(MouseEvent event) {
        delegate(event, 4, 6);
    }

    @FXML
    void firesyv(MouseEvent event) {
        delegate(event, 4, 7);

    }

    @FXML
    void fireto(MouseEvent event) {
        delegate(event, 4, 2);

    }

    @FXML
    void firetre(MouseEvent event) {
        delegate(event, 4, 3);
    }

    @FXML
    void fireåtte(MouseEvent event) {
        delegate(event, 4, 8);
    }

    @FXML
    void nullen(MouseEvent event) {
        delegate(event, 0,1);
    }

    @FXML
    void nullfem(MouseEvent event) {
        delegate(event, 0,5);
    }

    @FXML
    void nullfire(MouseEvent event) {
        delegate(event, 0,4);
    }

    @FXML
    void nullnull(MouseEvent event) {
        delegate(event, 0,0);
    }

    @FXML
    void nullseks(MouseEvent event) {
        delegate(event, 0,6);
    }

    @FXML
    void nullsyv(MouseEvent event) {
        delegate(event, 0,7);
    }

    @FXML
    void nullto(MouseEvent event) {
        delegate(event, 0,2);
    }

    @FXML
    void nulltre(MouseEvent event) {
        delegate(event, 0,3);
    }

    @FXML
    void nullåtte(MouseEvent event) {
        delegate(event, 0,8);
    }

    @FXML
    void seksen(MouseEvent event) {
        delegate(event, 6,1);
    }

    @FXML
    void seksfem(MouseEvent event) {
        delegate(event, 6,5);
    }

    @FXML
    void seksfire(MouseEvent event) {
        delegate(event, 6,4);
    }

    @FXML
    void seksnull(MouseEvent event) {
        delegate(event, 6,0);
    }

    @FXML
    void seksseks(MouseEvent event) {
        delegate(event, 6,6);
    }

    @FXML
    void sekssyv(MouseEvent event) {
        delegate(event, 6,7);
    }

    @FXML
    void seksto(MouseEvent event) {
        delegate(event, 6,2);

    }

    @FXML
    void sekstre(MouseEvent event) {
        delegate(event, 6,3);
    }

    @FXML
    void seksåtte(MouseEvent event) {
        delegate(event, 6,8);
    }

    @FXML
    void syven(MouseEvent event) {
        delegate(event, 7,1);
    }

    @FXML
    void syvfem(MouseEvent event) {
        delegate(event, 7,5);
    }

    @FXML
    void syvfire(MouseEvent event) {
        delegate(event, 7,4);
    }

    @FXML
    void syvnull(MouseEvent event) {
        delegate(event, 7,0);
    }

    @FXML
    void syvseks(MouseEvent event) {
        delegate(event, 7,6);
    }

    @FXML
    void syvsyv(MouseEvent event) {
        delegate(event, 7,7);
    }

    @FXML
    void syvto(MouseEvent event) {
        delegate(event, 7,2);
    }

    @FXML
    void syvtre(MouseEvent event) {
        delegate(event, 7,3);
    }

    @FXML
    void syvåtte(MouseEvent event) {
        delegate(event, 7,8);
    }

    @FXML
    void toen(MouseEvent event) {
        delegate(event, 2,1);
    }

    @FXML
    void tofem(MouseEvent event) {
        delegate(event, 2,5);
    }

    @FXML
    void tofire(MouseEvent event) {
        delegate(event, 2,4);

    }

    @FXML
    void tonull(MouseEvent event) {
        delegate(event, 2,0);

    }

    @FXML
    void toseks(MouseEvent event) {
        delegate(event, 2,6);

    }

    @FXML
    void tosyv(MouseEvent event) {
        delegate(event, 2,7);
    }

    @FXML
    void toto(MouseEvent event) {
        delegate(event, 2,2);

    }

    @FXML
    void totre(MouseEvent event) {
        delegate(event, 2,3);

    }

    @FXML
    void toåtte(MouseEvent event) {
        delegate(event, 2,8);

    }

    @FXML
    void treen(MouseEvent event) {
        delegate(event, 3,1);

    }

    @FXML
    void trefem(MouseEvent event) {
        delegate(event, 3,5);

    }

    @FXML
    void trefire(MouseEvent event) {
        delegate(event, 3,4);

    }

    @FXML
    void trenull(MouseEvent event) {
        delegate(event, 3,0);

    }

    @FXML
    void treseks(MouseEvent event) {
        delegate(event, 3,6);

    }

    @FXML
    void tresyv(MouseEvent event) {
        delegate(event, 3,7);

    }

    @FXML
    void treto(MouseEvent event) {
        delegate(event, 3,2);

    }

    @FXML
    void tretre(MouseEvent event) {
        delegate(event, 3,3);

    }

    @FXML
    void treåtte(MouseEvent event) {
        delegate(event, 3,8);

    }

    @FXML
    void åtteen(MouseEvent event) {
        delegate(event, 8,1);

    }

    @FXML
    void åttefem(MouseEvent event) {
        delegate(event, 8,5);

    }

    @FXML
    void åttefire(MouseEvent event) {
        delegate(event, 8,4);

    }

    @FXML
    void åttenull(MouseEvent event) {
        delegate(event, 8,0);

    }

    @FXML
    void åtteseks(MouseEvent event) {
        delegate(event, 8,6);

    }

    @FXML
    void åttesyv(MouseEvent event) {
        delegate(event, 8,7);

    }

    @FXML
    void åtteto(MouseEvent event) {
        delegate(event, 8,2);

    }

    @FXML
    void åttetre(MouseEvent event) {
        delegate(event, 8,3);
    }

    @FXML
    void åtteåtte(MouseEvent event) {
        delegate(event, 8,8);

    }

    public void updateArea(int paneNumber, int content){
            Pane pane = panes[paneNumber];
        if(content==10){
            ImageView iv_bomb= new ImageView();
            Image bombe = new Image(getClass().getResourceAsStream("bomb.png"));
            iv_bomb.setImage(bombe);
            iv_bomb.fitWidthProperty().bind(pane.widthProperty());
            iv_bomb.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_bomb);
        
        }else if(content==20){
            ImageView iv_flag= new ImageView();
            Image flagg = new Image(getClass().getResourceAsStream("flagged.png"));
            iv_flag.setImage(flagg);
            iv_flag.fitWidthProperty().bind(pane.widthProperty());
            iv_flag.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_flag);

        }else if(content==-1){
            ImageView iv= new ImageView();
            Image lukket = new Image(getClass().getResourceAsStream("lukket.png"));
            iv.setImage(lukket);
            iv.fitWidthProperty().bind(pane.widthProperty());
            iv.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv);
        }else if(content==0){
            ImageView iv_0= new ImageView();
            Image ingenting = new Image(getClass().getResourceAsStream("0.png"));
            iv_0.setImage(ingenting);
            iv_0.fitWidthProperty().bind(pane.widthProperty());
            iv_0.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_0);
        }else if(content==1){
            ImageView iv_1= new ImageView();
            Image en = new Image(getClass().getResourceAsStream("1.png"));
            iv_1.setImage(en);
            iv_1.fitWidthProperty().bind(pane.widthProperty());
            iv_1.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_1);
        }else if(content==2){
            ImageView iv_2= new ImageView();
            Image to = new Image(getClass().getResourceAsStream("2.png"));
            iv_2.setImage(to);
            iv_2.fitWidthProperty().bind(pane.widthProperty());
            iv_2.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_2);
        }else if(content==3){
            ImageView iv_3= new ImageView();
            Image tre = new Image(getClass().getResourceAsStream("3.png"));
            iv_3.setImage(tre);
            iv_3.fitWidthProperty().bind(pane.widthProperty());
            iv_3.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_3);
        }else if(content==4){
            ImageView iv_4= new ImageView();
            Image fire = new Image(getClass().getResourceAsStream("4.png"));
            iv_4.setImage(fire);
            iv_4.fitWidthProperty().bind(pane.widthProperty());
            iv_4.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_4);
        }else if(content==5){
            ImageView iv_5= new ImageView();
            Image fem = new Image(getClass().getResourceAsStream("5.png"));
            iv_5.setImage(fem);
            iv_5.fitWidthProperty().bind(pane.widthProperty());
            iv_5.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_5);
        }else if(content==6){
            ImageView iv_6= new ImageView();
            Image seks = new Image(getClass().getResourceAsStream("5.png"));
            iv_6.setImage(seks);
            iv_6.fitWidthProperty().bind(pane.widthProperty());
            iv_6.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_6);
        }else if(content==7){
            ImageView iv_7= new ImageView();
            Image syv = new Image(getClass().getResourceAsStream("5.png"));
            iv_7.setImage(syv);
            iv_7.fitWidthProperty().bind(pane.widthProperty());
            iv_7.fitHeightProperty().bind(pane.heightProperty());
            pane.getChildren().add(iv_7);
        }
    }

    public void lost(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Lost.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage newStage = new Stage();
            LostController nykontroller = loader.getController();
            nykontroller.setRoot(this.root);
            nykontroller.setLostStage(newStage);
            nykontroller.setSpill(this.game);
            newStage.setTitle("Du tapte:(");
            newStage.setScene(new Scene(root1));
            newStage.show();

        }catch (IOException e){
            System.out.println("Klarte ikke å laste inn vinduet som forteller deg at du har tapt");
        }
    }

    @FXML
    void handleSave(MouseEvent event){
        game.save();
    }

    public void win(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Win.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage newStage = new Stage();
            WinController newController = loader.getController();
            newStage.setTitle("Du vant!");
            newStage.setScene(new Scene(root1));
            newStage.show();

        }catch (IOException e){
            System.out.println("Du vant!");
        }
    } 
    

}





