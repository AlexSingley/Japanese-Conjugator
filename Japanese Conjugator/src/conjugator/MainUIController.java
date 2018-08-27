package conjugator;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainUIController {

    @FXML
    private Button startButton;
    
    @FXML
    void changeToVerbConj(ActionEvent event) throws IOException {
    	Parent verbConjParent = FXMLLoader.load(getClass().getResource("ConjugationViewer.fxml"));
    	Scene verbConjScene = new Scene(verbConjParent);
    	
    	//Below gets the stage info
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(verbConjScene);
    }
}