package com.isis.service;

import com.isis.model.Modalite;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class ModaliteService {

    EntityManager em;

    public ModaliteService(EntityManager em) {
        this.em = em;
    }

    public void newModalite(Modalite m) {
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }

    public Modalite newModalite(String nom, String pacs, String link) {
        Modalite m = new Modalite(nom, pacs, link);
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        return m;
    }
    
    //GET
    public List<Modalite> getAll() {
        TypedQuery<Modalite> query = em.createQuery("SELECT m FROM Modalite m", Modalite.class);
        List<Modalite> res = query.getResultList();
        return res;
    }
    
    public Modalite getById(int id){
        Modalite res = em.find(Modalite.class, id);
        return res;
    }
    
    public Modalite getByName(String name) {
        TypedQuery<Modalite> res = em.createQuery("SELECT  m FROM Modalite m WHERE m.nom = :nom",Modalite.class).setParameter("nom", name);
        return res.getSingleResult();
    }
    
    public List<Modalite> getByPacs(String pacs) {
        TypedQuery<Modalite> query = em.createQuery("SELECT m FROM Modalite m WHERE m.pacs = :pacs",Modalite.class).setParameter("pacs", pacs);
        List<Modalite> res = query.getResultList();
        return res;
    }
     
     //UPDATE
    public void updateModalite(Modalite m) {
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
    }
    
    //DELETE
    public void remove(int id) {
        Modalite m = em.find(Modalite.class, id);
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
    }
    
    
    public void removeAll(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Modalite").executeUpdate();
        em.getTransaction().commit();
    }
}
