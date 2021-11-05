package controleur;

import java.awt.TextArea;


import dao.DAOFactory;
import dao.Persistance;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.Periodicite;
import modele.Revue;

public class ControleurCreerRevue {
 

		@FXML
		private TextField textTitre;
		private TextArea textDescription;
		private TextField textTarif;
		private ComboBox<Periodicite> cmbPeriodicite;
		private Label lblAffichage;
		
	
	public void creerRevue() {
		String titre = this.textTitre.getText();
		String description = this.textDescription.getText();
		String tarif = this.textTarif.getText();
		Periodicite periodicite = this.cmbPeriodicite.getSelectionModel().getSelectedItem();
		
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
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}
		
}

