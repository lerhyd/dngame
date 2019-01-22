package com.lerhyd.dngame.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView main(){
        return new ModelAndView("registration");
    }
}
