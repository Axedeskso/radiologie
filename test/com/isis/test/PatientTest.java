package com.isis.test;

import com.isis.configuration.DatabaseUtils;
import com.isis.model.Acte;
import com.isis.model.Patient;
import com.isis.service.ActeService;
import com.isis.service.PatientService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PatientTest {
    
    static EntityManagerFactory fact;
    
    public PatientTest(){}
    
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
        PatientService serv = new PatientService(DatabaseUtils.fact());
        serv.removeAll();
        List<Patient> res = serv.getAll();
        assert(res.isEmpty());
    }
    
        
    @Test
    public void patient() {
//        clean();
        PatientService serv = new PatientService(DatabaseUtils.fact());
        Patient cr = serv.newPatient("FROMENTIN", "Axel");
        assertNotNull(cr);
        cr = serv.newPatient("GUILLEMANT", "Chloe");
        assertNotNull(cr);
        cr = serv.newPatient("GARCIA GOZALVEZ", "Pau");
        assertNotNull(cr);
        List<Patient> res = serv.getAll();
        assert(!res.isEmpty());
        assert(res.size() == 3);
        
        
    }
}
    
