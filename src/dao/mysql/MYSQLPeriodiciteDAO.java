package dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.PeriodiciteDAO;
import modele.Client;
import modele.Periodicite;

public class MYSQLPeriodiciteDAO implements PeriodiciteDAO {
	private static MYSQLPeriodiciteDAO instance;


	@Override
	public Periodicite getById(int id) throws Exception {

		Periodicite  perio= null;	
			 try {
				   Connection laConnexion = Connexion.creeConnexion();
				Statement requete = laConnexion.createStatement();
				PreparedStatement req =	laConnexion.prepareStatement(" select * from Periodicite where id_periodicite = ?");
				req.setInt(1, id);
				int nbLignes = req.executeUpdate();
				ResultSet res = req.executeQuery();

				if (res.next()) {
					perio = new Periodicite(res.getInt(1),res.getString(2));
					}
				  }catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
	}
		  		return perio;
	}

	@Override
	public boolean create(Periodicite objet) throws Exception{
		int nbLignes = 0;
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" INSERT INTO Periodicite (libelle) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getLibelle());
			 nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
			int cle = res.getInt(1); 
			objet.setIdPeriodicite(cle);
			}
			  }catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				  } 

		return nbLignes == 1;
	}

	@Override
	public boolean update(Periodicite objet) throws Exception{
		int nbLignes = 0;
		try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" update Periodicite set  libelle=? WHERE id_periodicite = ?");
			req.setString(1, objet.getLibelle());

			nbLignes = req.executeUpdate();
			
			
			  }catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				
				  } 	
		return nbLignes == 1;
	}

	@Override
	public boolean delete(Periodicite objet)throws Exception {
		int nbLignes=0;
		  try {
			   Connection laConnexion = Connexion.creeConnexion();
			  PreparedStatement requete = laConnexion.prepareStatement("delete from  Periodicite where id_periodicite=?");
					  requete.setInt(1, objet.getIdPeriodicite());
					   nbLignes = requete.executeUpdate();
					
		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
		return nbLignes==1;
	}

	@Override
	public ArrayList<Periodicite> findAll() throws Exception{
ArrayList<Periodicite> listeper = new ArrayList<Periodicite>();
		
		
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select (*) from Periodicite");
			ResultSet res = req.executeQuery();
			while (res.next()){
				listeper.add(new Periodicite(res.getInt("id_periodicite"),res.getString("libelle")));
			}
		}catch (SQLException sqle) {
			System.out.println("Pb dans select" + sqle.getMessage());		}
		
		return listeper ;
	}

	public static PeriodiciteDAO getInstance() {
		if (instance == null) {
			instance = new MYSQLPeriodiciteDAO();
		}
		return instance;		
	}

}
