package ma.mvc.Model;
public class RendezVousBeans {
	int Id_Rdv;
	String Nom,Prenom,Date,Heure,Motif,NumeroTelephone;
	public int getId_Rdv() {
		return Id_Rdv;
	}
	public String getNom() {
		return Nom;
	}

	public void setId_Rdv(int id_Rdv) {
		Id_Rdv = id_Rdv;
	}

	public RendezVousBeans(int id_Rdv) {
		super();
		Id_Rdv = id_Rdv;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getHeure() {
		return Heure;
	}
	public void setHeure(String heure) {
		Heure = heure;
	}
	public String getMotif() {
		return Motif;
	}
	public void setMotif(String motif) {
		Motif = motif;
	}
	public String getNumeroTelephone() {
		return NumeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		NumeroTelephone = numeroTelephone;
	}
	public RendezVousBeans(int id_Rdv, String nom, String prenom, String date, String heure, String motif,
			String numeroTelephone) {
		super();
		Id_Rdv = id_Rdv;
		Nom = nom;
		Prenom = prenom;
		Date = date;
		Heure = heure;
		Motif = motif;
		NumeroTelephone = numeroTelephone;
	}
	public RendezVousBeans(String nom, String prenom, String date, String heure, String motif, String numeroTelephone) {
		super();
		Nom = nom;
		Prenom = prenom;
		Date = date;
		Heure = heure;
		Motif = motif;
		NumeroTelephone = numeroTelephone;
	}
	public RendezVousBeans() {
		super();
	}
	
	
	
}
