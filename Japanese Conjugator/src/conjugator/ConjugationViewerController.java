package conjugator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;

public class ConjugationViewerController extends AnchorPane implements Initializable {

    @FXML
    private AnchorPane verbConjugatorPanel;
    
    @FXML
    private JFXListView<String> conjugationList;
    
	@FXML
    void setInput() {
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	conjugationList.getItems().addAll("1. Non-Past Plain", "2. Non-Past Polite", "3. Past Plain",
    			"4. Past Polite", "5. Te-Form", "6. Potential Plain", "7. Potential Polite", "8. Passive Plain",
    			"9. Passive Polite", "10. Causative Plain", "11. Causative Polite", "12. Causative Passive Plain",
    			"13. Causative Passive Polite", "14. Imperative", "15. Negative Imperative");
    	conjugationList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

}