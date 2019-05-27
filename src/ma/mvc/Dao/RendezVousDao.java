package ma.mvc.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mvc.util.DBConnection;

import ma.mvc.Model.RendezVousBeans;


public class RendezVousDao {
	
	
	public int CheckRDv(RendezVousBeans RT) throws SQLException 
	{
		int RdvExist = 0;
		String Heure = RT.getHeure();
		String Date  = RT.getDate();
	
		Statement ST = DBConnection.createConnection().createStatement();
		String VerifierQuery = "SELECT count(*) FROM rdv WHERE Date = '"+ Date+"' and Heure = '"+Heure+"'";
		ResultSet RS = ST.executeQuery(VerifierQuery);
		while(RS.next()) {
			RdvExist = RS.getInt(1);
		}
		return RdvExist;
	}
	public boolean AddRdv(RendezVousBeans R) throws SQLException {
		
		String InsertQuery = "INSERT INTO `rdv`(`Nom`, `Prenom`, `Date`, `Heure`, `Motif`, `Telephone`) VALUES (?,?,?,?,?,?)";
		boolean LigneInserer = false ;
		PreparedStatement Query1 = DBConnection.createConnection().prepareStatement(InsertQuery);
		Query1.setString(1, R.getNom());
		Query1.setString(2, R.getPrenom());
		Query1.setString(3, R.getDate());
		Query1.setString(4, R.getHeure());
		Query1.setString(5, R.getMotif());
		Query1.setString(6, R.getNumeroTelephone());

		LigneInserer = Query1.executeUpdate() > 0 ;
		
		return LigneInserer ;
	}
	
	
	public List<RendezVousBeans> ShowRDV() throws SQLException{
		
		ArrayList<RendezVousBeans> R = new ArrayList<RendezVousBeans>();
		String SelectQuery = "SELECT * FROM rdv";
		Statement Query3 = DBConnection.createConnection().createStatement();
		ResultSet RS = Query3.executeQuery(SelectQuery);
		while (RS.next()) {
			int id = RS.getInt("id");
            String Nom = RS.getString("Nom");
            String Prenom = RS.getString("Prenom");
            String Date = RS.getString("Date");
            String Heure = RS.getString("Heure");
            String Motif = RS.getString("Motif");
            String NumeroT = RS.getString("Telephone");
             
            RendezVousBeans RVB= new RendezVousBeans(id,Nom,Prenom,Date,Heure,Motif,NumeroT);
            R.add(RVB);
        }
		
		Query3.close();
		RS.close();

		return R ;
	}
	
	
	public void Supprimer(RendezVousBeans R) {
		try {
			String sql = "DELETE FROM rdv WHERE id = ?";
			PreparedStatement preparedStatement = DBConnection.createConnection().prepareStatement(sql);
			preparedStatement.setInt(1, R.getId_Rdv());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("Delete Succefull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Modifier(RendezVousBeans R) {
		try {
			String sql = "UPDATE rdv SET Nom = ?, Prenom = ? , Date = ? , Heure = ? , Motif = ? , Telephone = ? WHERE ID = ?";
			PreparedStatement preparedStatement = DBConnection.createConnection().prepareStatement(sql);
			preparedStatement.setString(1, R.getNom());
			preparedStatement.setString(2, R.getPrenom());
			preparedStatement.setString(3, R.getDate());
			preparedStatement.setString(4, R.getHeure());
			preparedStatement.setString(5, R.getMotif());
			preparedStatement.setString(6, R.getNumeroTelephone());
			preparedStatement.setInt(7, R.getId_Rdv());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("Update Succefull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public RendezVousBeans Chercher(int id) {
		RendezVousBeans rdv = new RendezVousBeans();
		try {
			String query = "SELECT * FROM rdv WHERE ID = ? ";
			PreparedStatement preparedStatement = DBConnection.createConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				rdv.setId_Rdv(Integer.parseInt(resultSet.getString("id")));
				rdv.setNom(resultSet.getString("Nom"));
				rdv.setPrenom(resultSet.getString("Prenom"));
				rdv.setHeure(resultSet.getString("Date"));
				rdv.setDate(resultSet.getString("Heure"));
				rdv.setMotif(resultSet.getString("Motif"));
				rdv.setNumeroTelephone(resultSet.getString("Telephone"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rdv;
	}
	
	}


