package dao.mysql;

import java.sql.*;
public class Connexion  {

	public static Connection creeConnexion() {
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/essadik8u_projetJAVA";
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




	public static void fermeture(Connection laConnexion, PreparedStatement req) throws SQLException {
		fermeture(laConnexion,req,null);
	}

	public static void fermeture(Connection laConnexion, PreparedStatement req, ResultSet res) throws SQLException {

		if (res != null)
			res.close();
		if (req != null) 
			req.close();
		if (laConnexion != null) 
			laConnexion.close();

	}





	/* public class  {

	  DELETE FROM Projet1 WHERE joueur_nom = 'test'";"joueur_num=1"; "joueur_poste=12";
	  } catch (Exception e) {
	   e.printStackTrace(); 
	  }
	 */

}
