package com.isis.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iDImage;

    @Column
    private Timestamp date;

    @Column
    private Timestamp heure;

    @Column
    private byte[] image;

// CONSTRUCTOR
    public Image() {
        super();
    }

    public Image(int iDImage, Timestamp date, Timestamp heure, byte[] image) {
        super();
        this.iDImage = iDImage;
        this.date = date;
        this.heure = heure;
        this.image = image;
    }

// GETTER SETTER
    public int getiDImage() {
        return iDImage;
    }

    public void setiDImage(int iDImage) {
        this.iDImage = iDImage;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

