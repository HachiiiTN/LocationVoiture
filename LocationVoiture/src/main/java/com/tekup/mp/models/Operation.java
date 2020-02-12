package com.tekup.mp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long operationID;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDebut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFin;
	private double montantGarantie;
	private String typeGarantie;
	private double fraisLocation;
	private String typePayement;
	
	@OneToOne
	private Car car;
	
	public Operation() {
		super();
	}

	public Operation(Date dateDebut, Date dateFin, double montantGarantie, String typeGarantie,
			double fraisLocation, String typePayement) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montantGarantie = montantGarantie;
		this.typeGarantie = typeGarantie;
		this.fraisLocation = fraisLocation;
		this.typePayement = typePayement;
	}

	public Long getOperationID() {
		return operationID;
	}

	public void setOperationID(Long operationID) {
		this.operationID = operationID;
	}
	
	

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
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
	
}
