package webshop.Calculations;

public class PrijsBerekening {

	
	private int Totaalprijs;

	private int prijsPerEenheid;
	
	private int korting;

	
	public int getTotaalprijs() {
		return Totaalprijs;
	}

	public void setTotaalprijs(int prijsPerEenheid, int korting, int seats) {
		Totaalprijs = (prijsPerEenheid - korting) * seats;
	}

	public int getPrijsPerEenheid() {
		return prijsPerEenheid;
	}

	public void setPrijsPerEenheid(String destination, String retour) {
		switch (destination) {
		case "Coruscant":
			prijsPerEenheid = 1000;
			break;
		case "Gotham":
			prijsPerEenheid = 300;
			break;
		case "Rivendel":
			prijsPerEenheid = 800;
			break;
		case "Wonderland":
			prijsPerEenheid = 600;
			break;
		}
		if (retour.equals("Retour")) {
			prijsPerEenheid *= 2;
		}
	}

	public int getKorting() {
		return korting;
	}

	public void setKorting(boolean member, int prijsPerEenheid) {
		if(member == true){
			this.korting = prijsPerEenheid * 20/100;
		}
		else{
			korting = 0;
		}
	}



}