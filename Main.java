package conjugator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application	{
	private double x, y;
	
	@Override
	public void start(Stage window) throws Exception	{
			Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
			Scene scene = new Scene(root);
			window.setScene(scene);
			window.initStyle(StageStyle.UNDECORATED);
			
			root.setOnMousePressed(event -> {
				x = event.getSceneX();
				y = event.getSceneY();
			});
			
			root.setOnMouseDragged(event -> {
				window.setX(event.getScreenX() - x);
				window.setY(event.getScreenY() - y);
			});
			
			window.show();
	}
	
	public static void main(String[] args)	{
		launch(args);
	}
}