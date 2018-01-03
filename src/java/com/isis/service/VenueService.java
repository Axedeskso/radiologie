package com.isis.service;

import com.isis.model.Patient;
import com.isis.model.Venue;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class VenueService {

    EntityManager em;

    public VenueService(EntityManager em) {
        this.em = em;
    }
    
    public VenueService(){
    }
    
    public void newVenue(Venue v) {
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
    }

    public Venue getByIEP(int iep) {
        TypedQuery<Venue> res = em.createQuery("SELECT v FROM Venue v WHERE v.iep = :iep",Venue.class).setParameter("iep", iep);
        return res.getSingleResult();
    }

    public List<Venue> getByPatient(Patient p) {
        TypedQuery<Venue> query =  em.createQuery("SELECT v FROM Venue v WHERE v.patient = :patient",Venue.class).setParameter("patient", p);
        List<Venue> res = query.getResultList();
        return res;
    }
    
    public List<Venue> getAll() {
        TypedQuery<Venue> query = em.createQuery("SELECT v FROM Venue v", Venue.class);
        List<Venue> res = query.getResultList();
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
        em.createQuery("DELETE FROM Venue").executeUpdate();
        em.getTransaction().commit();
    }
}