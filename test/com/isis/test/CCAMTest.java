package com.isis.test;


import com.isis.configuration.DatabaseUtils;
import com.isis.model.Acte;
import com.isis.model.CCAM;
import com.isis.model.Patient;
import com.isis.service.ActeService;
import com.isis.service.CCAMService;
import com.isis.service.PatientService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CCAMTest {
    
    static EntityManagerFactory fact;
    
    public CCAMTest(){}
    
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
        CCAMService serv = new CCAMService(DatabaseUtils.fact());
        serv.removeAll();
        List<CCAM> res = serv.getAll();
        assert(res.isEmpty());
    }
    
        
    @Test
    public void ccam() {
        clean();
        CCAMService serv = new CCAMService(DatabaseUtils.fact());
        CCAM c = serv.newCcam("test", "test", (float) 10.0);
        assertNotNull(c); 
        List<CCAM> res = serv.getAll();
        assert(!res.isEmpty());
        assert(res.size() == 1);  
        
        CCAM r = serv.getByCode("test");
        assert(r!= null && r.getCode().equals("test"));
    }
}
    
