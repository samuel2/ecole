/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.ecole.adresse.service;

import com.urservices.urerp.ecole.entity.Adresse;
import java.util.List;

/**
 *
 * @author samuel < smlfolong@gmail.com >
 */
public interface IServiceAdresse {
    
    public List<Adresse> getAllAdresses();
    
    public Adresse save(Adresse adresse);
    
    public Adresse findById(Long id);
    
    public void delete(Adresse adresse);
    
    public Adresse update(Adresse adresse);
    
}
