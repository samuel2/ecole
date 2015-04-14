/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.ecole.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


/**
 *
 * @author samuel < smlfolong@gmail.com >
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Version
    protected Long version;

    public AbstractEntity() {
    }

    public AbstractEntity(Long id, Long version) {
        this.id = id;
        this.version = version;
    }
    
    
    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    public AbstractEntity build(Long id, Long version) {

        this.id = id;
        this.version = version;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        String class1 = this.getClass().getName();
        String class2 = obj.getClass().getName();

        if (!class2.equals(class1)) {
            return false;
        }

        AbstractEntity other = (AbstractEntity) obj;
        return this.id == other.id;
    }

}
