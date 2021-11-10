package controleur;

import java.io.IOException;
import java.net.URL;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import dao.RevueDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ControleurMenu {
	public static PeriodiciteDAO daoPerio;
	public static AbonnementDAO daoAbo;
	public static ClientDAO daoClient;
	public static RevueDAO daoRevue;

	
	@FXML
	private CheckBox chkBdd;
	@FXML
	private CheckBox chkLM;
	@FXML
	private Button btnGestPerio;
	@FXML
	private Button btnGestAbo;
	@FXML
	private Button btnGestClient;
	@FXML
	private Button btnGestRevue;
	@FXML
	private Window vue;
	
	

	
	
	@FXML
	public void gestionPeriodicite() throws IOException {
		if (chkBdd.isSelected()) {
			chkLM.setDisable(false);
			daoPerio = DAOFactory.getDAOFactory(Persistance.MYSQL).getPeriodiciteDAO();
		} 
		else if (chkLM.isSelected()) {
			chkBdd.setDisable(false);
			daoPerio = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getPeriodiciteDAO();
		}
		else {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("ERREUR Periodicite");
			alert.setHeaderText("Veuillez selectionner une persistance");
			alert.showAndWait();
		}		
		
		if (daoPerio!=null) {
			Stage stage =(Stage) btnGestPerio.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("vues/VuesCreerPeriodicite.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stage1.setScene(scene);
			stage1.setTitle("Gestion des Periodicites");
			stage1.show();
		}
	}
	@FXML
	public void gestionAbonnement() throws IOException {
		if (chkBdd.isSelected()) {
			chkLM.setDisable(false);
			daoAbo = DAOFactory.getDAOFactory(Persistance.MYSQL).getAbonnementDAO();
			daoClient = DAOFactory.getDAOFactory(Persistance.MYSQL).getClientDAO();
			daoPerio = DAOFactory.getDAOFactory(Persistance.MYSQL).getPeriodiciteDAO();

		} 
		else if (chkLM.isSelected()) {
			chkBdd.setDisable(false);
			daoAbo = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getAbonnementDAO();
			daoClient = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getClientDAO();
			daoPerio = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getPeriodiciteDAO();
		}
		else {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("ERREUR Abonnement");
			alert.setHeaderText("Veuillez selectionner une persistance");
			alert.showAndWait();
		}		
		
		if (daoAbo!=null) {
			Stage stage =(Stage) btnGestPerio.getScene().getWindow();
			stage.close();
			Stage stage2 = new Stage();
			
			URL fxmlURL = getClass().getResource("vues/VueCreerAbonnement.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stage2.setScene(scene);
			stage2.setTitle("Gestion des Abonnements");
			stage2.show();
		}
	}
	
	@FXML
	public void gestionClient() throws IOException {
		if (chkBdd.isSelected()) {
			chkLM.setDisable(false);
			daoClient = DAOFactory.getDAOFactory(Persistance.MYSQL).getClientDAO();
		} 
		else if (chkLM.isSelected()) {
			chkBdd.setDisable(false);
			daoClient = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getClientDAO();
		}
		else {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("ERREUR Client");
			alert.setHeaderText("Veuillez selectionner une persistance");
			alert.showAndWait();
		}		
		
		if (daoClient!=null) {
			Stage stage =(Stage) btnGestPerio.getScene().getWindow();
			stage.close();
			Stage stage3 = new Stage();
			
			URL fxmlURL = getClass().getResource("vues/VuesCreerClient.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stage3.setScene(scene);
			stage3.setTitle("Gestion des Clients");
			stage3.show();
		}
	}
	@FXML
	public void gestionRevue() throws IOException {
		if (chkBdd.isSelected()) {
			chkLM.setDisable(true);
			daoRevue = DAOFactory.getDAOFactory(Persistance.MYSQL).getRevueDAO();
		} 
		else if (chkLM.isSelected()) {
			chkBdd.setDisable(true);
			daoRevue = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE).getRevueDAO();
		}
		else {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("ERREUR Revue");
			alert.setHeaderText("Veuillez selectionner une persistance");
			alert.showAndWait();
		}		
		
		if (daoClient!=null) {
			Stage stage =(Stage) btnGestPerio.getScene().getWindow();
			stage.close();
			Stage stage4 = new Stage();
			
			URL fxmlURL = getClass().getResource("vues/VuesCreerRevue.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 600, 400);
			
			stage4.setScene(scene);
			stage4.setTitle("Gestion des Periodicites");
			stage4.show();
		}
	}
}
