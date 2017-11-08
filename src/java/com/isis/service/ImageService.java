package com.isis.service;

import com.isis.model.Image;
import java.sql.Timestamp;
import javax.persistence.EntityManager;

public class ImageService {
    EntityManager em;

    public ImageService(EntityManager em) {
        this.em = em;
    }
    
    public ImageService(){
    }
    
    public void newImage(Image i) {
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
    }

    public Image newActe(Timestamp date, Timestamp heure, byte[] image) {
        Image i = new Image();
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        return i;
    }
}