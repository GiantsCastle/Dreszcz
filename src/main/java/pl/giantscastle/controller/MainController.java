package pl.giantscastle.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {	
	
	@RequestMapping(value ="/")
	public String showIndex(){
		return "index";
	}
	
	@RequestMapping(value ="/login")
	public String showLoginForm(){
		return "login";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String logInAndShowGame(){
		return "redirect:/game";
	}
	
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String showGame() {
		return "game";
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
