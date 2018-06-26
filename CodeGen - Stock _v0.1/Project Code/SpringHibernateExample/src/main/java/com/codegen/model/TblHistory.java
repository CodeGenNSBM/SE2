/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vishwa
 */
@Entity
@Table(name = "tblhistory")
public class TblHistory implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   
    @Column(name = "sectorName")
    private String sectname;
    
    @Column(name = "stockName")
    private String stkname;
    
    @Column(name = "currentPrice")
    private double cprice;

    public int getId() {
        return id;
    }

    public String getSectname() {
        return sectname;
    }

    public String getStkname() {
        return stkname;
    }

    public double getCprice() {
        return cprice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSectname(String sectname) {
        this.sectname = sectname;
    }

    public void setStkname(String stkname) {
        this.stkname = stkname;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }
    
    
    
    
}
