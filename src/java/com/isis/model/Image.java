package com.isis.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Timestamp date;

    @Column
    private Timestamp heure;
    
    @Column
    private byte[] image;
    
    @Column
    private Modalite modalite;

    public Image() {
        super();
    }

    public Image(Timestamp date, Timestamp heure, byte[] image) {
        super();
        this.date = date;
        this.heure = heure;
        this.image = image;
    }

// GETTER SETTER
    public int getiDImage() {
        return id;
    }

    public void setiDImage(int id) {
        this.id = id;
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