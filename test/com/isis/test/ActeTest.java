package com.isis.test;

import com.isis.configuration.DatabaseUtils;
import com.isis.model.Acte;
import com.isis.model.Ccam;
import com.isis.model.Patient;
import com.isis.model.Venue;
import com.isis.service.ActeService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActeTest {
    
    static EntityManagerFactory fact;
    
    public ActeTest(){}
    
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

    public void clean() {
        ActeService serv = new ActeService(DatabaseUtils.fact());
        serv.removeAll();
        List<Acte> res = serv.getAll();
        assert(res.isEmpty());
    }
    
    
    @Test
    public void acte() {
//        clean();
        ActeService serv = new ActeService(DatabaseUtils.fact());
        
        Patient a1 = new Patient("McLANE", "John");
        
        Venue v1 = new Venue(a1);
        Venue v2 = new Venue(a1);
        Venue v3 = new Venue(a1);
        
        Ccam c1 = new Ccam("ccamCode", "NomCCAM", (float) 15.50);
        Ccam c2 = new Ccam("ccamCode2", "NomCCAM2", (float) 1.2);
        
        Acte a = serv.newActe(v1, null, null, c1);
        assertNotNull(a);
        
        Acte a2 = serv.newActe(v2, null, null, c2);
        Acte a3 = serv.newActe(v3, null, null, c2);
        
        List<Acte> res = serv.getAll();
        assert(!res.isEmpty());
        assert(res.size() == 3);  
        
    }
}
    
