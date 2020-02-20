package com.tekup.mp.web.model.requests;

import com.tekup.mp.jpa.entities.Car;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OperationForm {

    private Long operationID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    private double montantGarantie;
    private String typeGarantie;
    private double fraisLocation;
    private String typePayement;
    private Car car;

    public Long getOperationID() {
        return operationID;
    }

    public void setOperationID(Long operationID) {
        this.operationID = operationID;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "OperationForm{" +
                "operationID=" + operationID +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", montantGarantie=" + montantGarantie +
                ", typeGarantie='" + typeGarantie + '\'' +
                ", fraisLocation=" + fraisLocation +
                ", typePayement='" + typePayement + '\'' +
                '}';
    }
}
