package com.isis.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MODALITE")
public class Modalite implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nom;
    @Column
    private String pacs;
    @Column
    private String link;

    public Modalite() {
        super();
    }

    public Modalite(String nom, String pacs, String link) {
        this.nom = nom;
        this.pacs = pacs;
        this.link = link;
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

    public String getPacs() {
        return pacs;
    }

    public void setPacs(String pacs) {
        this.pacs = pacs;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
