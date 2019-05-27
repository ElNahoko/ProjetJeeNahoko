package ma.mvc.Model;

import java.util.ArrayList;
import java.util.List;

public class Modele {
	public Modele(){}

	List<RendezVousBeans> RDV=new ArrayList<>();

	public List<RendezVousBeans> getRDV() {
		return RDV;
	}

	public void setRDV(List<RendezVousBeans> rDV) {
		RDV = rDV;
	}
}
