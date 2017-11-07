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
    private String ipp;
    @Column
    private String iep;

    public Patient(){
    }
    
    public Patient(String nom, String prenom, String IPP, String IEP) {
        this.nom = nom;
        this.prenom = prenom;
        this.ipp = IPP;
        this.iep = IEP;
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

    public String getIpp() {
        return ipp;
    }

    public void setIpp(String ipp) {
        this.ipp = ipp;
    }

    public String getIep() {
        return iep;
    }

    public void setIep(String iep) {
        this.iep = iep;
    }
}