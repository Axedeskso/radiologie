package com.isis.service;

import javax.persistence.EntityManager;

public class ImageService {
    EntityManager em;

    public ImageService(EntityManager em) {
        this.em = em;
    }
    
    public ImageService(){
    }
    
    
}