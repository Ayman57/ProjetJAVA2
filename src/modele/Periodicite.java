package modele;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Periodicite {

	private int idPeriodicite;
	private String libelle;

	public Periodicite(int idPeriodicite, String libelle) {
		this.setIdPeriodicite(idPeriodicite);
		this.setLibelle(libelle);
	}
	
	public Periodicite( String libelle) {
		this(-1,libelle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodicite other = (Periodicite) obj;
		if (idPeriodicite != other.idPeriodicite)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Periodicite [idPeriodicite=" + idPeriodicite + ", libelle=" + libelle + "]";
	}



	public int getIdPeriodicite() {
		return idPeriodicite;
	}

	public void setIdPeriodicite(int idPeriodicite) {
		if (idPeriodicite < -1) 
			throw new IllegalArgumentException("L'id de la Periodicité ne peut pas être négatif ");
		else
		this.idPeriodicite = idPeriodicite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherLibelle = pattern.matcher(this.getLibelle());

        if(libelle==null) 
            throw new IllegalArgumentException("Le Libelle doit être saisie");
        else if("".equals(libelle)) 
            throw new IllegalArgumentException("Saisir le libelle correctement");
        else if(!matcherLibelle.find()) 
            throw new IllegalArgumentException("Saisir le libelle correctement");
        else
        	this.libelle = libelle;
	}

}
