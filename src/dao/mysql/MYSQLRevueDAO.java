package dao.mysql;

import java.util.ArrayList;

import com.mysql.cj.xdevapi.Client;

import dao.RevueDAO;

public class MYSQLRevueDAO implements RevueDAO{

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

	public static RevueDAO getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<modele.Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
