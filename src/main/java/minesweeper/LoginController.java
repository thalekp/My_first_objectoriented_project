package minesweeper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class LoginController implements Initializable{

    @FXML
    private AnchorPane root;

    @FXML
    private TextField username;

    @FXML
    private Label label_username;

    @FXML
    private Label message;

    @FXML
    private Button easy;

    @FXML
    void easy(MouseEvent event) throws IOException {
        try{Player player = new Player(this.username.getText());
                try{
                    Save saver = new Save();
                    Game game = saver.get(username.getText());
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Lett.fxml"));
                    Parent gameParent = loader.load();
                    Scene gameScene = new Scene(gameParent);
                    EasyController newController = loader.getController();
                    newController.setGame(game);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(gameScene);
                    window.show();
                }catch(FileNotFoundException e){
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Lett.fxml"));
                    Parent gameParent = loader.load();
                    Scene gameScene = new Scene(gameParent);
                    EasyController newController = loader.getController();
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    newController.randomBoard(player);
                    window.setScene(gameScene);
                    window.show();
                }
            }catch(IllegalArgumentException e){
                message.setText(e.getMessage());
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle bundle){
    }
    
}
