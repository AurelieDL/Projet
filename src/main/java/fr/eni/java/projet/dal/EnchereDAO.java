package fr.eni.java.projet.dal;

import java.util.List;

import fr.eni.java.projet.bo.Enchere;

public interface EnchereDAO {

	public void insert(Enchere enchere);
	
	//A voir avec une foreign key: public void selectById(int une): Utilisateur;

	public List<Enchere> selectAll();
	
}
