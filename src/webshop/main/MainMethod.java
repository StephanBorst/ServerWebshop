package webshop.main;

import org.springframework.web.client.RestTemplate;


public class MainMethod {

	public static void main(String[] args) {
		
		Product product1 = ProductDAO.create("Coruscant", 500);
		Product product2 = ProductDAO.create("Gotham", 300);
		Product product3 = ProductDAO.create("Rivendel", 30);
		
		
		
		RestTemplate rest = new RestTemplate();
		Bestelling a = rest.getForObject("http://10.2.22.62:8080/webshop/api/bestellingen/1", Bestelling.class);
		System.out.println(a);
		
		
	}

}
