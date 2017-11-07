package com.isis.controller;

import com.isis.configuration.DatabaseUtils;
import com.isis.model.Acte;
import com.isis.model.Modalite;
import com.isis.model.Patient;
import com.isis.service.ActeService;
import com.isis.service.ModaliteService;
import com.isis.service.PatientService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("")
public class RestController {

    @Context
    private UriInfo context;

    ActeService acteService;
    PatientService patientService;
    ModaliteService modaliteService;

    public RestController() {
        acteService = new ActeService(DatabaseUtils.fact());
        patientService = new PatientService(DatabaseUtils.fact());
        modaliteService = new ModaliteService(DatabaseUtils.fact());
    }

//    @GET
//    @Path("actes")
//    @Produces("application/json")
//    public List<Acte> getAllActe(@DefaultValue("") @QueryParam("iep") int adm) {
//        return acteService.getAll();
//    }
//
//    @GET
//    @Path("actes/{id}")
//    @Produces("application/json")
//    public Acte getActe(@PathParam("id") int id) {
//        return acteService.getById(id);
//    }
//
//    @POST
//    @Path("actes")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces("application/json")
//    public void newActe(Acte a) {
//        acteService.newActe(a);
//    }
//
//    @POST
//    @Path("modalites")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces("application/json")
//    public void newModalite(Modalite a) {
//        modaliteService.newModalite(a);
//    }

    @GET
    @Path("patients/{iep}")
    @Produces("application/json")
    public Patient getPatient(@PathParam("iep") int iep) {
        return patientService.getByIEP(iep);
    }

    @GET
    @Path("patients")
    @Produces("application/json")
    public List<Patient> getAllPatient() {
        return patientService.getAll();
    }

    @GET
    @Path("")
    @Produces("application/json")
    public String getHello() {
        return "coucou";
    }
    
}
