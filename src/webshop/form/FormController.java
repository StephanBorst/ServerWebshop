package webshop.form;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import webshop.main.Bestelling;
import webshop.main.DataAccesObject;
import webshop.main.Product;
import webshop.main.ProductDAO;

@Controller
@RequestMapping("/form")
@SessionAttributes("Bestelling")
public class FormController {

	@ModelAttribute("Bestelling")
	public Bestelling createFormBean() {
		return new Bestelling();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "bestel";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit( @ModelAttribute("Bestelling") @Valid Bestelling bestelling , BindingResult result, String name, int age, String destination, String retour, Date date, Date retourdate, int seats, boolean member) {
	
		if (result.hasErrors()) {
			System.out.println("form has errors");
			return "bestel";
		}
		Bestelling bestellingobject;
		
		if(retour.equals("Retour")){
		bestellingobject = DataAccesObject.create(name, age, destination, retour, date, retourdate, seats, member);
		}
		else{bestellingobject = DataAccesObject.create(name, age, destination, retour, date, null, seats, member);
		}
		
		switch (destination) {
		case "Coruscant":
			Product p1 = ProductDAO.find((long) 1);
			p1.setStock(p1.getStock()-seats);
			ProductDAO.update(p1);
			break;
			
		case "Gotham":
			Product p2 = ProductDAO.find((long) 2);
			p2.setStock(p2.getStock()-seats);
			ProductDAO.update(p2);
			break;
		case "Rivendel":
			Product p3 = ProductDAO.find((long) 3);
			p3.setStock(p3.getStock()-seats);
			ProductDAO.update(p3);
			break;
			
		default: assert false: "dit kan echt niet";
		break;
		}
				
		
		return "redirect:/overview";
	}
	 
}
