package pl.giantscastle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	enum SubPage { index, about, rules, authors}
	
	@RequestMapping(value ="/")
	public String index(Model model, HttpServletRequest request, HttpServletResponse response){
		return main("index", model, request, response);
	}
	
	@RequestMapping(value ="/{subSite}")
    public String main(@PathVariable("subSite") String subSite, Model model, HttpServletRequest request, HttpServletResponse response) {
		SubPage subPage;
		try {
			subPage = SubPage.valueOf(subSite);
		} catch (IllegalArgumentException e) {
			System.out.println("Not available access to /" + subSite); //ToDo Zmienic na Log4J
			subPage = SubPage.index;
		}
		request.setAttribute("subPage", subPage+".jsp");
        return "main"; 
    }
}
