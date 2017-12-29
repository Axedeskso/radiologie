package com.isis.service;

import com.isis.model.Patient;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class PatientService {

    EntityManager em;

    public PatientService(EntityManager em) {
        this.em = em;
    }
    
    public PatientService(){
    }
    
    public void newPatient(Patient p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public Patient newPatient(String nom, String prenom){
        Patient p = new Patient(nom, prenom);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    public Patient getByIPP(int ipp) {
        TypedQuery<Patient> res = em.createQuery("SELECT p FROM Patient p WHERE p.ipp = :ipp",Patient.class).setParameter("ipp", ipp);
        return res.getSingleResult();
    }

    public List<Patient> getAll() {
        TypedQuery<Patient> query = em.createQuery("SELECT a FROM Patient a", Patient.class);
        List<Patient> res = query.getResultList();
        return res;
    }
    
    public void updatePatient(Patient p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
    
    public void removePatient(int id){
        Patient p = em.find(Patient.class, id);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
    
    public void removeAll(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Patient").executeUpdate();
        em.getTransaction().commit();
    }
}