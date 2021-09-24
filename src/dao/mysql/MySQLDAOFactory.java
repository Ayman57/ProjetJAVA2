package dao.mysql;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.RevueDAO;
import liste.memoire.ListeMemoireDAOFactory;
import liste.memoire.ListeMemoireClientDAO;
public class MySQLDAOFactory extends DAOFactory {

	public AbonnementDAO getAbonnementDAO() {
		// TODO Auto-generated method stub
		return MYSQLAbonnementDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return MYSQLClientDAO.getInstance();
	}



	@Override
	public RevueDAO getRevueDAO() {
		// TODO Auto-generated method stub
		return MYSQLRevueDAO.getInstance();
	}

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		// TODO Auto-generated method stub
		return MYSQLPeriodiciteDAO.getInstance();
	}

}

