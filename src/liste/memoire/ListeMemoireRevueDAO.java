package liste.memoire;

import java.util.ArrayList;
import java.util.List;

import dao.RevueDAO;
import modele.Client;
import modele.Revue;

public class ListeMemoireRevueDAO implements RevueDAO {

	private static ListeMemoireRevueDAO instance;

	private List<Revue> donnees;


	public static ListeMemoireRevueDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}

	private ListeMemoireRevueDAO() {

		this.donnees = new ArrayList<Revue>();

		this.donnees.add(new Revue(1, "La Revue", "Qu'est ce qu'un bon produit", 10, "Revue", null));
		this.donnees.add(new Revue(2, "La Revue", "Decouvrir l'histoire", 8, "Revue", null));
	}


	public boolean create(Revue objet) {

		objet.setIdRevue(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setIdRevue(objet.getIdRevue() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	public boolean update(Revue objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	public boolean delete(Revue objet) {

		Revue supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	@Override
	public Revue getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Revue(id, "titre","description", 10 , "visuel", null));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	
	}
	
	

@Override	
	public ArrayList<Revue> findAll() {
		return (ArrayList<Revue>) this.donnees;
	}

	
	}
	
