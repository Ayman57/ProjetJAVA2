package dao.mysql;

import java.util.ArrayList;

import dao.ClientDAO;
import modele.Client;

public class MYSQLClientDAO implements ClientDAO{

	@Override
	public Client getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Client objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client objet) {
		// TODO Auto-generated method stub
		return false;
	}

	public static  ClientDAO getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
