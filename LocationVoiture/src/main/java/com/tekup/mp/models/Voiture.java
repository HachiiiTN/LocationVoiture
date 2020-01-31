package com.tekup.mp.models;

import java.io.Serializable;
//import java.util.Date;
import java.sql.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
@Entity
public class Voiture implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long voitureID;
	
	private String immatriculation;
	private String marque;
	private Date dateMiseCirculation;
	private Double prixLocation;
	
	public Voiture() {
		super();
	}

	public Voiture(Long voitureID, String immatriculation, String marque, Date dateMiseCirculation,
			double prixLocation) {
		super();
		this.voitureID = voitureID;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.dateMiseCirculation = dateMiseCirculation;
		this.prixLocation = prixLocation;
	}
	
	@Override
	public String toString() {
		return "Voiture [immatriculation=" + immatriculation + ", marque=" + marque + ", dateMiseCirculation="
				+ dateMiseCirculation + ", prixLocation=" + prixLocation + "]";
	}
	
}
