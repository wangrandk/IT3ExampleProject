package rest;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PatientDao {
    private List<Patient> patients = new ArrayList<>();
    private static PatientDao instance = new PatientDao();

    private PatientDao(){
        Patient p = new Patient();
        /*
        Patient melman = new Patient();
        melman.setName("melman");
        melman.setCpr("20200101");
        patients.add(melman);
        */
    }

    public static PatientDao getInstance(){
        return instance;
    }

    public List<Patient> getPatient() {
        return patients;
    }

    public Patient getPatientBycpr(String cpr) {
        return patients.stream().filter(c-> Objects.equals(c.Cpr, cpr)).findFirst().orElse(null);
    }

    public void deletePatientByCpr (String cpr){
        patients.removeIf(c -> Objects.equals(c.Cpr ,cpr));
    }

    public void savePatient(Patient p) {
        try {
            // Initialize the database
            Connection con = MySQLDB.getConnection();
            System.out.println(con);

            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            PreparedStatement st = con.prepareStatement("insert into hospital.patient  values(?, ?)");

            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer

            st.setString(2,   p.getName());

            // Same for second parameter
            st.setString(1,   p.getCpr());

            // Execute the insert command using executeUpdate()
            // to make changes in database
            st.executeUpdate();

            // Close all the connections
            st.close();
            con.close();

            // Get a writer pointer
            // to display the successful result
           // PrintWriter out = response.getWriter();
            //out.println("<html><body><b>Successfully Inserted"
              //      + "</b></body></html>");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
