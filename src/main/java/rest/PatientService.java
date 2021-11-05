package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("patients")
public class PatientService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getGiraffes() {
        return PatientDao.getInstance().getGiraffes();
    }

    @GET
    @Path("{cpr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatient(@PathParam("cpr") String cpr){
        return PatientDao.getInstance().getPatientBycpr(cpr);

    }

    @DELETE
    @Path("{cpr}")
    public void  deletePatient(@PathParam("cpr") String cpr){
         PatientDao.getInstance().deletePatientByCpr(cpr);
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPatient(Patient p){
        return Response.status(400).entity("message").build();
    }*/


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Patient postPatient(Patient p) {
        PatientDao.getInstance().getGiraffes().add(p);
        return p;
    }

}
