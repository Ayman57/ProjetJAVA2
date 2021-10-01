package dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;
import dao.AbonnementDAO;
import modele.Abonnement;
import modele.Client;


public class MYSQLAbonnementDAO implements AbonnementDAO{
	private static MYSQLAbonnementDAO instance;

	@Override
	public Abonnement getById(int id) {
		
		 try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" select from Abonnement where id_abonnement = ?");
			req.setInt(1, id);
			int nbLignes = req.executeUpdate();
			  }catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				  } 
		return null;	
		}

	@Override
	public boolean create(Abonnement objet) {
		
		 try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" INSERT INTO Abonnement (date_debut, date_fin, id_client, id_revue ) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
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
		return true;
	}

	@Override
	  public boolean update(Abonnement objet) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" update Abonnement set  (date_debut, date_fin, id_client, id_revue ) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
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
		  return true;
	  }
	  
	@Override
	public boolean delete(Abonnement objet) {
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			  PreparedStatement requete = laConnexion.prepareStatement("delete from  Abonnement where id_abonnement=?");
					  requete.setInt(1, objet.getId_abonnement());
					  int nbLignes = requete.executeUpdate();
					
		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 		return true;
	}

	public static AbonnementDAO getInstance() {
		if (instance == null) {
			instance = new MYSQLAbonnementDAO();
		}
		return instance;
	}

	@Override
	public ArrayList<Abonnement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
