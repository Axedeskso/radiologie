package com.isis.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseUtils {
    
    private static EntityManagerFactory fact = null;
    private static EntityManager em = null;


    static public EntityManager fact() {
        if (fact == null) {
             fact = Persistence.createEntityManagerFactory("localPU");
             em = fact.createEntityManager();
        }
        return em;
   }
    
   static public void close() {
       em.close();
       fact.close();
   }
   
    static public EntityManager factTest() {
         if (fact == null) {
             fact = Persistence.createEntityManagerFactory("radioTestPU");
             em = fact.createEntityManager();
         }
         return em; 
   }
    
    
}
    
  
