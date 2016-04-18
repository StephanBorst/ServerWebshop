package webshop.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String processSubmit(@Valid Bestelling bestelling, BindingResult result, Model model, String name, int age, String destination) {
		if (result.hasErrors()) {
			return "bestel";
		}
		
		Bestelling bestellingobject = DataAccesObject.create(name, age, destination);
		String message = "Form submitted successfully!" + bestellingobject;
		
		model.addAttribute("message", message);
		return "bestel";
	}

}
