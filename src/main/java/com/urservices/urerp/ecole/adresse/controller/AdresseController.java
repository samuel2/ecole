/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.ecole.adresse.controller;

import com.urservices.urerp.ecole.adresse.entity.Adresse;
import com.urservices.urerp.ecole.adresse.service.IServiceAdresse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author samuel
 */
@Controller
@RequestMapping("adresse")
public class AdresseController {
    
    @Autowired
    private IServiceAdresse iServiceAdresse;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexAction(Model model) {
        List<Adresse> adresses = iServiceAdresse.getAllAdresses();
        model.addAttribute("adresses", adresses);
        return "adresse/index";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAction(ModelMap model) {
        Adresse adresse = new Adresse();
        model.addAttribute("adresse", adresse);
        return "adresse/new";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAction(@Valid Adresse adresse,
            BindingResult bindingResult, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            return "adresse/new";
        }else {
            adresse = iServiceAdresse.save(adresse);
            return "redirect:/adresse/" + adresse.getId() + "/show";
        }
    }
    
    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String showAction(@PathVariable Long id, Model model) {
        Adresse adresse = iServiceAdresse.findById(id);
        model.addAttribute("adresse", adresse);
        return "adresse/show";
    }
    
    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String showEdit(@PathVariable Long id, Model model) {
        Adresse adresse = iServiceAdresse.findById(id);
        model.addAttribute("adresse", adresse);
        return "adresse/edit";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAction(Adresse adresse,
            BindingResult bindingResult, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            return "adresse/edit";
        } else {
            Adresse adresseTmp = iServiceAdresse.findById(adresse.getId());
            adresseTmp = adresse;
            adresse = iServiceAdresse.save(adresseTmp);
            return "redirect:/adresse/" + adresse.getId() + "/show";
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAction(Adresse adresse,
            BindingResult bindingResult, SessionStatus sessionStatus) {
        iServiceAdresse.delete(adresse);
        return "redirect:/adresse";
    }
}
