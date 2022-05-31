package fr.eni.java.projet.bo;

import java.util.Date;

public class ArticleVendu {
	
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private double miseAPrix;
	private int prixVente;
	private int etatVente;
	private Retrait retrait;
	private int noCategorie;
	private int noUtilisateur;

	
	public int getNoArticle() {
		return this.noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return this.nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEncheres() {
		return this.dateDebutEncheres;
	}
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public Date getDateFinEncheres() {
		return this.dateFinEncheres;
	}
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public double getMiseAPrix() {
		return this.miseAPrix;
	}
	public void setMiseAPrix(double miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public int getPrixVente() {
		return this.prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public int getEtatVente() {
		return this.etatVente;
	}
	public void setEtatVente(int etatVente) {
		this.etatVente = etatVente;
	}
	
	public Retrait getRetrait() {
		return retrait;
	}
	
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	
	public int getNoCategorie() {
		return noCategorie;
	}
	
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public ArticleVendu() {
	
	}
	
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			double miseAPrix, int prixVente, int etatVente, Retrait retrait, int noCategorie, int noUtilisateur) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.retrait = retrait;
		this.noCategorie = noCategorie;
		this.noUtilisateur = noUtilisateur;
	}
	
	// instanciation d'un objet ArticleVendu avc TOUS les paramètres ( objet Retrait compris)
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, double miseAPrix, int prixVente, int etatVente, Retrait retrait, int noCategorie,
			int noUtilisateur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.retrait = retrait;
		this.noCategorie = noCategorie;
		this.noUtilisateur = noUtilisateur;
	}
	@Override
	public String toString() {
		return "Historique de la vente de l'article:%n [noArticle=" + this.noArticle + ", nomArticle=" + this.nomArticle + ", description="
				+ this.description + ", dateDebutEncheres=" + this.dateDebutEncheres + ", dateFinEncheres="
				+ this.dateFinEncheres + ", miseAPrix=" + this.miseAPrix + ", prixVente=" + this.prixVente
				+ ", etatVente=" + this.etatVente + "]";
	}
	
	
}
