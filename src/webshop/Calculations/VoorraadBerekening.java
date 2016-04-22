package webshop.Calculations;

public class VoorraadBerekening {
	
	private int voorraad1;
	
	private int voorraad2;
	
	private int voorraad3;
	
	public static int count = 0;
	
	public VoorraadBerekening() {
		this.voorraad1 = 500;
		this.voorraad2 = 300;
		this.voorraad3 = 30;
		
		count++;

	}
	
	public int getVoorraad1(String destination) {
		switch (destination) {
		case "Coruscant":
			return voorraad1;
			
		case "Gotham":
			return voorraad2;
			
		case "Rivendel":
			return voorraad3;
		
		default: return 0;
		}
		
	}

	public int haalUitVoorraad(String destination, int seats) {
		switch (destination) {
		case "Coruscant":
			return voorraad1 -= seats;
			
		case "Gotham":
			return voorraad2 -= seats;
			
		case "Rivendel":
			return voorraad3 -= seats;
			
		default: return 0;
		}
	}
	
}
