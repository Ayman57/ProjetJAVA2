package application;
import java.lang.Exception;
import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
	try {
	URL fxmlURL=getClass().getResource("/vues/VueCreerRevue.fxml");
	FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	Node root = fxmlLoader.load();
	Scene scene = new Scene((VBox) root, 600, 400);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Gestion des revues");
	primaryStage.show();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		launch(args);
		}
}
