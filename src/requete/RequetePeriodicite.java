 package requete;

import connexion.Connexion;
import modele.Client;
import modele.Periodicite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connexion.Connexion;

public class RequetePeriodicite  {

	
	  public void supprimer(int idPeriodicite) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			  PreparedStatement requete = laConnexion.prepareStatement("delete from  Periodicite where id_periodicite=?");
					  requete.setInt(1, idPeriodicite);
					  int nbLignes = requete.executeUpdate();
					
		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
			}   
 


	  public boolean modifier(Periodicite objet) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" update Periodicite set  (libelle ) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getLibelle());

			int nbLignes = req.executeUpdate();
			
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
			int cle = res.getInt(1); 
			}
			
			  }catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				
				  } 
		  return true;
	  }
	  
	  public void ajouter( String libelle) {
		  try {
		   Connection laConnexion = Connexion.creeConnexion();
		Statement requete = laConnexion.createStatement();
		PreparedStatement req =	laConnexion.prepareStatement(" INSERT INTO Periodicite (libelle) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
		req.setString(1, libelle);
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
