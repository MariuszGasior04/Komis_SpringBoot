/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.komis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.altkom.komis.entity.Client;
import pl.altkom.komis.repository.ClientRepository;

/**
 *
 * @author mgasior
 */
@Controller
public class ClientController {

    @Autowired
    private final ClientRepository repo;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.repo = clientRepository;
    }

    @RequestMapping("/")
    public String ViewHomePage(Model model) {
        List<Client> listClient = repo.findAll();
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
        repo.save(client);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditClientPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_client");
        Client client = repo.findById(id).get();
        mav.addObject("client", client);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
