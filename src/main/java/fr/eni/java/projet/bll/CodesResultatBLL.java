package fr.eni.java.projet.bll;

/**
 * Les codes disponibles sont entre 10000 à 19999 pour les erreurs d'inscription
 */

/**
 * Les codes disponibles sont entre 20000 et 29999 pour les erreurs de login
 */

public abstract class CodesResultatBLL {
	
	/**
	 * Echec quand le pseudo n'a pas que des caractères alpha-numériques
	 */
	public static final int REGLE_INSCRIPTION_PSEUDO_ALPHANUMERIQUE_ERREUR=10000;
	/**
	 * Echec quand le pseudo est déjà utilisé dans la BDD
	 */
	public static final int REGLE_INSCRIPTION_PSEUDO_UNIQUE_ERREUR=10001;
	/**
	 * Echec quand l'e-mail est déjà utilisé dans la BDD
	 */
	public static final int REGLE_INSCRIPTION_EMAIL_UNIQUE_ERREUR=10002;
	/**
	 * Echec quand le numéro de téléphone ne comporte pas que des nombres
	 */
	public static final int REGLE_INSCRIPTION_TELEPHONE_NUMERIQUE_ERREUR=10003;
	/**
	 * Echec quand la valeur du login est null
	 */
	public static final int REGLE_LOGIN_USERNAME_NULL_ERREUR=20000;
	/**
	 * Echec quand le pseudo n'est pas retrouvé dans la BDD
	 */
	public static final int REGLE_LOGIN_USERNAME_NOT_EXIST_ERREUR=20001;
	/**
	 * Echec quand la valeur du mot de passe est null
	 */
	public static final int REGLE_LOGIN_PASSWORD_NULL_ERREUR=20002;
	/**
	 * Echec quand la valeur du mot de passe est différente de celui stocké dans la BDD
	 */
	public static final int REGLE_LOGIN_PASSWORD_WRONG_ERREUR=20003;
	
}
