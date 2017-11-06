package com.isis.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CCAMService {
        EntityManagerFactory fact;
    EntityManager em;

    public CCAMService(EntityManagerFactory fact) {
        this.fact = fact;
        this.em = fact.createEntityManager();
    }
}
