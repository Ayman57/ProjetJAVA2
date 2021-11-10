package controleur;




import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.DAOFactory;
import dao.Persistance;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import modele.Periodicite;
import modele.Revue;
import controleur.ControleurMenu;

public class ControleurCreerRevue implements Initializable{
 

		@FXML
		private TextField txtTitre;
		@FXML
		private TextArea txtDesc;
		@FXML
		private TextField txtTarif;
		@FXML
		private ComboBox<Periodicite> cmbPerio;
		@FXML
		private Label lblAffichage;
		@FXML
		private Label lblRecap;
		@FXML
		private Button btnCreer;
		@FXML
		private Button btnModifier;
		@FXML
		private Button btnSupprimer;
		@FXML
		private Button btnVisuel;
		@FXML
		private String visuel;
		@FXML
		private TableView<Revue> tblRevue;
		@FXML
		TableColumn<Revue, String> colTitre ;
		@FXML
		TableColumn<Revue, String> colDescription ;
		@FXML
		TableColumn<Revue, String> colTarif;
		@FXML
		TableColumn<Revue, String> colPeriodicite ;
		@FXML
		TableColumn<Revue, String> colVisuel ;
		@FXML
		private Window vue;
		
	
	public void creerRevue() {
		String titre = this.txtTitre.getText();
		String description = this.txtDesc.getText();
		String tarif = this.txtTarif.getText();
		Periodicite periodicite = this.cmbPerio.getSelectionModel().getSelectedItem();
		
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		try {
			if(titre == null || "".equals(titre)) 
				throw new IllegalArgumentException("Saisir un titre");
			
			else if(description == null || "".equals(description)) 
				throw new IllegalArgumentException("Saisir une description");
			
			else if(tarif == null || "".equals(tarif) || Integer.parseInt(tarif) <= 0)
				throw new IllegalArgumentException("Saisir un prix");
		
			
			else if(periodicite == null ) 
				throw new IllegalArgumentException("Veuillez selectionner une périodicité");
			
			else {
				Revue revue = new Revue(titre, description, Integer.parseInt(tarif), null, periodicite);
				dao.getRevueDAO().create(revue);	
				this.lblAffichage.setText(revue.toString());
			}
		}catch(Exception exc) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("ERREUR Creation Revue");
			alert.setHeaderText("Une erreur est survenue lors de votre création");
			alert.setContentText(exc.toString());
			alert.showAndWait();		}
	}
		public void visuelRevue() {
			FileChooser fileChooser=new FileChooser();
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter(".jpg","JPG"),
					new FileChooser.ExtensionFilter(".png", "PNG"));
			fileChooser.setTitle("Ouvrir le visuel de la Revue");
			File f=fileChooser.showOpenDialog(this.vue);
			if(f!=null)
			{
			visuel=f.getAbsolutePath();
			}
					
		}
		public void modifierRevue() {
			
		}
		
		public void supprimerRevue() {
			try {
				ControleurMenu.daoRevue.delete(tblRevue.getSelectionModel().getSelectedItem()); 
		        List<Revue> revue = ControleurMenu.daoRevue.findAll();
				tblRevue.getItems().clear();
				tblRevue.getItems().addAll(revue);
			} 
			catch (Exception exc) {
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("ERREUR Suppression Revue");
				alert.setHeaderText("Veuillez selectionné une revue a supprimer ");
				alert.setContentText(exc.toString());
				alert.showAndWait();
			}		
			
		}
		@Override
		public void initialize(URL location, ResourceBundle ressources) {
	       
			DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
			try {
				this.cmbPerio.setItems(FXCollections.observableArrayList(dao.getPeriodiciteDAO().findAll()));				
			} 
			catch (Exception e) {
				Alert alert=new Alert(Alert.AlertType.ERROR);
				alert.initOwner(vue);
				alert.setTitle("ERREUR Initialisation");
				alert.setHeaderText("Veuillez verifier l'initialisation de vos Revues");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		}			
		}
	


