package dao;

import java.util.ArrayList;

import modele.Client;
import modele.Periodicite;

public interface DAO<T> {
public abstract T getById(int id);
public abstract boolean create(T objet);
public abstract boolean update(T objet);
public abstract boolean delete(T objet);
ArrayList<Client> findAll();
}