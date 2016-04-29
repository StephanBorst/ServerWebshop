package webshop.form;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	public void showStock(Model model) {
		Product p1 = ProductDAO.find((long) 1);
		int stock1 = p1.getStock();
		Product p2 = ProductDAO.find((long) 2);
		int stock2 = p2.getStock();
		Product p3 = ProductDAO.find((long) 3);
		int stock3 = p3.getStock();
		Product p4 = ProductDAO.find((long) 4);
		int stock4 = p4.getStock();
		model.addAttribute("stock1", stock1);
		model.addAttribute("stock2", stock2);
		model.addAttribute("stock3", stock3);
		model.addAttribute("stock4", stock4);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		showStock(model);
		return "bestel";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("Bestelling") @Valid Bestelling bestelling, BindingResult result,
			Model model, String name, int age, String destination, String retour, Date date, Date retourdate, int seats,
			boolean member) {

		if (result.hasErrors()) {
			showStock(model);
			return "bestel";
		}
		
		if (retourdate.before(date)) {
			showStock(model);
			String message = "Retour date must be after Departure date!";
			model.addAttribute("message", message);
			return "bestel";
		}
	
		try {
			switch (destination) {
			case "Rivendel":
				Product p1 = ProductDAO.find((long) 1);
				p1.setStock(p1.getStock() - seats);
				ProductDAO.update(p1);
				break;
			case "Coruscant":
				Product p2 = ProductDAO.find((long) 2);
				p2.setStock(p2.getStock() - seats);
				ProductDAO.update(p2);
				break;
			case "Gotham":
				Product p3 = ProductDAO.find((long) 3);
				p3.setStock(p3.getStock() - seats);
				ProductDAO.update(p3);
				break;
			case "Wonderland":
				Product p4 = ProductDAO.find((long) 4);
				p4.setStock(p4.getStock() - seats);
				ProductDAO.update(p4);
				break;
			}
			
		} catch (Exception e) {
			String message = "Not enough seats available";
			model.addAttribute("message", message);
			showStock(model);
			return "bestel";
		}
		if (retour.equals("Retour")) {
			DataAccesObject.create(name, age, destination, retour, date, retourdate, seats, member);
		} else {
			DataAccesObject.create(name, age, destination, retour, date, null, seats, member);
		}
		return "redirect:/overview";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("d-MM-yy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
