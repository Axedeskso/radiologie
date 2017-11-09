package com.isis.test;

import com.isis.configuration.DatabaseUtils;
import com.isis.model.Acte;
import com.isis.model.Ccam;
import com.isis.model.Patient;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    
    public void clean() {
        ActeService serv = new ActeService(DatabaseUtils.fact());
        serv.removeAll();
        List<Acte> res = serv.getAll();
        assert(res.isEmpty());
    }
    
        
    @Test
    public void acte() {
        clean();
        ActeService serv = new ActeService(DatabaseUtils.fact());
        Patient a1 = new Patient("McLANE", "John", 218);
        Ccam c1 = new Ccam("ccamCode", "NomCCAM", (float) 15.50);
        Acte a = serv.newActe(a1, null, null, c1);
        assertNotNull(a); 
        Ccam c2 = new Ccam("ccamCode2", "NomCCAM2", (float) 1.2);
        Acte a2 = serv.newActe(a1, null, null, c2);
        List<Acte> res = serv.getAll();
        assert(!res.isEmpty());
        assert(res.size() == 2);  
        
    }
}
    
