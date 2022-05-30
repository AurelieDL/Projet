package fr.eni.java.projet.dal;

import java.util.List;

import fr.eni.java.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur);
	
	public Utilisateur selectById(int noUtilisateur);
	
	
	//public Utilisateur selectByName(String name);
	

	public List<Utilisateur> selectAll();

	public void update(Utilisateur utilisateur);

	public void delete(Utilisateur utilisateur);
}
