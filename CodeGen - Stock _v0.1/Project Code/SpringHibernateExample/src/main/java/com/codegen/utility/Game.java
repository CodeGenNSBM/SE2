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
public class Game {
    
    private String name;
    private int full;
    public String getName() {
        return name;
    }

    public  void setName(String name) {
        name = name;
    }

    public Game(String name) {
        this.name = name;
        
    } 

    public int getFull() {
        return full;
    }

    public void setFull(int full) {
        this.full = full;
    }
    
}
