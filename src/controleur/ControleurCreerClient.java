package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import modele.Client;
import modele.Revue;

public class ControleurCreerClient {

	@FXML
	private TextField txtNom;
	@FXML
	private TextField txtPrenom;
	@FXML
	private TextField txtNoRue;
	@FXML
	private TextField txtVoie;
	@FXML
	private TextField txtCdpost;
	@FXML
	private TextField txtVille;
	@FXML
	private TextField txtPays;
	@FXML
	private Button btnCreer;
	@FXML
	private Button btnModifier;
	@FXML
	private Button btnSupprimer;
	@FXML
	private TableView<Client> tblClient;
	@FXML
	TableColumn<Client, String> colNom ;
	@FXML
	TableColumn<Client, String> colPrenom ;
	@FXML
	TableColumn<Client, String> colNoRue;
	@FXML
	TableColumn<Client, String> colVoie ;
	@FXML
	TableColumn<Client, String> colCdPost ;
	@FXML
	TableColumn<Client, String> colVille ;
	@FXML
	TableColumn<Client, String> colPays ;
	@FXML
	private Window vue;
	
	public void ajoutClient() {
		
	}
public void modifierClient() {
		
	}
public void supprimerClient() {
	
}

	
	
}
