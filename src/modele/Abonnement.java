package modele;

import java.sql.Date;

public class Abonnement {

	private int id_abonnement;
	private Date date_debut;
	private Date date_fin;
	private int id_client;
	private int id_revue;
	
	public Abonnement(int id_abonnement, Date date_debut, Date date_fin, int id_client, int id_revue) {
		this.id_abonnement = id_abonnement;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_client = id_client;
		this.id_revue = id_revue;
	}

	public int getId_abonnement() {
		return id_abonnement;
	}

	public void setId_abonnement(int id_abonnement) {
		this.id_abonnement = id_abonnement;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_revue() {
		return id_revue;
	}

	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}
	
	
}
