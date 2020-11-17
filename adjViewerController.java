package conjugator;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class adjViewerController extends AnchorPane implements Initializable {

    @FXML
    private AnchorPane adjConjugatorPanel;
    
    @FXML
    private JFXListView<String> conjugationList;
    
    @FXML
    private Text conjugatedOutput;
    
    @FXML
    private JFXButton conjugateButton;
    
    @FXML
    private TextField inputBox;
    
	@FXML
    String getInput() {
		String input = inputBox.getText();
		String adjType = "";
		String badInputMsg = "";
		String conjWord = "";
		
		badInputMsg = AdjConjugatorLogic.inputCheck(input, badInputMsg);
		if(badInputMsg != "")	{
			conjugatedOutput.setText(badInputMsg);
			return badInputMsg;
		}
		
		adjType = AdjConjugatorLogic.adjTypeCheck(input);
		
		conjWord = AdjConjugatorLogic.conjWanted(input, conjugationList, adjType);
		
		return conjWord;
    }
	
    @FXML
    void conjugate(ActionEvent event) throws InterruptedException {
    	conjugatedOutput.setText(getInput());
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	conjugationList.getItems().addAll("1. Non-Past Plain", "2. Non-Past Plain Negative", "3. Non-Past Polite",
    			"4. Non-Past Polite Negative", "5. Past Plain", "6. Past Plain Negative", "7. Past Polite", "8. Past Polite Negative",
    			"9. Te-Form", "10. Looks Like/Seems Like", "11. Excessive",
    			"12. To Become", "13. Nominalize", "14. If it is...", "15. If it is not...");
    	conjugationList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

}