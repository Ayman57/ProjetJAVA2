package liste.memoire;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.RevueDAO;

public class ListeMemoireDAOFactory extends DAOFactory {

@Override
public AbonnementDAO getAbonnementDAO() {
	// TODO Auto-generated method stub
	return ListeMemoireAbonnementDAO.getInstance();
}
@Override
public ClientDAO getClientDAO() {
	// TODO Auto-generated method stub
	return ListeMemoireClientDAO.getInstance();
}
@Override
public RevueDAO getRevueDAO() {
	// TODO Auto-generated method stub
	return ListeMemoireRevueDAO.getInstance();
}
@Override
public PeriodiciteDAO getPeriodiciteDAO() {
	// TODO Auto-generated method stub
	return ListeMemoirePeriodiciteDAO.getInstance();
}
}