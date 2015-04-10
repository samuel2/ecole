/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.ecole.adresse.entity;

import com.urservices.urerp.ecole.entity.AbstractEntity;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author samuel
 */
@Entity
public class Adresse extends AbstractEntity{
    
    private static final long serialVersionUID = 789654152369874568L;
    
    @NotNull
    @Size(min = 9, max = 9)
    private String telephone;
    
    @NotNull
    @Email
    private String email;
    
    @NotNull
    private String boitePostal;

    public Adresse() {
    }

    /**
     * 
     * @param telephone
     * @param email
     * @param boitePostal 
     */
    public Adresse(String telephone, String email, String boitePostal) {
        this.telephone = telephone;
        this.email = email;
        this.boitePostal = boitePostal;
    }

    /**
     * 
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @return boitePostal
     */
    public String getBoitePostal() {
        return boitePostal;
    }

    /**
     * 
     * @param telephone 
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @param boitePostal 
     */
    public void setBoitePostal(String boitePostal) {
        this.boitePostal = boitePostal;
    }
}
