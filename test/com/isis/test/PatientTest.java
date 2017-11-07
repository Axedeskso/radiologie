package com.isis.test;


import com.isis.configuration.DatabaseUtils;
import com.isis.model.Acte;
import com.isis.model.Patient;
import com.isis.service.ActeService;
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
        ActeService serv = new ActeService(DatabaseUtils.fact());
        serv.removeAll();
        List<Acte> res = serv.getAll();
        assert(res.isEmpty());
    }
    
        
    @Test
    public void patient() {
        clean();
        PatientService serv = new PatientService(DatabaseUtils.fact());
        Patient cr = serv.newPatient("Axel", "A", "123456", "987654");
        assertNotNull(cr); 
        List<Patient> res = serv.getAll();
        assert(!res.isEmpty());
        assert(res.size() == 1);
        
        Patient r = serv.getByIEP("987654");
        
        assert(r!= null && r.getIep().equals("987654"));
        
      
    }
}
    
