package com.isis.service;

import com.isis.model.Acte;
import com.isis.model.Ccam;
import com.isis.model.Venue;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ActeService {

    EntityManager em;

    public ActeService(EntityManager em) {
        this.em = em;
    }
    
    public ActeService(){
        
    }

    public void newActe(Acte a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    public Acte newActe(Venue v, Timestamp date, Timestamp heure, Ccam ccam) {
        Acte a = new Acte(v, date, heure, ccam);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }

    //GET
    public Acte getById(int id) {
        Acte res = em.find(Acte.class, id);
        return res;
    }
    
    public List<Acte> getByVenue(Venue v) {
        TypedQuery<Acte> query =  em.createQuery("SELECT a FROM Acte a WHERE a.venue = :venue",Acte.class).setParameter("venue", v);
        List<Acte> res = query.getResultList();
        return res;
    }

    public List<Acte> getAll() {
        TypedQuery<Acte> query = em.createQuery("SELECT a FROM Acte a", Acte.class);
        List<Acte> res = query.getResultList();
        return res;
    }

    //UPDATE
    public void updateActe(Acte cr) {
        em.getTransaction().begin();
        em.merge(cr);
        em.getTransaction().commit();
    }
    
    //DELETE
    public void removeActe(int id) {
        Acte cr = em.find(Acte.class, id);
        em.getTransaction().begin();
        em.remove(cr);
        em.getTransaction().commit();
    }
    
    public void removeAll(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Acte").executeUpdate();
        em.getTransaction().commit();
    }

}
