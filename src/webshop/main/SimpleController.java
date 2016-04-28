package webshop.main;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("Bestelling")
public class SimpleController {

	
	@RequestMapping("/")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		ProductDAO.create("Rivendel", 30);
		ProductDAO.create("Coruscant", 200);
		ProductDAO.create("Gotham", 100);
		ProductDAO.create("Wonderland", 50);
		return "redirect:/";
	}

	@ModelAttribute("Bestelling")
	public Bestelling createFormBean() {
		return new Bestelling();
	}
	
	
	@RequestMapping("/overview")
	public String overzicht(Model model) {
		model.addAttribute("Bestellingen", DataAccesObject.all());
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
	
	@RequestMapping(value="/delete/{id}")
	public String deleteView(@PathVariable String id){
		Long key;
		try{
			key = Long.valueOf(id);
		}
		catch(NumberFormatException e){
		return null;
		}

		DataAccesObject.remove(key);
		return "redirect:/overview";
	}
	
	@RequestMapping("/payment")
	public String pay(Model model) {
		return "pay";
	}
	
	
}
