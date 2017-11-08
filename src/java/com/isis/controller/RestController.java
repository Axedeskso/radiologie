package com.isis.controller;

import com.isis.configuration.DatabaseUtils;
import com.isis.model.Acte;
import com.isis.model.CCAM;
import com.isis.model.Image;
import com.isis.model.Modalite;
import com.isis.model.Patient;
import com.isis.service.ActeService;
import com.isis.service.CCAMService;
import com.isis.service.ImageService;
import com.isis.service.ModaliteService;
import com.isis.service.PatientService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("")
public class RestController {

    @Context
    private UriInfo context;

    ActeService acteService;
    PatientService patientService;
    ModaliteService modaliteService;
    CCAMService ccamService;
    ImageService imageService;

    public RestController() {
        acteService = new ActeService(DatabaseUtils.fact());
        patientService = new PatientService(DatabaseUtils.fact());
        modaliteService = new ModaliteService(DatabaseUtils.fact());
        ccamService = new CCAMService(DatabaseUtils.fact());
        imageService = new ImageService(DatabaseUtils.fact());
    }


    //PATIENTS
    @GET
    @Path("patients")
    @Produces("application/json")
    public List<Patient> getAllPatient() {
        return patientService.getAll();
    }
    @POST
    @Path("patients")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public void newPatient(Patient p) {
        patientService.newPatient(p);
    }

    //PATIENT
    @GET
    @Path("patients/{iep}")
    @Produces("application/json")
    public Patient getPatient(@PathParam("iep") int iep) {
        return patientService.getByIEP(iep);
    }
    
    @DELETE
    @Path("patients/{iep}")
    public Response removePatient(@PathParam("iep") int iep){
//        patientService.
        return Response.status(200).build();
    }
    
    //ACTES DU PATIENT
    @GET
    @Path("patients/{iep}/actes")
    @Produces("application/json")
    public String getActesByIep(@PathParam("iep") int iep) {
        return "patientService.getByIEP(iep)";
    }
    
    @GET
    @Path("patients/{iep}/actes/{id}")
    @Produces("application/json")
    public List<Acte> getActeByIep(@PathParam("iep") int iep, @PathParam("id") int id) {
        return acteService.getByIEP(iep);
    }

    @DELETE
    @Path("patients/{iep}/actes/{id}")
    public Response removeActe(@PathParam("iep") int iep, @PathParam("id") int id){
        acteService.remove(id);
        return Response.status(200).build();
    }
    
    @GET
    @Path("patients/{iep}/actes/{id}/images")
    @Produces("application/json")
    public List<Image> getImages(@PathParam("iep") int iep, @PathParam("id") int id) {
        return null;
    }
    
    @GET
    @Path("ccam")
    @Produces("application/json")
    public List<CCAM> getAllCCAM() {
        return ccamService.getAll();
    }
    @POST
    @Path("ccam")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public void newCCAM(CCAM c) {
        ccamService.newCcam(c);
    }
    
    @DELETE
    @Path("ccam/{id}")
    public Response removeCCAM(@PathParam("id") int id){
        ccamService.remove(id);
        return Response.status(200).build();
    }
    
    //MODALITE
    @GET
    @Path("modalites")
    @Produces("application/json")
    public List<Modalite> getAllModalite() {
        return modaliteService.getAll();
    }
    
    @POST
    @Path("modalites")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public void newModalite(Modalite a) {
        modaliteService.newModalite(a);
    }
    
    @DELETE
    @Path("modalites/{id}")
    public Response removeModalite(@PathParam("id") int id){
        modaliteService.remove(id);
        return Response.status(200).build();
    }
}
