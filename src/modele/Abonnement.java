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
		this.setIdAbonnement(idAbonnement);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setIdClient(idClient);
		this.setIdRevue(idRevue);
	}
	
	public Abonnement( LocalDate dateDebut, LocalDate dateFin, int idClient, int idRevue) {
	
		this(-1, dateDebut, dateFin, idClient, idRevue);
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


	@Override
	public String toString() {
		return "Abonnement [idAbonnement=" + idAbonnement + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", idClient=" + idClient + ", idRevue=" + idRevue + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonnement other = (Abonnement) obj;
		if (idAbonnement != other.idAbonnement)
			return false;
		return true;
	}
	
	
}

//test