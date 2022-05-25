package fr.eni.java.projet.bo;

import java.util.Date;

public class Enchère {

	private Date dateEnchère;
	private int montant_enchere;

	public Date getDateEnchère() {
		return dateEnchère;
	}

	public void setDateEnchère(Date dateEnchère) {
		this.dateEnchère = dateEnchère;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Enchère() {
		super();
	}

	public Enchère(Date dateEnchère, int montant_enchere) {
		super();
		this.dateEnchère = dateEnchère;
		this.montant_enchere = montant_enchere;
	}

	@Override
	public String toString() {
		return "Enchère [dateEnchère=" + dateEnchère + ", montant_enchere=" + montant_enchere + ", getDateEnchère()="
				+ getDateEnchère() + ", getMontant_enchere()=" + getMontant_enchere() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
