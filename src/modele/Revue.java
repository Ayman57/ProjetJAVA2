package modele;

public class Revue {
 private int id_revue;
 private String titre;
 private String description;
 private float tarif_numero;
 private String visuel;
 private int id_periodicite;
 
public Revue(int id_revue, String titre, String description, float tarif_numero, String visuel, int id_periodicite) {
	this.id_revue = id_revue;
	this.titre = titre;
	this.description = description;
	this.tarif_numero = tarif_numero;
	this.visuel = visuel;
	this.id_periodicite = id_periodicite;
}

public int getId_revue() {
	return id_revue;
}

public void setId_revue(int id_revue) {
	this.id_revue = id_revue;
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

public double getTarif_numero() {
	return tarif_numero;
}

public void setTarif_numero(float tarif_numero) {
	this.tarif_numero = tarif_numero;
}

public String getVisuel() {
	return visuel;
}

public void setVisuel(String visuel) {
	this.visuel = visuel;
}

public int getId_periodicite() {
	return id_periodicite;
}

public void setId_periodicite(int id_periodicite) {
	this.id_periodicite = id_periodicite;
}


 
 
}
