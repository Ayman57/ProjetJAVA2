package controleur;




import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dao.DAOFactory;
import dao.Persistance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
	private ComboBox<String> cmbPerio;
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
	TableColumn<Revue, Integer> colTarif;
	@FXML
	TableColumn<Revue, String> colPeriodicite ;
	@FXML
	TableColumn<Revue, String> colVisuel ;
	@FXML
	private Window vue;
	private ObservableList<Periodicite> listeper;
	private ObservableList<Periodicite> revue;

	public void creerRevue() {

		String titre = this.txtTitre.getText();
		String description = this.txtDesc.getText();
		String tarif = this.txtTarif.getText();
		int id = getId(cmbPerio.getSelectionModel().getSelectedItem()); String lb = cmbPerio.getSelectionModel().getSelectedItem();
		Periodicite periodicite = new Periodicite(id,lb);

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
				visuelRevue();
				Revue revue = new Revue(titre, description, Integer.parseInt(tarif), visuel, periodicite);
				dao.getRevueDAO().create(revue);	

				tblRevue.setVisible(true);
				//this.lblAffichage.setText(revue.toString());
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
		tblRevue.getSelectionModel().setCellSelectionEnabled(true);
		tblRevue.getItems().clear();
		ObservableList<Revue> revue = FXCollections.observableArrayList(ControleurMenu.daoRevue.findAll());

		PropertyValueFactory<Revue,String> coltitre = new PropertyValueFactory<Revue,String>("Titre");
		PropertyValueFactory<Revue,String> coldescription = new PropertyValueFactory<Revue,String>("Description");
		PropertyValueFactory<Revue,Integer> coltarif = new PropertyValueFactory<Revue,Integer>("Tarif");
		PropertyValueFactory<Revue,String> colperiodicite = new PropertyValueFactory<Revue,String>("Periodicite");
		PropertyValueFactory<Revue,String> colvisuel = new PropertyValueFactory<Revue,String>("Visuel");

		this.colTitre.setCellValueFactory(coltitre);
		this.colDescription.setCellValueFactory(coldescription);
		this.colTarif.setCellValueFactory(coltarif);
		this.colPeriodicite.setCellValueFactory(colperiodicite);
		this.colVisuel.setCellValueFactory(colvisuel);

		tblRevue.getItems().addAll(revue);
	}

	public void visuelRevue() {
		FileChooser fileChooser=new FileChooser();
		/**fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter(".jpg","JPG"),
				new FileChooser.ExtensionFilter(".png", "PNG"),
				new FileChooser.ExtensionFilter(".PNG", "PNG"));
		fileChooser.setTitle("Ouvrir le visuel de la Revue");**/
		File f=fileChooser.showOpenDialog(this.vue);
		if(f!=null)
		{
			visuel=f.getAbsolutePath();
		}

	}
	public void modifierRevue() {
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

	public int getId(String lbl) {

		int res=-1;
		for (Periodicite periodicite : listeper) {
			if(periodicite.getLibelle().compareTo(lbl)==0) {
				res = periodicite.getIdPeriodicite();
			}
		}
		return res;
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



