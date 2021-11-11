package rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PatientDao {
    private List<Patient> giraffes = new ArrayList<>();
    private static PatientDao instance = new PatientDao();

    private PatientDao(){
        /**/
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
        //return giraffes;
        Patient p = new Patient();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","ran","0119");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM hospital.patient");

            while(rs.next())
            {
                p.setName(rs.getString(1));
                p.setCpr(rs.getString(2));
                giraffes.add(p);
            }
            con.close();

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return giraffes;
    }


    public Patient getPatientBycpr(String cpr) {
        return giraffes.stream().filter(c-> Objects.equals(c.Cpr, cpr)).findFirst().orElse(null);
    }

    public void deletePatientByCpr (String cpr){
       giraffes.removeIf(c -> Objects.equals(c.Cpr ,cpr));
    }

}
