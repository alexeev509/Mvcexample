package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "/my")
public class SecondController {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String enter() {
        System.out.println("I am on server2!!!!");
        return "Hello";
    }
}
