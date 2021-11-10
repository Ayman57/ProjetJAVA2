package controleur;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import modele.Abonnement;
import modele.Client;
import modele.Periodicite;
import modele.Revue;

public class ControleurCreerAbonnement {
	
	@FXML
	private DatePicker dateDeb;
	@FXML
	private DatePicker dateFin;
	@FXML
	private ComboBox<Periodicite> cmbPerio;
	@FXML
	private ComboBox<Client> cmbClient;
	@FXML
	private TableView<Abonnement> tblAbonnement;
	@FXML
	private TableColumn<Abonnement, LocalDate> colDatedeb;
	@FXML
	private TableColumn<Abonnement, LocalDate> colDatefin;
	@FXML
	private TableColumn<Abonnement, Client> colClient;
	@FXML
	private TableColumn<Abonnement, Periodicite> colPerio;
	@FXML
	private Button btnSupprimer;
	@FXML
	private Button btnCreer;
	@FXML
	private Button btnModifier;
	@FXML
	private Window vue;
	
	
	public void creerAbonnement() {
		
	}
public void modifierAbonnement() {
		
	}
public void supprimerAbonnement() {
	
}

	

}
