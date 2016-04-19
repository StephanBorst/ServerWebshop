package webshop.form;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import webshop.main.Bestelling;
import webshop.main.DataAccesObject;

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

	
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("Bestelling") @Valid Bestelling bestelling, BindingResult result, Model model, String name, int age, String destination, String retour) {
		if (result.hasErrors()) {
			System.out.println("form has errors");
			return "bestel";
		}
		
		Bestelling bestellingobject = DataAccesObject.create(name, age, destination, retour);
		String message = "Form submitted successfully!" + bestellingobject;
		
		model.addAttribute("message", message);
		return "bestel";
	}
	 
}
