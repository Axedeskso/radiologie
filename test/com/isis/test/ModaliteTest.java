package com.isis.test;

import com.isis.configuration.DatabaseUtils;
import com.isis.model.Modalite;
import com.isis.service.ModaliteService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModaliteTest {
    
    static EntityManagerFactory fact;
    
    public ModaliteTest(){}
    
    @BeforeClass
    public static void setUpClass() {
         //fact = Persistence.createEntityManagerFactory("bureauPU");
    }
    
    @AfterClass
    public static void tearDownClass() {
        //fact.close();
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    
    public void clean() {
        ModaliteService serv = new ModaliteService(DatabaseUtils.fact());
        serv.removeAll();
        List<Modalite> res = serv.getAll();
        assert(res.isEmpty());
    }
    
        
    @Test
    public void modalite() {
        clean();
        ModaliteService serv = new ModaliteService(DatabaseUtils.fact());
        Modalite m = serv.newModalite("CR", "ISIS", "/resources/isis");
        assertNotNull(m);
        m = serv.newModalite("RF", "ISIS", "/resources/isis");
        assertNotNull(m); 
        m = serv.newModalite("PX", "ISIS", "/resources/isis");
        assertNotNull(m); 
        m = serv.newModalite("IO", "ISIS", "/resources/isis");
        assertNotNull(m); 
        m = serv.newModalite("CT", "ISIS", "/resources/isis");
        assertNotNull(m); 
        List<Modalite> res = serv.getAll();
        assert(!res.isEmpty());
        assert(res.size() == 5);  
        
        List<Modalite> p = serv.getByPacs("ISIS");
        assert(p.size() == 5);
        
        Modalite q = serv.getByName("CT");
        assert(!res.isEmpty());
        assert(res.size() == 5);
    }
}
    
