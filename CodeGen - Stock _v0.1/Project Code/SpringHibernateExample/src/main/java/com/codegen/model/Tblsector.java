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
import javax.persistence.FetchType;
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
@Table(name = "tblsector")
public class Tblsector implements Serializable{
    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sectorId;

    @Column(name = "sectorName")
    private String sectorName;
    
   
/*
    @OneToMany(fetch = FetchType.EAGER, mappedBy =  "sector",cascade = CascadeType.ALL)  
    private Set<Tblstock> stocks;
	public Set<Tblstock> getProducts() {
		return stocks;
	}

    /*public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

    public int getSectorId() {
        return sectorId;
    }

   

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
    
    
    
}
