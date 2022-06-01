package fr.eni.java.projet.dal;

import fr.eni.java.projet.bo.Retrait;

public interface RetraitDAO {
	
	public void insert(Retrait retrait);
	
	public Retrait SelectByID(int noArticle);
	
}
