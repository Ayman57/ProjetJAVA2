package controleur;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.DAOFactory;
import dao.Persistance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import modele.Client;
import modele.Periodicite;
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
		
		String nom = this.txtNom.getText();
		String prenom = this.txtPrenom.getText();
		String rue = this.txtNoRue.getText();
		String voie = this.txtVoie.getText();
		String codepostale = this.txtCdpost.getText();
		String ville = this.txtVille.getText();
		String pays = this.txtPays.getText();
		
		//int id = getId(cmbPerio.getSelectionModel().getSelectedItem()); String lb = cmbPerio.getSelectionModel().getSelectedItem();
		//Periodicite periodicite = new Periodicite(id,lb);

		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);

		try {
			if(nom == null || "".equals(nom)) 
				throw new IllegalArgumentException("Saisir un nom");

			else if(prenom == null || "".equals(prenom)) 
				throw new IllegalArgumentException("Saisir un prenom");

			else if(rue == null || "".equals(rue))
				throw new IllegalArgumentException("Saisir un prix");

			else if(voie == null || "".equals(voie))
				throw new IllegalArgumentException("Veuillez selectionner une périodicité");
			
			else if(codepostale == null || "".equals(codepostale)) 
				throw new IllegalArgumentException("Veuillez selectionner une périodicité");
			
			else if(ville == null || "".equals(ville))
				throw new IllegalArgumentException("Veuillez selectionner une périodicité");
			
			else if(pays == null || "".equals(pays))
				throw new IllegalArgumentException("Veuillez selectionner une périodicité");

			else {
				
				Client client = new Client(nom, prenom, rue, voie, codepostale, ville, pays);
				dao.getClientDAO().create(client);	

				tblClient.setVisible(true);
				
				btnModifier.setVisible(true);
				btnSupprimer.setVisible(true);
				
				initTable();
			}
		}catch(Exception exc) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("ERREUR Creation Revue");
			alert.setHeaderText("Une erreur est survenue lors de votre création");
			alert.setContentText(exc.toString()); System.out.println(exc.toString());
			alert.showAndWait();		}

	}
	
	public void initTable() throws Exception {
		tblClient.getSelectionModel().setCellSelectionEnabled(true);
		tblClient.getItems().clear();
		ObservableList<Client> client = FXCollections.observableArrayList(ControleurMenu.daoClient.findAll());

		PropertyValueFactory<Client,String> nom = new PropertyValueFactory<Client,String>("TitNomre");
		PropertyValueFactory<Client,String> prenom = new PropertyValueFactory<Client,String>("Prenom");
		PropertyValueFactory<Client,String> rue = new PropertyValueFactory<Client,String>("Rue");
		PropertyValueFactory<Client,String> voie = new PropertyValueFactory<Client,String>("Voie");
		PropertyValueFactory<Client,String> codepostale = new PropertyValueFactory<Client,String>("CodePostale");
		PropertyValueFactory<Client,String> ville = new PropertyValueFactory<Client,String>("Ville");
		PropertyValueFactory<Client,String> pays = new PropertyValueFactory<Client,String>("Pays");

		this.colNom.setCellValueFactory(nom);
		this.colPrenom.setCellValueFactory(coldescription);
		this.colNoRue.setCellValueFactory(coltarif);
		this.colVoie.setCellValueFactory(colperiodicite);
		this.colCdPost.setCellValueFactory(colvisuel);
		this.colVille.setCellValueFactory(colvisuel);
		this.colPays.setCellValueFactory(colvisuel);

		tblRevue.getItems().addAll(revue);
	}
	
	public void modifierClient() {
		try {			


			DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);

			Revue v = tblRevue.getSelectionModel().getSelectedItem();
			dao.getRevueDAO().update(v);

			tblRevue.getItems().clear();
			ObservableList<Revue> revue = FXCollections.observableArrayList(ControleurMenu.daoRevue.findAll());
			tblRevue.getItems().addAll(revue);

		} catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("ERREUR modification Revue");
			alert.setHeaderText("Une erreur est survenue lors de votre modification");
			alert.setContentText(e.toString()); System.out.println(e.toString());
			alert.showAndWait();
		}		


	}
	
	public void supprimerClient() {
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

		try {

			DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
			this.listeper = FXCollections.observableArrayList(dao.getPeriodiciteDAO().findAll());
			for (Periodicite periodicite : listeper) {
				this.cmbPerio.getItems().add(periodicite.getLibelle());
			}
			System.out.println("Taille: "+listeper.size());


		} 
		catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(vue);
			alert.setTitle("ERREUR Initialisation");
			alert.setHeaderText("Veuillez verifier l'initialisation de vos Revues");
			alert.setContentText(e.toString());System.out.println(e.toString());
			alert.showAndWait();
		}
	}	

	public void getData() {
		Revue v = tblRevue.getSelectionModel().getSelectedItem();
		this.txtTitre.setText(v.getTitre());;
		this.txtDesc.setText(v.getDescription());
		this.txtTarif.setText(String.valueOf(v.getTarifNumero()));
		cmbPerio.getSelectionModel().getSelectedItem();
	}

}
