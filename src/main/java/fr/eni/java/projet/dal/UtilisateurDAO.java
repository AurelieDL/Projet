package fr.eni.java.projet.dal;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur);
	
	public void selectById(int noUtilisateur): Utilisateur;

	public void selectAll(): List<Utilisateur>;

	public void update(Utilisateur utilisateur);

	public void delete(Utilisateur utilisateur);
}
