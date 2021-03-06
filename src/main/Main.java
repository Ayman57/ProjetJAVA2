package main;

import dao.mysql.MYSQLAbonnementDAO;
import dao.mysql.MYSQLClientDAO;
import dao.mysql.MYSQLPeriodiciteDAO;
import dao.mysql.MYSQLRevueDAO;
import modele.Abonnement;
import modele.Client;
import modele.Periodicite;
import modele.Revue;
import requete.RequeteAbonnement;
import requete.RequeteClient;
import requete.RequetePeriodicite;
import requete.RequeteRevue;
import dao.DAOFactory;
import dao.Persistance;
import dao.mysql.Connexion;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.Connection;
public class Main {

	public static void main(String[] args) {

		/**
		Connexion laConnexion = new Connexion();
		laConnexion.creeConnexion();
		MYSQLAbonnementDAO sqlAbo= new MYSQLAbonnementDAO();
		MYSQLClientDAO sqlCli= new MYSQLClientDAO();
		MYSQLPeriodiciteDAO sqlPerio= new MYSQLPeriodiciteDAO();
		MYSQLRevueDAO sqlRev= new MYSQLRevueDAO();
		 Date d1 = new Date("2020/02");
		 Date d2 = new Date("2020/02/05");
		
		
		Abonnement abo1= new Abonnement(1,d1,d2,2,1);
		Abonnement abo2= new Abonnement(2,d1,d2,2,2);
		
		sqlAbo.create(abo1);
		sqlAbo.create(abo2);
		sqlAbo.findAll();
		sqlAbo.getById(2);
		sqlAbo.delete(abo1);
		
		Client cl1 = new Client(1, "ES SADIK", "Ayman",  "4", "Avenue des tilleuls","57270", "Uckange", "Pays");
		Client cl2=new Client(2, "PIERLOT", "Maxime", "2", "Avenue de Paris", "57290", "Fameck", "France");
		
		sqlCli.create(cl1);
		sqlCli.create(cl2);
		sqlCli.findAll();
	//	sqlCli.getById(1);
		sqlCli.delete(cl2);
		
		
		Periodicite per1= new Periodicite(1,"Mensuel"); 
		Periodicite per2= new Periodicite(2,"Quotidien"); 
		
		sqlPerio.create(per2);
		sqlPerio.create(per1);
		sqlPerio.findAll();
	//	sqlPerio.getById(2);
		sqlPerio.delete(per1);
		
		
		Revue rev1= new Revue(1,"La Revue", "Qu'est ce qu'un bon produit", 10, "Revue", 1);
		Revue rev2= new Revue(2, "La Revue", "Decouvrir l'histoire", 8, "Revue", 1);
		
		sqlRev.create(rev2);
		sqlRev.create(rev1);
		sqlRev.findAll();
	//	sqlRev.getById(1);
		sqlRev.delete(rev2);


	
		
DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		
		Client c1 = new Client(1, "Manuel", "Croix", "4", "rue des frites", "36252","Paris","France");
		Periodicite p1=new Periodicite(1, "test");
		Revue r1=new Revue(4, "peaky blinders", "serie", 15,"oui", p1);
		
		LocalDate d1 = LocalDate.of(2021, 2, 25);
		LocalDate d2 = LocalDate.of(2021,7,22);
		
		Abonnement a1=new Abonnement(1, d1, d2, c1, r1);
		Abonnement a2=new Abonnement(2, d1, d2, c1, r1);
		 
		try {
			dao.getAbonnementDAO().create(a1);
			dao.getAbonnementDAO().create(a2);
			dao.getAbonnementDAO().findAll();
			dao.getAbonnementDAO().getById(2);
		}catch(Exception sqle){
			System.out.println(sqle.getMessage());
		}

		**/
	}
	

}
