package com.isis.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ImageService {
    EntityManager em;

    public ImageService(EntityManagerFactory fact) {
        this.em = em;
    }
}