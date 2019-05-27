package ma.mvc.Model;

public class Evenement {
 private int id;
 private String Eve;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEve() {
	return Eve;
}
public void setEve(String eve) {
	Eve = eve;
}
public Evenement(int id, String eve) {
	super();
	this.id = id;
	Eve = eve;
}
public Evenement(String eve) {
	super();
	Eve = eve;
}
 

}
