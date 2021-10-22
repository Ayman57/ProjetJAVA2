package modele;

public class Client {
	
	private int idClient;
	private String nom;
	private String prenom; 
	private String noRue;
	private String voie ;
	private String codePostal; 
	private String ville;
	private String pays;
	
	public Client(int idClient, String nom, String prenom, String noRue, String voie, String codePostal,
			String ville, String pays) {
		this.setIdClient(idClient);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setNoRue(noRue);
		this.setVoie(voie);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setPays(pays);
	}
	public Client( String nom, String prenom, String noRue, String voie, String codePostal,
			String ville, String pays) {
		this(-1, nom, prenom, noRue, voie,codePostal, ville, pays);
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNoRue() {
		return noRue;
	}

	public void setNoRue(String noRue) {
		this.noRue = noRue;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (idClient != other.idClient)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", noRue=" + noRue + ", voie="
				+ voie + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays + "]";
	}

	
}
