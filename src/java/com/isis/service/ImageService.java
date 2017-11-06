package com.isis.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ImageService {
        EntityManagerFactory fact;
    EntityManager em;

    public ImageService(EntityManagerFactory fact) {
        this.fact = fact;
        this.em = fact.createEntityManager();
    }
}