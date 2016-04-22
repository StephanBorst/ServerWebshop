package webshop.form;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import webshop.main.Bestelling;
import webshop.main.DataAccesObject;


@RestController
@RequestMapping("/api/bestellingen")
public class ControllerRest {

	@RequestMapping(method = RequestMethod.GET)
	public List<Bestelling> ritten() {
		return DataAccesObject.all();
	}

	/* Werkt niet moet met Ajax
	@RequestMapping(method = RequestMethod.POST)
	public Bestelling create(Bestelling b) {
		System.out.println("Deze functie wordt succesvol aangeroepen");
		Bestelling newb = DataAccesObject.create(b.getName(), b.getAge(),
				b.getDestination());
		return newb;
	}
	*/
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Bestelling bestel(@PathVariable String id){
		Long key;
		try{
			key = Long.valueOf(id);
		}
		catch(NumberFormatException e){
			// id is geen getal? error 404
			return null;
		}
		Bestelling b = DataAccesObject.find(key);
		if(b == null){
			// geen rit met gegeven id? error 404
			return null;
		} 
		return b;
	}
}
