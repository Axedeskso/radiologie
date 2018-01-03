package com.isis.model;

import java.io.Serializable;
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
public class Acte implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Venue venue;

    @OneToMany
    private List<Image> images;
    
    @Column
    private Timestamp date;

    @Column
    private Timestamp heure;

    @Column
    private Ccam ccam;

    public Acte() {
        super();
    }

    public Acte(Venue v, Timestamp date, Timestamp heure, Ccam codeCCAM) {
        this.venue = v;
        this.date = date;
        this.heure = heure;
        this.ccam = codeCCAM;
    }

    public int getiDActe() {
        return id;
    }

    public void setiDActe(int id) {
        this.id = id;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
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

    public Ccam getCcam() {
        return ccam;
    }

    public void setCcam(Ccam ccam) {
        this.ccam = ccam;
    }

    
}