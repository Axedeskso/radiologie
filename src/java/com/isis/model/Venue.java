/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isis.model;

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
    @Column(name = "iep")
    private int iep;
    @Column
    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    private List<Acte> actes;

    public Venue(){}
    
    public Venue(Patient patient){
        this.patient = patient;
    }
    
    public Venue(Patient patient, List<Acte> actes) {
        this.patient = patient;
        this.actes = actes;
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