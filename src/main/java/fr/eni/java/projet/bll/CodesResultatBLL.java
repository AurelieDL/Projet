package fr.eni.java.projet.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec quand la description de l'avis ne repsecte pas les règles définies
	 */
	public static final int REGLE_LOGIN_USERNAME_NULL_ERREUR=20000;
	/**
	 * Echec quand la description de l'avis ne repsecte pas les règles définies
	 */
	public static final int REGLE_LOGIN_USERNAME_NOT_EXIST_ERREUR=20001;
	
	public static final int REGLE_LOGIN_PASSWORD_NULL_ERREUR=20002;
	
	public static final int REGLE_LOGIN_PASSWORD_WRONG_ERREUR=20003;
	
}
