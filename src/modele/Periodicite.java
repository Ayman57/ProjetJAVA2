package modele;

public class Periodicite {

	private int id_periodicite;
	private String libelle;
	
	public Periodicite(int id_periodicite, String libelle) {
		this.id_periodicite = id_periodicite;
		this.libelle = libelle;
	}

	public int getId_periodicite() {
		return id_periodicite;
	}

	public void setId_periodicite(int id_periodicite) {
		this.id_periodicite = id_periodicite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	
	
}
