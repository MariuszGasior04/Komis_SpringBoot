/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.altkom.service.PersonService;

/**
 *
 * @author mgasior
 */
@Controller
public class KomisController {
    @Autowired
    private PersonService ps;
    
    @RequestMapping("/")
    public String ViewHomePage(){
        return "index";
    }
    
}
