package test;

import connexion.Connexion;
import requete.RequeteClient;
import requete.RequetePeriodicite;

import java.sql.Connection;
public class Test {

	public static void main(String[] args) {

		
		Connexion laConnexion = new Connexion();
		laConnexion.creeConnexion();
		//laConnexion.uneRequete();
		//RequetePeriodicite req = new RequetePeriodicite();
	//	req.modifier(1, "Oui");
		RequeteClient req = new RequeteClient();
		req.ajouter("ES SADIK", "Ayman",  "4", "Avenue des tilleuls","57270", "Uckange", "Pays");
		
	}

}
