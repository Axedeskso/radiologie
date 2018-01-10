package com.isis.controller;

import com.isis.configuration.DatabaseUtils;
import com.isis.model.Acte;
import com.isis.model.Ccam;
import com.isis.model.Image;
import com.isis.model.Modalite;
import com.isis.model.Patient;
import com.isis.model.Venue;
import com.isis.service.ActeService;
import com.isis.service.CcamService;
import com.isis.service.ImageService;
import com.isis.service.ModaliteService;
import com.isis.service.PatientService;
import com.isis.service.VenueService;
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
    VenueService venueService;
    ModaliteService modaliteService;
    CcamService ccamService;
    ImageService imageService;

    public RestController() {
        acteService = new ActeService(DatabaseUtils.fact());
        patientService = new PatientService(DatabaseUtils.fact());
        venueService = new VenueService(DatabaseUtils.fact());
        modaliteService = new ModaliteService(DatabaseUtils.fact());
        ccamService = new CcamService(DatabaseUtils.fact());
        imageService = new ImageService(DatabaseUtils.fact());
    }


    //PATIENTS
    @GET
    @Path("patients")
    @Produces("application/json")
    public List<Patient> getAllPatient() {
        return patientService.getAll();
    }
    
    //PATIENT
    @GET
    @Path("patients/{ipp}")
    @Produces("application/json")
    public Patient getPatient(@PathParam("ipp") int ipp) {
        return patientService.getByIPP(ipp);
    }
    
    @GET
    @Path("venues")
    @Produces("application/json")
    public List<Venue> getAllVenues() {
        return venueService.getAll();
    }
    
    @GET
    @Path("patients/{ipp}/venues")
    @Produces("application/json")
    public List<Venue> getVenues(@PathParam("ipp") int ipp) {
        Patient p = new Patient();
        p.setIpp(ipp);
        return venueService.getByPatient(p);
    }
    
    @GET
    @Path("patients/{ipp}/venues/{iep}")
    @Produces("application/json")
    public Venue getVenuesByIEP(@PathParam("ipp") int ipp, @PathParam("iep") int iep) {
        return venueService.getByIEP(iep);
    }
    
    @GET
    @Path("actes")
    @Produces("application/json")
    public List<Acte> getAllActes() {
        return acteService.getAll();
    }
    
    @GET
    @Path("patients/{ipp}/venues/{iep}/actes")
    @Produces("application/json")
    public List<Acte> getPatientActes(@PathParam("ipp") int ipp, @PathParam("iep") int iep) {
        Venue v = new Venue();
        v.setIep(iep);
        return acteService.getByVenue(v);
    }
    
    @GET
    @Path("patients/{ipp}/{iep}/actes/{id}")
    @Produces("application/json")
    public Acte getActeById(@PathParam("ipp") int ipp, @PathParam("iep") int iep, @PathParam("id") int id) {
        return acteService.getById(id);
    }
    
    @GET
    @Path("patients/{ipp}/{iep}/actes/{id}/images")
    @Produces("application/json")
    public List<Image> getImagesByActe(@PathParam("id") int id) {
        return imageService.getAll();
    }
    
    
    
    @DELETE
    @Path("patients/{ipp}/{iep}/actes/{id}")
    public Response removeActe(@PathParam("iep") int iep, @PathParam("id") int id){
        acteService.removeActe(id);
        return Response.status(200).build();
    }
    
    @GET
    @Path("ccam")
    @Produces("application/json")
    public List<Ccam> getAllCCAM() {
        return ccamService.getAll();
    }
    @POST
    @Path("ccam")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public void newCCAM(Ccam c) {
        ccamService.newCcam(c);
    }
    
    @POST
    @Path("ccam/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editCcam(Ccam c) {
        ccamService.updateCcam(c);
        return Response.status(200).entity(c).build();
    }
    
    @DELETE
    @Path("ccam/{id}")
    public Response removeCCAM(@PathParam("id") int id){
        ccamService.removeCcam(id);
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
    public Modalite newModalite(Modalite m) {
        modaliteService.newModalite(m);
        return m;
    }
    
    @POST
    @Path("modalites/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editModalite(Modalite m) {
        modaliteService.updateModalite(m);
        return Response.status(200).entity(m).build();
    }
    
    @DELETE
    @Path("modalites/{id}")
    public Response removeModalite(@PathParam("id") int id){
        modaliteService.remove(id);
        return Response.status(200).build();
    }
}
