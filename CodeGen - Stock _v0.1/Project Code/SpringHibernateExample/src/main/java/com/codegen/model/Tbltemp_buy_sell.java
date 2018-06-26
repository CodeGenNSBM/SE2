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
@Table(name = "tbltemp_buy_sell")
public class Tbltemp_buy_sell implements Serializable{
    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "userId_fk")
    private int userId_fk;
    
    @Column(name = "sectorID_fk")
    private int sectorID_fk;
    
    @Column(name = "stockID_fk")
    private int stockID_fk;
    
    @Column(name = "stockAmount")
    private int stockAmount;
    
    @Column(name = "isBuy")
    private int isBuy;

    /*
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

    public int getId() {
        return id;
    }

    public int getUserId_fk() {
        return userId_fk;
    }

    public int getSectorID_fk() {
        return sectorID_fk;
    }

    public int getStockID_fk() {
        return stockID_fk;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public int getIsBuy() {
        return isBuy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId_fk(int userId_fk) {
        this.userId_fk = userId_fk;
    }

    public void setSectorID_fk(int sectorID_fk) {
        this.sectorID_fk = sectorID_fk;
    }

    public void setStockID_fk(int stockID_fk) {
        this.stockID_fk = stockID_fk;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public void setIsBuy(int isBuy) {
        this.isBuy = isBuy;
    }
    
    
}
