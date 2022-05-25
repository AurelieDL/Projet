package fr.eni.java.projet.bo;

public class Retrait {
	private String rue;
	private int code_postal;
	private String ville;

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCode_postal() {
		return this.code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Retrait() {
	}

	public Retrait(String rue, int code_postal, String ville) {
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Le retrait [rue=" + this.rue + ", code_postal=" + this.code_postal + ", ville=" + this.ville + "]";
	}

}
