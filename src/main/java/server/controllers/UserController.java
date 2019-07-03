package server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class UserController {

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public void enter() {
        System.out.println("I am on server!!!!");
    }
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public void help2(){
        System.out.println("help!!!!");
    }

}
