package nl.zwolle.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("Bestelling")
public class SimpleController {

	
	
	@RequestMapping("/bestelling")
	public String simple1(Model model) {
		return "bestelling";
	}
	
	@ModelAttribute("Bestelling")
	public Bestelling createFormBean() {
		return new Bestelling();
	}
	

	@RequestMapping(value="/bestelling", method=RequestMethod.POST)
	public String nieuweBestelling(String name, int age, @Valid Bestelling bestelling, BindingResult result, Model model) {
	String message;
	if (result.hasErrors()){
		message="Form contains errors";
		model.addAttribute("message", message);
	return null;
	}
	message = "Form submitted successfully";
	model.addAttribute("message", message);
	DataAccesObject.create(name, age);
	return "redirect:/bestelling";
	}

	@RequestMapping("/overzicht")
	public String overzicht(Model model) {
		model.addAttribute("JavaBeans", DataAccesObject.all());
		return "overzicht";
	}

	
	
	@RequestMapping(value="/bestelling/{id}")
	public String detailView(@PathVariable String id, Model model){
		Long key;
		try{
			key = Long.valueOf(id);
		}
		catch(NumberFormatException e){
			// id is geen getal? error 404
			return null;
		}
		Bestelling bean = DataAccesObject.find(key);
		if(bean == null){
			// geen rit met gegeven id? error 404
			return null;
		} else {
			model.addAttribute("bestelling", bean);
			return "detail";
		}
	}
	
	
}
