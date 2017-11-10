package com.isis.test;

import com.isis.configuration.DatabaseUtils;
import com.isis.model.Acte;
import com.isis.model.Patient;
import com.isis.model.Venue;
import com.isis.service.ActeService;
import com.isis.service.PatientService;
import com.isis.service.VenueService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VenueTest {
    
    static EntityManagerFactory fact;
    
    public VenueTest(){}
    
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
        VenueService serv = new VenueService(DatabaseUtils.fact());
        serv.removeAll();
        List<Venue> res = serv.getAll();
        assert(res.isEmpty());
    }
    
        
    @Test
    public void patient() {
        clean();
        VenueService serv = new VenueService(DatabaseUtils.fact());
        Patient p1 = new Patient("ZIDANE", "Zidane");
        Venue cr = serv.newVenue(p1);
        assertNotNull(cr);
        cr = serv.newVenue(p1);
        assertNotNull(cr);
        Patient p2 = new Patient("MBAPPE", "Killian");
        cr = serv.newVenue(p2);
        assertNotNull(cr);
        List<Venue> res = serv.getAll();
        assert(!res.isEmpty());
        assert(res.size() == 3);
    }
}
    
