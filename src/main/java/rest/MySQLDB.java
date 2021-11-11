package rest;

import java.sql.*;

public class MySQLDB {

    public static void main(String[] args) {

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","ran","0119");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM hospital.patient");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" " + rs.getString(2));

                System.out.println("----------------------");

            }

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
