package com.tekup.mp.models;

public class Operation {

	private String dateDebut;
	private String dateFin;
	private double montantGarantie;
	private String typeGarantie;
	private double fraisLocation;
	private String typePayement;
	
	public Operation() {
		super();
	}

	public Operation(String dateDebut, String dateFin, double montantGarantie, String typeGarantie,
			double fraisLocation, String typePayement) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montantGarantie = montantGarantie;
		this.typeGarantie = typeGarantie;
		this.fraisLocation = fraisLocation;
		this.typePayement = typePayement;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public double getMontantGarantie() {
		return montantGarantie;
	}

	public void setMontantGarantie(double montantGarantie) {
		this.montantGarantie = montantGarantie;
	}

	public String getTypeGarantie() {
		return typeGarantie;
	}

	public void setTypeGarantie(String typeGarantie) {
		this.typeGarantie = typeGarantie;
	}

	public double getFraisLocation() {
		return fraisLocation;
	}

	public void setFraisLocation(double fraisLocation) {
		this.fraisLocation = fraisLocation;
	}

	public String getTypePayement() {
		return typePayement;
	}

	public void setTypePayement(String typePayement) {
		this.typePayement = typePayement;
	}

	@Override
	public String toString() {
		return "Operation [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", montantGarantie=" + montantGarantie
				+ ", typeGarantie=" + typeGarantie + ", fraisLocation=" + fraisLocation + ", typePayement="
				+ typePayement + "]";
	}
	
}
