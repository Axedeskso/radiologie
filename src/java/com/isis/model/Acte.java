package com.isis.model;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACTE")
public class Acte {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iDActe;

    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;

    @OneToMany
    private List<Image> images;
    
    @Column(name = "date")
    private Timestamp date;

    @Column(name = "heure")
    private Timestamp heure;

    @ManyToOne(cascade = CascadeType.ALL)
    private CCAM ccam;

    public Acte() {
        super();
    }

    public Acte(Patient p, Timestamp date, Timestamp heure, CCAM codeCCAM) {
        patient = p;
        this.date = date;
        this.heure = heure;
        this.ccam = codeCCAM;
    }

    public int getiDActe() {
        return iDActe;
    }

    public void setiDActe(int iDActe) {
        this.iDActe = iDActe;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getHeure() {
        return heure;
    }

    public void setHeure(Timestamp heure) {
        this.heure = heure;
    }

    public CCAM getCcam() {
        return ccam;
    }

    public void setCcam(CCAM ccam) {
        this.ccam = ccam;
    }

    
}