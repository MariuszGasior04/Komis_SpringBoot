/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.altkom.entity.Client;
import pl.altkom.repository.impl.ClientRepositoryImpl;

/**
 *
 * @author mgasior
 */
@Controller
public class ClientController {

    @Autowired
    private ClientRepositoryImpl service;

    @RequestMapping("/")
    public String ViewHomePage(Model model) {
        List<Client> listClient = service.listAll();
        model.addAttribute("listClient", listClient);
        return "index";
    }

    @GetMapping("/new")
    public String showAddNewClientPage(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);

        return "new_client";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("client") Client client) {
        service.save(client);

        return "redirect:/";
    }
}
