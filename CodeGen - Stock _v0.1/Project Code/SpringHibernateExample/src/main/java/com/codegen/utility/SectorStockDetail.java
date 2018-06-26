/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.utility;

/**
 *
 * @author Ayesh
 */


public class SectorStockDetail {
    
    private String sectorName;
    private String stockName;
    private Double currentRate;
    
    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(Double currentRate) {
        this.currentRate = currentRate;
    }
    
     public SectorStockDetail(String sectorName, String stockName, Double currentRate) {
        this.sectorName = sectorName;
        this.stockName = stockName;
        this.currentRate = currentRate;
    }
}
