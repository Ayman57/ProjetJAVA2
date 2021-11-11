package application;
import java.lang.Exception;

import java.net.URL;

import controleur.ControleurMenu;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class MainApp extends Application {


	private Stage primaryStage; 
	private Parent root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			this.primaryStage = primaryStage;
			
			URL fxmlURL=getClass().getResource("/vues/VueMenu.fxml");
			FXMLLoader loader = new FXMLLoader(fxmlURL);
			root = loader.load();
			
			ControleurMenu controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene((VBox) root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("RevuesOnLine");
			primaryStage.show();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
