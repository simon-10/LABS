package edu.mum.cs.cs425.demos.elibrary_springsec_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryServicesController {

    @GetMapping(value = {"/secured/services","/eregistrar/secured/services"})
    public String services() {
        return "secured/services";
    }

    @GetMapping(value = {"/secured/services/admin/usrmgmt/list","/eregistrar/secured/services/admin/usrmgmt/list"})
    public String usrmgmtList() {
        return "secured/services/admin/usrmgmt/list";
    }

}
