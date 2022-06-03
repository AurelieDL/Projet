package fr.eni.java.projet.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.exceptions.BusinessException;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur);
	
	public Utilisateur selectById(int noUtilisateur);
	
	public Utilisateur selectByName(String name) throws SQLException;
	
	public Utilisateur selectByEmail(String mail ) throws SQLException;

	public List<Utilisateur> selectAll();

	public void update(Utilisateur utilisateur);
	
	public void delete(int noUtilisateur);
	
//	public boolean checkPseudoUnique(String pseudo) throws BusinessException;

}
