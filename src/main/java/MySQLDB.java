import java.sql.*;

public class MySQLDB {

    public static void main(String[] args) {

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","ran","0119");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select top 10 * from country");
            while(rs.next())
            {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println("----------------------");
            }

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}