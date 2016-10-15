package pl.giantscastle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    
	@RequestMapping(value ="/")
    public String helloWorld(Model model) {
        model.addAttribute("msg", "Polskie znaki ąęć!");
        return "HelloWorld"; //nazwa jsp'a
    }
}
