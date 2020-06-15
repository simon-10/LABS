package edu.mum.cs.cs425.demos.elibrary_springsec_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/","/eregistrar","/public/home"})
    public String home0() {
        return "redirect:/eregistrar/public/home";
    }

    @GetMapping(value = {"/public/home","/eregistrar/public/home"})
    public String home1() {
        return "public/index";
    }

    @GetMapping(value = {"/public/about","/eregistrar/public/about"})
    public String about() {
        return "public/about";
    }

    @GetMapping(value = {"/public/virtualtour","/eregistrar/public/virtualtour"})
    public String virtualtour() {
        return "public/virtualtour";
    }

    @GetMapping(value = {"/secured/home","/eregistrar/secured/home"})
    public String home2() {
      return "secured/index";
    }

}
