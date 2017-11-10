package com.isis.service;

import com.isis.model.Patient;
import com.isis.model.Venue;
import java.util.List;

import javax.persistence.EntityManager;
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

    public Venue newVenue(Patient p) {
        Venue v = new Venue(p);
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        return v;
    }

    //GET
    public Venue getById(int iep) {
        Venue res = em.find(Venue.class, iep);
        return res;
    }
//
    public List<Venue> getByIPP(int ipp) {
        TypedQuery<Venue> query = em.createQuery("SELECT v FROM Venue v JOIN v.patient p WHERE p.ipp = :ipp", Venue.class).setParameter("ipp", ipp);
        List<Venue> res = query.getResultList();
        return res;
    }

    public List<Venue> getAll() {
        TypedQuery<Venue> query = em.createQuery("SELECT v FROM Venue v", Venue.class);
        List<Venue> res = query.getResultList();
        return res;
    }
    
    //UPDATE
    public void updateActe(Venue cr) {
        em.getTransaction().begin();
        em.merge(cr);
        em.getTransaction().commit();
    }
    
    //DELETE
    public void removeVenue(int iep) {
        Venue cr = em.find(Venue.class, iep);
        em.getTransaction().begin();
        em.remove(cr);
        em.getTransaction().commit();
    }
//    
    public void removeAll(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Venue").executeUpdate();
        em.getTransaction().commit();
    }
}