package requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.Connexion;
import modele.Client;
import modele.Revue;

public class RequeteRevue {

	 public void supprimer(int idRevue) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			  PreparedStatement requete = laConnexion.prepareStatement("delete from  Revue where id_revue=?");
					  requete.setInt(1, idRevue);
					  int nbLignes = requete.executeUpdate();
					
		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
			}   
	 
	 public void ajouter( String titre, String description, float tarif_numero, String visuel, int id_periodicite) {
		  try {
		   Connection laConnexion = Connexion.creeConnexion();
		Statement requete = laConnexion.createStatement();
		PreparedStatement req =	laConnexion.prepareStatement(" INSERT INTO Revue (titre, description, tarif_numero, visuel, id_periodicite) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		req.setString(1, titre);
		req.setString(2, description);
		req.setFloat(3, tarif_numero);
		req.setString(4, visuel);
		req.setInt(5, id_periodicite);
		int nbLignes = req.executeUpdate();
		ResultSet res = req.getGeneratedKeys();
		if (res.next()) {
		int cle = res.getInt(1); 
		}
		 

		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
			}   
	 
	  public void modifier(Revue objet) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" update Revue set  titre=?, description=?, tarif_numero=?, visuel=?, id_periodicite=? ", Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getTitre());
			req.setString(2, objet.getDescription());
			req.setDouble(3, objet.getTarif_numero());
			req.setString(4, objet.getVisuel());
			req.setInt(5, objet.getId_periodicite());
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

