package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;
import dao.AbonnementDAO;
import modele.Abonnement;

public class MYSQLAbonnementDAO implements AbonnementDAO {
	private static MYSQLAbonnementDAO instance;

	@Override
	public boolean create(Abonnement objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req = laConnexion.prepareStatement(
					" INSERT INTO Abonnement (date_debut, date_fin, id_client, id_revue ) VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			req.setDate(1, objet.getDate_debut());
			req.setDate(2, objet.getDate_fin());
			req.setInt(3, objet.getId_client());
			req.setInt(4, objet.getId_revue());
			 nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
			}

		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return nbLignes == 1;
	}

	@Override
	public boolean update(Abonnement objet) {
		int nbLignes=0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req = laConnexion.prepareStatement(" update Abonnement set  date_debut=?, date_fin=?, id_client=?, id_revue=?",Statement.RETURN_GENERATED_KEYS);
			req.setDate(1, objet.getDate_debut());
			req.setDate(2, objet.getDate_fin());
			req.setInt(3, objet.getId_client());
			req.setInt(4, objet.getId_revue());
			 nbLignes = req.executeUpdate();

			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
			}

		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());

		}
		return nbLignes== 1;
	}

	@Override
	public boolean delete(Abonnement objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from  Abonnement where id_abonnement=?");
			requete.setInt(1, objet.getId_abonnement());
			nbLignes = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return nbLignes == 1;
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

	@Override
	public Abonnement getById(int id) throws Exception {

		Abonnement abo = null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			PreparedStatement req = laConnexion.prepareStatement(" select * from Abonnement where id_abonnement = ?");
			req.setInt(1, id);
			int nbLignes = req.executeUpdate();
			ResultSet res = req.executeQuery();
			if (res.next()) {
				abo = new Abonnement(res.getInt(1), res.getDate(2), res.getDate(3), res.getInt(4), res.getInt(5));

			}  }catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
			  } 
		
		return abo;
	}

}
