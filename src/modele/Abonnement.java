package modele;

import java.sql.Date;
import java.time.LocalDate;

public class Abonnement {

	private int idAbonnement;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int idClient;
	private int idRevue;
	
	public Abonnement(int idAbonnement, LocalDate dateDebut, LocalDate dateFin, int idClient, int idRevue) {
		this.idAbonnement = idAbonnement;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idClient = idClient;
		this.idRevue = idRevue;
	}

	public int getIdAbonnement() {
		return idAbonnement;
	}

	public void setIdAbonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdRevue() {
		return idRevue;
	}

	public void setIdRevue(int idRevue) {
		this.idRevue = idRevue;
	}
	
	
}

//test