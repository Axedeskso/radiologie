package com.isis.service;

import com.isis.model.Modalite;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

    public void newModalite(String nom, String pacs, String link) {
        Modalite m = new Modalite(nom, pacs, link);
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }
}
