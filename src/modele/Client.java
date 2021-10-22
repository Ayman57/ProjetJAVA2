package modele;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if (idClient < -1) 
			throw new IllegalArgumentException("L'id du Client ne peut pas être négatif");
		else
			this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherNom = pattern.matcher(this.getNom());

        if(this.getNom()==null) 
            throw new IllegalArgumentException("Le Nom doit être saisie");
        else if("".equals(this.getNom())) 
            throw new IllegalArgumentException("Saisir le nom correctement");
        else if(!matcherNom.find()) 
            throw new IllegalArgumentException("Saisir le nom correctement");
        else 
            this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherPrenom = pattern.matcher(this.getPrenom());

        if(this.getPrenom()==null) 
            throw new IllegalArgumentException("Le prénom doit être saisie");
        else if("".equals(this.getPrenom())) 
            throw new IllegalArgumentException("Saisir le prénom correctement");
        else if(!matcherPrenom.find()) 
            throw new IllegalArgumentException("Saisir le prénom correctement");
        else 
            this.prenom = prenom;
    }

	public String getNoRue() {
		return noRue;
	}

	public void setNoRue(String noRue) {
		
        if(this.getNoRue()==null) 
            throw new IllegalArgumentException("Le No de rue doit être saisie");
        else if("".equals(this.getNoRue())) 
            throw new IllegalArgumentException("Saisir le no de rue correctement");
        else 
            this.noRue = noRue;
    }
		
		
			

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		 if(this.getVoie()==null) 
	            throw new IllegalArgumentException("La Voie doit être saisie");
	        else if("".equals(this.getVoie())) 
	            throw new IllegalArgumentException("Saisir la voie correctement");
	        else 
	            this.voie = voie;
	    }

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		 if(this.getCodePostal()==null) 
	            throw new IllegalArgumentException("Le Code Postal doit être saisie");
	        else if("".equals(this.getCodePostal())) 
	            throw new IllegalArgumentException("Saisir le Code Postal correctement");
	        else 
	            this.codePostal = codePostal;
	    }	

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherVille = pattern.matcher(this.getVille());

        if(this.getVille()==null) 
            throw new IllegalArgumentException("La Ville doit être saisie");
        else if("".equals(this.getVille())) 
            throw new IllegalArgumentException("Saisir la Ville correctement");
        else if(!matcherVille.find()) 
            throw new IllegalArgumentException("Saisir la Ville correctement");
        else 
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherPays = pattern.matcher(this.getPays());

        if(this.getPays()==null) 
            throw new IllegalArgumentException("Le Pays doit être saisie");
        else if("".equals(this.getPays())) 
            throw new IllegalArgumentException("Saisir le Pays correctement");
        else if(!matcherPays.find()) 
            throw new IllegalArgumentException("Saisir le Pays correctement");
        else 
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
