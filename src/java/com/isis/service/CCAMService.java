package com.isis.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CCAMService {
    EntityManager em;

    public CCAMService(EntityManager em) {
        this.em = em;
    }
}
