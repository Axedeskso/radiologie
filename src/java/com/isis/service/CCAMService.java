package com.isis.service;

import com.isis.model.CCAM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CCAMService {
    EntityManager em;

    public CCAMService(EntityManager em) {
        this.em = em;
    }
    
    public CCAMService(){
        
    }
    
    //NOUVEAU
    public void newCcam(CCAM c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public CCAM newCcam(String code, String libelle, float cout) {
        CCAM c = new CCAM(code, libelle, cout);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }
    
    //GET
    public List<CCAM> getAll() {
        TypedQuery<CCAM> query = em.createQuery("SELECT c FROM CCAM c", CCAM.class);
        List<CCAM> res = query.getResultList();
        return res;
    }
    
     public CCAM getByCode(String code) {
        TypedQuery<CCAM> res = em.createQuery("SELECT p FROM CCAM p WHERE p.code = :code",CCAM.class).setParameter("code", code);
        return res.getSingleResult();
    }
    
     //UPDATE
    public void edit(CCAM c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }
    
    //DELETE
    public void remove(int id) {
        CCAM c = em.find(CCAM.class, id);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }
    
    public void removeAll(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM CCAM").executeUpdate();
        em.getTransaction().commit();
    }
    
}
