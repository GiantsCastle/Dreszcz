package pl.giantscastle.main;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String helloWorld(Model model) {
        model.addAttribute("msg", "Polskie znaki ąęć!");
        return "HelloWorld"; //nazwa jsp'a
    }
}
