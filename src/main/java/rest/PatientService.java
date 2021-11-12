package rest;

import com.google.gson.Gson;

import javax.script.ScriptContext;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.PrintWriter;
import java.util.List;


@Path("patients")
public class PatientService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    //@Consumes({MediaType.APPLICATION_JSON})
    //public List<Patient> getGiraffes() {
    //    return PatientDao.getInstance().getGiraffes();
    //}
    public List<Patient> getPatient() {
        return PatientDao.getInstance().getPatient();
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
    }
*/
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Patient postPatient(Patient p) {
        System.out.println("paitent " + p);
        PatientDao.getInstance().getPatient().add(p);
        PatientDao.getInstance().savePatient(p);
        System.out.println("Successfully added paitent: " + p);
        return p;
    }


}
