package pl.giantscastle.main;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
