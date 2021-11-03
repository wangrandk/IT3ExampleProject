package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("patients")
public class PatientService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getGiraffes() {
        return GiraffeDao.getInstance().getGiraffes();
    }
    @GET
    @Path("{cpr}")
    public Patient getPatient(@PathParam("cpr") String cpr){

        return null;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Patient postPatient(Patient p) {
        GiraffeDao.getInstance().getGiraffes().add(p);
        return p;
    }

}
