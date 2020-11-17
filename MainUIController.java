package conjugator;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainUIController {
	private double x, y;
	
    @FXML
    private JFXButton verbButton;
    
    @FXML
    private JFXButton adjButton;
    
    @FXML
    void changeToVerbConj(ActionEvent actionEvent) throws IOException {
    	Parent verbConjParent = FXMLLoader.load(getClass().getResource("ConjugationViewer.fxml"));
    	Scene verbConjScene = new Scene(verbConjParent);
    	
    	//Below gets the stage info
    	Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    	
    	window.setScene(verbConjScene);
		
		verbConjParent.setOnMousePressed(event -> {
			x = event.getSceneX();
			y = event.getSceneY();
		});
		
		verbConjParent.setOnMouseDragged(event -> {
			window.setX(event.getScreenX() - x);
			window.setY(event.getScreenY() - y);
		});
		
		window.show();
    }
    
    @FXML
    void changeToAdjConj(ActionEvent actionEvent) throws IOException {
    	Parent adjConjParent = FXMLLoader.load(getClass().getResource("AdjConjugationViewer.fxml"));
    	Scene adjConjScene = new Scene(adjConjParent);
    	
    	//Below gets the stage info
    	Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    	
    	window.setScene(adjConjScene);
		
		adjConjParent.setOnMousePressed(event -> {
			x = event.getSceneX();
			y = event.getSceneY();
		});
		
		adjConjParent.setOnMouseDragged(event -> {
			window.setX(event.getScreenX() - x);
			window.setY(event.getScreenY() - y);
		});
		
		window.show();
    }
}