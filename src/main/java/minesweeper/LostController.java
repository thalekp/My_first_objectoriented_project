package minesweeper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LostController implements Initializable{
    private Parent gameRoot;
    private Stage stage;
    private Game game;

    public void initialize(URL url, ResourceBundle rb){

    }

    public void setRoot(Parent root){
        this.gameRoot=root;
    }

    public void setLostStage(Stage stage){
        this.stage = stage;
    }

    public void setSpill(Game game){
        this.game = game;

    }

    @FXML
    private Button button;

    @FXML
    void restart(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lett.fxml"));
        this.gameRoot = loader.load();
        Scene gameScene = new Scene(gameRoot);
        EasyController newController = loader.getController();
        newController.randomBoard(this.game.getPlayer());
        Stage stage = new Stage();
        stage.setScene(gameScene);
        stage.show();
        this.stage.close();
    }





}

