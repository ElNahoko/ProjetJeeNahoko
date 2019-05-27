package ma.mvc.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.util.DBConnection;

import ma.mvc.Model.Evenement;
import ma.mvc.Model.RendezVousBeans;

public class Evenementdao {

	
	public boolean AddEven(Evenement E) throws SQLException {
		
		String InsertQuery = "INSERT INTO `evenement`(`Evenement`) VALUES (?)";
		boolean LigneInserer = false ;
		PreparedStatement Query1 = DBConnection.createConnection().prepareStatement(InsertQuery);
		Query1.setString(1,E.getEve());


		LigneInserer = Query1.executeUpdate() > 0 ;
		
		return LigneInserer ;
	}
	
public List<Evenement> ShowEvenement() throws SQLException{
		
		ArrayList<Evenement> R = new ArrayList<Evenement>();
		String SelectQuery = "SELECT * FROM evenement";
		Statement Query3 = DBConnection.createConnection().createStatement();
		ResultSet RS = Query3.executeQuery(SelectQuery);
		while (RS.next()) {
			int id = RS.getInt("id_e");
            String Event = RS.getString("Evenement");
             
            Evenement RVB= new Evenement(id,Event);
            R.add(RVB);
        }
		
		Query3.close();
		RS.close();

		return R ;
	}
	
}
