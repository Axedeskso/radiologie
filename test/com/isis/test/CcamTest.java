package com.isis.test;

import com.isis.configuration.DatabaseUtils;
import com.isis.model.Ccam;
import com.isis.service.CcamService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CcamTest {
    
    static EntityManagerFactory fact;
    
    public CcamTest(){}
    
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
        CcamService serv = new CcamService(DatabaseUtils.fact());
        serv.removeAll();
        List<Ccam> res = serv.getAll();
        assert(res.isEmpty());
    }
    
        
    @Test
    public void ccam() {
//        clean();
        CcamService serv = new CcamService(DatabaseUtils.fact());
        Ccam c = serv.newCcam("ZBQK002", "Radiologie du thorax", (float) 10.0);
        assertNotNull(c); 
        c = serv.newCcam("ZCQK002", "Radiologie de l'abdomen sans préparation", (float) 12.5);
        assertNotNull(c); 
        c = serv.newCcam("EAQH002", "Scannographie des vaisseaux encéphaliques", (float) 12.5);
        assertNotNull(c); 
        List<Ccam> res = serv.getAll();
        assert(!res.isEmpty());
        assert(res.size() == 3);  
        
        Ccam r = serv.getByCode("ZBQK002");
        assert(r!= null && r.getCode().equals("ZBQK002"));
    }
}
    
