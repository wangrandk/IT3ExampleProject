package rest;

import java.sql.*;

public class MySQLDB {

    public static void main(String[] args) {
      /*  try{
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","ran","0119");
            Connection con = MySQLDB.getConnection();
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
        }*/
    }

    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","ran","0119");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
