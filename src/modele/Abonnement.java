package modele;

import java.sql.Date;
import java.time.LocalDate;

public class Abonnement {

	private int idAbonnement;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Client client;
	private Revue revue;
	
	public Abonnement(int idAbonnement, LocalDate dateDebut, LocalDate dateFin, Client client, Revue revue) {
		this.setIdAbonnement(idAbonnement);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setClient(client);
		this.setRevue(revue);
	}
	
	public Abonnement( LocalDate dateDebut, LocalDate dateFin, Client client, Revue revue) {
	
		this(-1, dateDebut, dateFin, client, revue);
	}

	public int getIdAbonnement() {
		return idAbonnement;
	}

	public void setIdAbonnement(int idAbonnement) {
		if (idAbonnement < -1)
			throw new IllegalArgumentException("L' id Abonnement doit être positif");
		else	
			this.idAbonnement = idAbonnement;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		if(this.dateDebut.isAfter(this.dateFin) && this.dateFin!=null) 
			throw new IllegalArgumentException("Date de debut n'est pas valide");
		else
			this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		if(this.dateFin.isBefore(this.dateDebut) && this.dateDebut!=null) 
			throw new IllegalArgumentException("Date de fin n'est pas valide");
		
		this.dateFin = dateFin;
	}

	public Client  getClient() {
		return client;
	}

	public void setClient(Client client) {
		if(client==null) 
			throw new IllegalArgumentException("Client doit être valide");
		else
			this.client = client;
	}

	public Revue getRevue() {
		return revue;
	}

	public void setRevue(Revue revue) {
		if(revue==null) 
			throw new IllegalArgumentException("Revue doit être valide");
		else
			this.revue = revue;
	}




	@Override
	public String toString() {
		return "Abonnement [idAbonnement=" + idAbonnement + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", client=" + client + ", revue=" + revue + "]";
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