package com.isis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
public class Patient {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String IPP;
    @Column
    private String IEP;

    public Patient(String nom, String prenom, String IPP, String IEP) {
        this.nom = nom;
        this.prenom = prenom;
        this.IPP = IPP;
        this.IEP = IEP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIPP() {
        return IPP;
    }

    public void setIPP(String IPP) {
        this.IPP = IPP;
    }

    public String getIEP() {
        return IEP;
    }

    public void setIEP(String IEP) {
        this.IEP = IEP;
    }
}