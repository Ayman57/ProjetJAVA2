package main;

import connexion.Connexion;
import modele.Client;
import requete.RequeteAbonnement;
import requete.RequeteClient;
import requete.RequetePeriodicite;
import requete.RequeteRevue;

import java.sql.Date;


import java.sql.Connection;
public class Main {

	public static void main(String[] args) {

		
		Connexion laConnexion = new Connexion();
		laConnexion.creeConnexion();
		//laConnexion.uneRequete();
		//RequetePeriodicite req = new RequetePeriodicite();
	//	req.modifier(1, "Oui");
		RequeteClient req = new RequeteClient();
		Client c1 = new Client(1, "ES SADIK", "Ayman",  "4", "Avenue des tilleuls","57270", "Uckange", "Pays");
		//req.ajouter("ES SADIK", "Ayman",  "4", "Avenue des tilleuls","57270", "Uckange", "Pays");
	//req.modifier(c1);
		//	req.supprimer(1);
		//RequeteAbonnement req = new RequeteAbonnement();
		// Date d1 = new Date("2020/02/02");
		// Date d2 = new Date("2020/02/05");

	//	req.ajouter(d1,d2 , 1, 1);
	//	RequeteRevue req= new RequeteRevue();
	//	req.supprimer(1);
	}
	

}
