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
	public ArticleVendu() {
	}
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, double miseAPrix, int prixVente, int etatVente) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			double miseAPrix, int prixVente, int etatVente) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	@Override
	public String toString() {
		return "Historique de la vente de l'article:%n [noArticle=" + this.noArticle + ", nomArticle=" + this.nomArticle + ", description="
				+ this.description + ", dateDebutEncheres=" + this.dateDebutEncheres + ", dateFinEncheres="
				+ this.dateFinEncheres + ", miseAPrix=" + this.miseAPrix + ", prixVente=" + this.prixVente
				+ ", etatVente=" + this.etatVente + "]";
	}
	
	
}
