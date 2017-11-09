package com.isis.service;

import com.isis.model.Ccam;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CcamService {
    EntityManager em;

    public CcamService(EntityManager em) {
        this.em = em;
    }
    
    public CcamService(){
        
    }
    
    //NOUVEAU
    public void newCcam(Ccam c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public Ccam newCcam(String code, String libelle, float cout) {
        Ccam c = new Ccam(code, libelle, cout);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }
    
    //GET
    public Ccam getByCode(String code) {
        TypedQuery<Ccam> res = em.createQuery("SELECT c FROM Ccam c WHERE c.code = :code",Ccam.class).setParameter("code", code);
        return res.getSingleResult();
    }
    
    public List<Ccam> getAll() {
        TypedQuery<Ccam> query = em.createQuery("SELECT c FROM Ccam c", Ccam.class);
        List<Ccam> res = query.getResultList();
        return res;
    }
    
     //UPDATE
    public void updateCcam(Ccam c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }
    
    //DELETE
    public void removeCcam(int id) {
        Ccam c = em.find(Ccam.class, id);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }
    
    public void removeAll(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Ccam").executeUpdate();
        em.getTransaction().commit();
    }
    
}
