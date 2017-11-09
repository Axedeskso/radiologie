package com.isis.service;

import com.isis.model.Image;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
    
    //GET        
    public Image getById(int id) {
        Image res = em.find(Image.class, id);
        return res;
    }

    public List<Image> getAll() {
        TypedQuery<Image> query = em.createQuery("SELECT i FROM Image i", Image.class);
        List<Image> res = query.getResultList();
        return res;
    }
    
    //DELETE
    public void removeImage(int id) {
        Image i = em.find(Image.class, id);
        em.getTransaction().begin();
        em.remove(i);
        em.getTransaction().commit();
    }
    
    public void removeAll(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Image").executeUpdate();
        em.getTransaction().commit();
    }
    
}