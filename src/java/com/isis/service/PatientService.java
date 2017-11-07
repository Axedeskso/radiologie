package com.isis.service;

import com.isis.model.Patient;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class PatientService {

    EntityManager em;

    public PatientService(EntityManager em) {
        System.out.println("EM : " + em == null);
        this.em = em;
    }
    
    public PatientService(){
    }
    
    public Patient newPatient(String nom, String prenom, String ipp, String iep){
        Patient p = new Patient(nom, prenom, ipp, iep);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    public Patient getByIEP(String iep) {
        TypedQuery<Patient> res = em.createQuery("SELECT p FROM Patient p WHERE p.IEP = :iep",Patient.class).setParameter("iep", iep);
       
        return res.getSingleResult();
    }

    public List<Patient> getAll() {
        TypedQuery<Patient> query = em.createQuery("SELECT a FROM Patient a", Patient.class);
        List<Patient> res = query.getResultList();
        return res;
    }
}