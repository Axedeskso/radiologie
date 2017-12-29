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
@Table(name = "VENUE")
public class Venue {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iep;

    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;

    @OneToMany
    private List<Acte> actes;

    public Venue() {
        super();
    }

    public Venue(Patient p) {
        this.patient = p;
    }

    public int getIep() {
        return iep;
    }

    public void setIep(int iep) {
        this.iep = iep;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Acte> getActes() {
        return actes;
    }

    public void setActes(List<Acte> actes) {
        this.actes = actes;
    }


}