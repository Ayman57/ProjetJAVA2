package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;
import dao.ClientDAO;
import modele.Client;

public class MYSQLClientDAO implements ClientDAO{
	private static MYSQLClientDAO instance;


	@Override
	public Client getById(int id) throws Exception{
	Client client= null;	
		 try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" select * from Client where id_client = ?");
			req.setInt(1, id);
			int nbLignes = req.executeUpdate();
			ResultSet res = req.executeQuery();

			if (res.next()) {
				client = new Client(res.getInt(1),res.getString(2),res.getString(3), res.getString(4), res.getString(5), res.getString(6),res.getString(7), res.getString(8));
				}
			  }catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				  } 
		return client;	
	}

	@Override
	public boolean create(Client objet) {
		int nbLignes = 0;
		 try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" INSERT INTO Client (nom, prenom, no_rue, voie, code_postal, ville, pays ) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getNom());
			req.setString(2, objet.getPrenom());
			req.setString(3, objet.getNo_rue());
			req.setString(4, objet.getVoie());
			req.setString(5, objet.getCode_postale());
			req.setString(6, objet.getVille());
			req.setString(7, objet.getPays());
			 nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
			int cle = res.getInt(1); 
			}
			 

			
			  }catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				  } 
		return nbLignes == 1;
	}

	@Override
	public boolean update(Client objet) {
		int nbLignes = 0;
		 try {
			   Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" update Client set  nom=?, prenom=?, no_rue=?, voie=?, code_postal=?, ville=?, pays=?", Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getNom());
			req.setString(2, objet.getPrenom());
			req.setString(3, objet.getNo_rue());
			req.setString(4, objet.getVoie());
			req.setString(5, objet.getCode_postale());
			req.setString(6, objet.getVille());
			req.setString(7, objet.getPays());
			 nbLignes = req.executeUpdate();
			
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
			int cle = res.getInt(1); 
			}
			
			  }catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				
				  } 
		  return nbLignes == 1;
	}

	@Override
	public boolean delete(Client objet) {
		int nbLignes = 0;
		try {
			   Connection laConnexion = Connexion.creeConnexion();
			  PreparedStatement requete = laConnexion.prepareStatement("delete from  Client where id_client=?");
					  requete.setInt(1, objet.getId_client());
					   nbLignes = requete.executeUpdate();
					
		
		  }catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			  } 
		return nbLignes == 1;
	}

	public static  ClientDAO getInstance() {
		if (instance == null) {
			instance = new MYSQLClientDAO();
		}
		return instance;
	}		

	@Override
	public ArrayList<Client> findAll() {
ArrayList<Client> listecl = new ArrayList<Client>();
		
		
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select * from Client");
			ResultSet res = req.executeQuery();
			while (res.next()){
				listecl.add(new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
			}
		}catch (SQLException sqle) {
			System.out.println("Pb dans select" + sqle.getMessage());		}
		
		return listecl ;
	}


}
