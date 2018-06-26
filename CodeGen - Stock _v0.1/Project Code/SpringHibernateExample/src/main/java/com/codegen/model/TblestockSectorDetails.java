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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Vishwa
 */
@Entity
@Table(name = "tblestock_sector_details")
public class TblestockSectorDetails implements Serializable{
    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sectorId_fk")
    private int sectorId_fk;
    
    @Column(name = "stockID_fk")
    private int stockID_fk;
    
    @Column(name = "currentRate")
    private double currentRate;
    
    @Column(name = "stockAmount")
    private int stockAmount;

    @ManyToOne
	@JoinColumn(name = "user_fk")
    private Tbluser user;
	public Tbluser getCategory() {
		return user;
	}

    /*public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

    public int getId() {
        return id;
    }

    public int getSectorId_fk() {
        return sectorId_fk;
    }

    public int getStockID_fk() {
        return stockID_fk;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSectorId_fk(int sectorId_fk) {
        this.sectorId_fk = sectorId_fk;
    }

    public void setStockID_fk(int stockID_fk) {
        this.stockID_fk = stockID_fk;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    public void setStockAmount(int sttockAmount) {
        this.stockAmount = sttockAmount;
    }
    
    
    
    
}
