package requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.Connexion;
import modele.Client;

public class RequeteClient {
	
	  public void supprimer(int idClient) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			  PreparedStatement requete = laConnexion.prepareStatement("delete from  Client where id_client=?");
					  requete.setInt(1, idClient);
					  int nbLignes = requete.executeUpdate();
					
		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
			}   
	  
	  public void ajouter( String nom, String prenom, String no_rue, String voie, String code_postal, String ville, String pays) {
		  try {
		   Connection laConnexion = Connexion.creeConnexion();
		Statement requete = laConnexion.createStatement();
		PreparedStatement req =	laConnexion.prepareStatement(" INSERT INTO Client (nom, prenom, no_rue, voie, code_postal, ville, pays ) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		req.setString(1, nom);
		req.setString(2, prenom);
		req.setString(3, no_rue);
		req.setString(4, voie);
		req.setString(5, code_postal);
		req.setString(6, ville);
		req.setString(7, pays);
		int nbLignes = req.executeUpdate();
		ResultSet res = req.getGeneratedKeys();
		if (res.next()) {
		int cle = res.getInt(1); 
		}
		 

		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
			}   
	  
	  public void modifier(Client objet) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" update Client set  (nom, prenom, no_rue, voie, code_postal, ville, pays ) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getNom());
			req.setString(2, objet.getPrenom());
			req.setString(3, objet.getNo_rue());
			req.setString(4, objet.getVoie());
			req.setString(5, objet.getCode_postale());
			req.setString(6, objet.getVille());
			req.setString(7, objet.getPays());
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
