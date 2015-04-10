/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.ecole.adresse.service;

import com.google.common.collect.Lists;
import com.urservices.urerp.ecole.adresse.entity.Adresse;
import com.urservices.urerp.ecole.adresse.repository.AdresseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel < smlfolong@gmail.com >
 */
@Service("serviceAdresse")
public class ServiceAdresse implements IServiceAdresse{

    @Autowired
    AdresseRepository adresseRepository;
    
    public List<Adresse> getAllAdresses() {
        return Lists.newArrayList(adresseRepository.findAll());
    }

    public Adresse save(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    public Adresse findById(Long id) {
        return adresseRepository.findOne(id);
    }

    public void delete(Adresse adresse) {
        Adresse toDelete = adresseRepository.findOne(adresse.getId());
        adresseRepository.delete(toDelete);
    }

    public Adresse update(Adresse adresse) {
        return adresseRepository.save(adresse);
    }
    
}
