package dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Client;

import dao.RevueDAO;
import modele.Periodicite;
import modele.Revue;
import dao.mysql.*;

public class MYSQLRevueDAO implements RevueDAO{
	private static MYSQLRevueDAO instance;


	@Override
	public Revue getById(int id) throws Exception {
		Revue  revue= null;	
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" select * from Revue where id_revue = ?");
			req.setInt(1, id);
			int nbLignes = req.executeUpdate();
			ResultSet res = req.executeQuery();

			if (res.next()) {
				revue = new Revue(res.getInt(1),res.getString(2),res.getString(3), res.getDouble(4),res.getString(5), MYSQLPeriodiciteDAO.getInstance().getById(res.getInt(6)));
			}
		}catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

		return revue;
	}

	public static RevueDAO getInstance() {
		if (instance == null) {
			instance = new MYSQLRevueDAO();
		}
		return instance;
	}



	@Override
	public boolean create(Revue objet)throws Exception {
		int nbLignes=0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" INSERT INTO Revue (titre, description, tarif_numero, visuel, id_periodicite) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getTitre());
			req.setString(2, objet.getDescription());
			req.setDouble(3, objet.getTarifNumero());
			req.setString(4, objet.getVisuel());
			req.setInt(5,objet.getPeriodicite().getIdPeriodicite());
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
	public boolean update(Revue objet) throws Exception{
		int nbLignes=0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req =	laConnexion.prepareStatement(" update Revue set  titre=?, description=?, tarif_numero=?, visuel=?, id_periodicite=? WHERE id_revue = ?");
			req.setString(1, objet.getTitre());
			req.setString(2, objet.getDescription());
			req.setDouble(3, objet.getTarifNumero());
			req.setString(4, objet.getVisuel());
			req.setInt(5, objet.getPeriodicite().getIdPeriodicite());
			req.setInt(6, objet.getIdRevue());
			nbLignes = req.executeUpdate();

			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1); 
				objet.setIdRevue(cle);
			}

		}catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());

		} 
		return nbLignes==1;
	}

	@Override
	public boolean delete(Revue objet) throws Exception{
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from  Revue where id_revue=?");
			requete.setInt(1, objet.getIdRevue());
			nbLignes = requete.executeUpdate();


		}catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		} 
		return nbLignes == 1;
	}

	@Override
	public ArrayList<Revue> findAll() throws Exception{
		ArrayList<Revue> listerev = new ArrayList<Revue>();

		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select id_revue, titre, description, tarif_numero, visuel, id_periodicite from Revue");
			ResultSet res = req.executeQuery();
			while (res.next()){
				listerev.add(new Revue(res.getInt("id_revue"), res.getString("titre"), res.getString("description"), Integer.valueOf(res.getInt("tarif_numero")), res.getString("visuel"), MYSQLPeriodiciteDAO.getInstance().getById(res.getInt(6))));			
			
			}
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			System.out.println("Pb dans select" + sqle.getMessage());
		}

		return listerev ;
	}








}
