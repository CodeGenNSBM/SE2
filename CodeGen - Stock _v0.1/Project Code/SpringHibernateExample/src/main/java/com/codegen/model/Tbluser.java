/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Vishwa
 */

@Entity
@Table(name = "tbluser")
public class Tbluser implements Serializable {
    
    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   

    @Column(name = "Name")
    private String name;
    
    @Column(name = "UserName")
    private String uname;
    
    @Column(name = "Password")
    private String password;
    
    /* @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<TblestockSectorDetails> stockDetails ;
	public Set<TblestockSectorDetails> getProducts() {
		return stockDetails;
	}

    /*public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUname() {
        return uname;
    }

    public String getPassword() {
        return password;
    }
    
    
    
}
