package Resources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcconnection1 {
  // to fetch credentials from database SQL server
	public String[] database() throws SQLException
	{
		// TODO Auto-generated method stub
		String[] data=new String[2];
        String host="localhost";
        String port="3306";
        Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Seleniumdb", "root" , "chetan94");
  	    Statement s=con.createStatement();
	    ResultSet rs=s.executeQuery("select * from Credentials where Id=1 ");
	    while(rs.next())
	    {
	    data[0]=rs.getString("Username");
	    data[1]=rs.getString("Password");
	    
	    
	    }
	    return data;
	}

}
