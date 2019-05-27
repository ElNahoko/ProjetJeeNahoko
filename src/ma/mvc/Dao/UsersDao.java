package ma.mvc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mvc.util.DBConnection;

import ma.mvc.Model.UsersBeans;

public class UsersDao {

public static boolean ValidateUser(UsersBeans U) {
		
		boolean Statu = false;
		
		try{

		String EM= U.getUsername();
	    String PASS= U.getPassword();
	    
	     Connection con = DBConnection.createConnection();
		 System.out.println("Printing connection object "+con);
		 PreparedStatement PS1 =con.prepareStatement("Select * from users where USERNAME=? and PASSWORD=?");
		 PS1.setString(1, EM);
		 PS1.setString(2, PASS);
		 ResultSet RS =PS1.executeQuery();
		 Statu = RS.next();

		}catch(Exception e) {
			 e.printStackTrace();
		}

		return Statu;
	}

}
