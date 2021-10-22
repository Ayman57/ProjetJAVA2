package modele;

public class Revue {
	
 private int idRevue;
 private String titre;
 private String description;
 private double tarifNumero;
 
 private String visuel;
 private int idPeriodicite;
 
public Revue(int idRevue, String titre, String description, double tarifNumero, String visuel, int idPeriodicite) {
	this.setIdRevue(idRevue);
	this.setTitre(titre);
	this.setDescription(description);
	this.setTarifNumero(tarifNumero);
	this.setVisuel(visuel);
	this.setIdPeriodicite(idPeriodicite);
}

public Revue(String titre, String description, double tarifNumero, String visuel, int idPeriodicite) {
	this(-1, titre, description, tarifNumero, visuel, idPeriodicite);
}

public int getIdRevue() {
	return idRevue;
}

public void setIdRevue(int idRevue) {
	this.idRevue = idRevue;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public double getTarifNumero() {
	return tarifNumero;
}

public void setTarifNumero(double tarifNumero) {
	this.tarifNumero = tarifNumero;
}

public String getVisuel() {
	return visuel;
}

public void setVisuel(String visuel) {
	this.visuel = visuel;
}

public int getIdPeriodicite() {
	return idPeriodicite;
}

public void setIdPeriodicite(int idPeriodicite) {
	this.idPeriodicite = idPeriodicite;
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
	if (idPeriodicite != other.idPeriodicite)
		return false;
	return true;
}

@Override
public String toString() {
	return "Revue [idRevue=" + idRevue + ", titre=" + titre + ", description=" + description + ", tarifNumero="
			+ tarifNumero + ", visuel=" + visuel + ", idPeriodicite=" + idPeriodicite + "]";
}


 
 
}
