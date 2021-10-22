package modele;

public class Revue {
	
 private int idRevue;
 private String titre;
 private String description;
 private double tarifNumero;
 
 private String visuel;
 private Periodicite periodicite;
 
public Revue(int idRevue, String titre, String description, double tarifNumero, String visuel, Periodicite periodicite) {
	this.setIdRevue(idRevue);
	this.setTitre(titre);
	this.setDescription(description);
	this.setTarifNumero(tarifNumero);
	this.setVisuel(visuel);
	this.setPeriodicite(periodicite);
}

public Revue(String titre, String description, double tarifNumero, String visuel, Periodicite periodicite) {
	this(-1, titre, description, tarifNumero, visuel, periodicite);
}

public int getIdRevue() {
	return idRevue;
}

public void setIdRevue(int idRevue) {
	if (idRevue < -1) 
		throw new IllegalArgumentException("L'id de la Revue ne peut pas être négatif ");
	else
	this.idRevue = idRevue;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	 if(this.getTitre()==null) 
         throw new IllegalArgumentException("Le Titre doit être saisie");
     else if("".equals(this.getTitre())) 
         throw new IllegalArgumentException("Saisir le titre correctement");
     else 
	this.titre = titre;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	 if(this.getDescription()==null) 
         throw new IllegalArgumentException("La description doit être saisie");
     else if("".equals(this.getDescription())) 
         throw new IllegalArgumentException("Saisir la description correctement");
     else 
	this.description = description;
}

public double getTarifNumero() {
	return tarifNumero;
}

public void setTarifNumero(double tarifNumero) {
	if (tarifNumero <= 0) 
		throw new IllegalArgumentException("Le tarif doit être positif ");
	else
	this.tarifNumero = tarifNumero;
}

public String getVisuel() {
	return visuel;
}

public void setVisuel(String visuel) {
	 if(this.getVisuel()==null) 
         throw new IllegalArgumentException("Le Visuel doit être saisie");
     else if("".equals(this.getVisuel())) 
         throw new IllegalArgumentException("Saisir le Visuel correctement");
     else 
	this.visuel = visuel;
}

public Periodicite getPeriodicite() {
	return periodicite;
}

public void setPeriodicite(Periodicite periodicite) {
	if(this.getPeriodicite()==null) 
		throw new IllegalArgumentException("Periodicite doit être saisie");
	else 
		this.periodicite = periodicite;
}






@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Revue other = (Revue) obj;
	if (idRevue != other.idRevue)
		return false;
	return true;
}

@Override
public String toString() {
	return "Revue [idRevue=" + idRevue + ", titre=" + titre + ", description=" + description + ", tarifNumero="
			+ tarifNumero + ", visuel=" + visuel + ", periodicite=" + periodicite + "]";
}




 
 
}
