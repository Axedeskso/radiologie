package com.isis.service;

import com.isis.model.Acte;
import com.isis.model.CCAM;
import com.isis.model.Patient;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class ActeService {

    EntityManagerFactory fact;
    EntityManager em;

    public ActeService(EntityManagerFactory fact) {
        this.fact = fact;
        this.em = fact.createEntityManager();
    }

    public void newActe(Acte a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    public void newActe(Patient p, Timestamp date, Timestamp heure, CCAM ccam) {
        Acte a = new Acte(p, date, heure, ccam);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    public void remove(int id) {
        Acte cr = em.find(Acte.class, id);
        em.getTransaction().begin();
        em.remove(cr);
        em.getTransaction().commit();

    }

    public void edit(Acte cr) {
        em.getTransaction().begin();
        em.merge(cr);
        em.getTransaction().commit();

    }

    public Acte getById(int id) {
        Acte res = em.find(Acte.class, id);
        return res;
    }

    public List<Acte> getByIEP(int iep) {
        TypedQuery<Acte> query = em.createQuery("SELECT c FROM Acte a JOIN a.patient p WHERE p.iep = :iep", Acte.class)
                .setParameter("iep", iep);
        List<Acte> res = query.getResultList();
        return res;
    }

    public List<Acte> getAll() {
        TypedQuery<Acte> query = em.createQuery("SELECT a FROM Acte a", Acte.class);
        List<Acte> res = query.getResultList();
        return res;
    }

}
