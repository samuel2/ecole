/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.ecole.config.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author samuel < smlfolong@gmail.com >
 */
//Indique le fichier de configuration
@Configuration
//Indique les packages ou il faut chercher les services et les entites du projet
@ComponentScan
@Import({PersistenceJPAConfig.class})
public class AppConfig {
    
}
