package com.isis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
public class Patient{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ipp;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private int iep;

    public Patient(){
    }
    
    public Patient(String nom, String prenom, int iep) {
        this.nom = nom;
        this.prenom = prenom;
        
        this.iep = iep;
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

    public int getIpp() {
        return ipp;
    }

    public void setIpp(int ipp) {
        this.ipp = ipp;
    }

    public int getIep() {
        return iep;
    }

    public void setIep(int iep) {
        this.iep = iep;
    }
}