package dao.mysql;

import java.sql.*;
public class Connexion  {
  public static Connection creeConnexion() {
String url = 
"jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/essadik8u_projetJAVA";
String login = "essadik8u_appli";
String pwd = "Aes57270&*"; 
Connection maConnexion = null;
try { 
maConnexion = DriverManager.getConnection(url, login, pwd);
} catch (SQLException sqle) {
System.out.println("Erreur connexion" + sqle.getMessage());
}
return maConnexion;
  }
  
  
  
  
  public void uneRequete() {
	  try {
	   Connection laConnexion = creeConnexion();
	Statement requete = laConnexion.createStatement();
	ResultSet res = requete.executeQuery("select id_periodicite, libelle from Periodicite");
	while (res.next()) {
		int no = res.getInt(1);
		String libelle = res.getString("libelle");
	}
		if (res != null)
			res.close();
			if (requete != null)
			requete.close();
			if (laConnexion != null)
			laConnexion.close();

	
	  }catch (SQLException sqle) {
		System.out.println("Pb select" + sqle.getMessage());
		  } 
		}



 

 /* public class  {
	  
	  DELETE FROM Projet1 WHERE joueur_nom = 'test'";"joueur_num=1"; "joueur_poste=12";
	  } catch (Exception e) {
	   e.printStackTrace(); 
	  }
	*/
	
}
