package com.isis.service;

import com.isis.model.Acte;
import com.isis.model.Ccam;
import com.isis.model.Patient;
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

    public Acte newActe(Patient p, Timestamp date, Timestamp heure, Ccam ccam) {
        Acte a = new Acte(p, date, heure, ccam);
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

    public List<Acte> getByIEP(int iep) {
        TypedQuery<Acte> query = em.createQuery("SELECT a FROM Acte a JOIN a.patient p WHERE p.iep = :iep", Acte.class).setParameter("iep", iep);
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
