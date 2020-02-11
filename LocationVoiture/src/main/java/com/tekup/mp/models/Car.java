package com.tekup.mp.models;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateMiseCirculation;
	private Double prixLocation;

	public Car() {
		super();
	}

	public Car(Long carID, String immatriculation, String marque, Date dateMiseCirculation,
			Double prixLocation) {
		super();
		this.carID = carID;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.dateMiseCirculation = dateMiseCirculation;
		this.prixLocation = prixLocation;
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

	@Override
	public String toString() {
		return "Car [immatriculation=" + immatriculation + ", marque=" + marque + ", dateMiseCirculation="
				+ dateMiseCirculation + ", prixLocation=" + prixLocation + "]";
	}
	
	

}
