package fr.codevallee.formation.tp1;

public class Agence {
	
	private String idAgence;
	private String nom;
	private String adresse;
	
	public Agence(String idAgence,String nom,String adresse) {
		this.idAgence=idAgence;
		this.nom=nom;
		this.adresse=adresse;
	}

	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
}
