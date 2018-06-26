/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Vishwa
 */
@Entity
@Table(name = "tblstock")
public class Tblstock implements Serializable{
   // private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "stockName")
    private String stockName;

    /*public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/
   
   /* @ManyToOne
    @JoinColumn(name = "sectorCode")
    
    private Tblsector sector;
	public Tblsector getCategory() {
		return sector;
	}
*/
    public int getId() {
        return id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    
    
    
}
