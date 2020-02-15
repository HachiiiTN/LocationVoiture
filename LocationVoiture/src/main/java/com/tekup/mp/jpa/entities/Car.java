package com.tekup.mp.jpa.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carID;

	private String immatriculation;
	private String marque;
	private String modele;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateMiseCirculation;
	private Double prixLocation;
	private String etat;

	public Car() {
		super();
	}

	public Car(Long carID, String immatriculation, String marque, String modele, Date dateMiseCirculation,
			Double prixLocation, String etat) {
		super();
		this.carID = carID;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.dateMiseCirculation = dateMiseCirculation;
		this.prixLocation = prixLocation;
		this.etat = etat;
	}

	
	
	public Long getCarID() {
		return carID;
	}

	public void setCarID(Long carID) {
		this.carID = carID;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Date getDateMiseCirculation() {
		return dateMiseCirculation;
	}

	public void setDateMiseCirculation(Date dateMiseCirculation) {
		this.dateMiseCirculation = dateMiseCirculation;
	}

	public Double getPrixLocation() {
		return prixLocation;
	}

	public void setPrixLocation(Double prixLocation) {
		this.prixLocation = prixLocation;
	}
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}
	
	

}
