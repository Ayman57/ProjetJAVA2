package requete;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.Connexion;
import modele.Abonnement;
import modele.Client;

public class RequeteAbonnement {

	
	  public void supprimer(int idAbonnement) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			  PreparedStatement requete = laConnexion.prepareStatement("delete from  Abonnement where id_abonnement=?");
					  requete.setInt(1, idAbonnement);
					  int nbLignes = requete.executeUpdate();
					
		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
			}   
	  
	  public void ajouter( Date date_deb, Date date_fin, int id_client, int id_revue) {
		  try {
		   Connection laConnexion = Connexion.creeConnexion();
		Statement requete = laConnexion.createStatement();
		PreparedStatement req =	laConnexion.prepareStatement(" INSERT INTO Abonnement (date_debut, date_fin, id_client, id_revue ) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		req.setDate(1, date_deb);
		req.setDate(2, date_fin);
		req.setInt(3, id_client);
		req.setInt(4, id_revue);
		int nbLignes = req.executeUpdate();
		ResultSet res = req.getGeneratedKeys();
		if (res.next()) {
		int cle = res.getInt(1); 
		}
		 

		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
			}  
	  
	  public void modifier(Abonnement objet) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req = laConnexion.prepareStatement(" update Abonnement set  date_debut=?, date_fin=?, id_client=?, id_revue=?",Statement.RETURN_GENERATED_KEYS);
			req.setDate(1, objet.getDate_debut());
			req.setDate(2, objet.getDate_fin());
			req.setInt(3, objet.getId_client());
			req.setInt(4, objet.getId_revue());
			int nbLignes = req.executeUpdate();
			
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
			int cle = res.getInt(1); 
			}
			
			  }catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				
				  } 
	  }
	  

}
