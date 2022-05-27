package fr.eni.java.projet.dal;

public interface EnchereDAO {

	public void insert(Enchere enchere);
	
	//A voir avec une foreign key: public void selectById(int une): Utilisateur;

	public void selectAll(): List<Enchere>;
	
}
