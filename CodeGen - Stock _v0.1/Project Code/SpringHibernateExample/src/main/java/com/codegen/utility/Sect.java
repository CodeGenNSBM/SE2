/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.utility;

/**
 *
 * @author Ruvin
 */
public class Sect {
    private String name;
    private double prcnt;

    public Sect(String name, double prcnt) {
        this.name = name;
        this.prcnt = prcnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrcnt() {
        return prcnt;
    }

    public void setPrcnt(double prcnt) {
        this.prcnt = prcnt;
    }
    
    
}
