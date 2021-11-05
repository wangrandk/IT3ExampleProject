package rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PatientDao {
    private List<Patient> giraffes = new ArrayList<>();
    private static PatientDao instance = new PatientDao();

    private PatientDao(){
        Patient melman = new Patient();
        Patient marius = new Patient();
        melman.setName("melman");
        melman.setCpr("20200101");
        marius.setName("marius");
        marius.setCpr("20210101");
        giraffes.add(melman);
        giraffes.add(marius);
    }

    public static PatientDao getInstance(){
        return instance;
    }


    public List<Patient> getGiraffes() {
        return giraffes;
    }

    public Patient getPatientBycpr(String cpr) {
        return giraffes.stream().filter(c-> Objects.equals(c.Cpr, cpr)).findFirst().orElse(null);
    }

    public void deletePatientByCpr (String cpr){
       giraffes.removeIf(c -> Objects.equals(c.Cpr ,cpr));
    }

}
