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
	public String home() {
		return "home";
	}
	
	@RequestMapping("/overview")
	public String overview() {
		return "overzicht";
	}
	
	@ModelAttribute("Bestelling")
	public Bestelling createFormBean() {
		return new Bestelling();
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
