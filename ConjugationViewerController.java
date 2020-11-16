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


public class ConjugationViewerController extends AnchorPane implements Initializable {

    @FXML
    private AnchorPane verbConjugatorPanel;
    
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
		String verbType = "";
		String badInputMsg = "";
		String conjWord = "";
		
		badInputMsg = ConjugatorLogic.inputCheck(input, badInputMsg);
		if(badInputMsg != "")	{
			conjugatedOutput.setText(badInputMsg);
			return badInputMsg;
		}
		
		verbType = ConjugatorLogic.verbTypeCheck(input);
		
		conjWord = ConjugatorLogic.conjWanted(input, conjugationList, verbType);
		
		return conjWord;
		
    }
	
    @FXML
    void conjugate(ActionEvent event) throws InterruptedException {
    	conjugatedOutput.setText(getInput());
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