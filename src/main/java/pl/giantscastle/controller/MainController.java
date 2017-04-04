package pl.giantscastle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.giantscastle.service.UserService;

@Controller
public class MainController {	
	
	@Autowired
	UserService user;
	
	@RequestMapping(value ="/")
	public String showIndex(ModelMap model){
		return "index";
	}
	
	@RequestMapping(value ="/login")
	public String showLoginForm(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String logInAndShowGame(ModelMap model){
		return "redirect:/game";
	}
	
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String showGame(ModelMap model) {
		model.put("id", user.getUserID());
		return "game";
	}
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public String showAuthors(ModelMap model) {
		return "authors";
	}
	
	@RequestMapping(value = "/rules", method = RequestMethod.GET)
	public String showRules(ModelMap model) {
		return "rules";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistration(ModelMap model) {
		return "registration";
	}
	
	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	

}
