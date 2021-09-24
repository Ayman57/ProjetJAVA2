 package requete;

import connexion.Connexion;
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
 


	public void modifier(int idPeriodicite, String libelle) {
		  try {
		   Connection laConnexion = Connexion.creeConnexion();
		Statement requete = laConnexion.createStatement();
		
			      //On va chercher une ligne dans la base de données
			      String query = "SELECT id_periodicite FROM Periodicite " ;         
			 
			      ResultSet res = requete.executeQuery(query);
			 
			      res.first();
			 
			      //On affiche ce que l'on trouve
			      System.out.println("ID: " + res.getInt("id_periodicite") + " - Libelle " + res.getString("libelle"));
			 
			      //On met à jour les champs
			      res.updateString(1, libelle);
			      res.updateInt(1, idPeriodicite);
			 
			      //On valide
			      res.updateRow();
			 
			      //On affiche les modifications
			      System.out.println("*********************************");
			      System.out.println("APRES MODIFICATION : ");
			      System.out.println("ID Periodicite : " + res.getInt("id_periodicite") + " - libelle : " + res.getString("libelle"));
			 
			      res.close();
			 
			      requete.close();
			if (res != null)
				res.close();
				if (requete != null)
				requete.close();
				if (laConnexion != null)
				laConnexion.close();

		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
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
