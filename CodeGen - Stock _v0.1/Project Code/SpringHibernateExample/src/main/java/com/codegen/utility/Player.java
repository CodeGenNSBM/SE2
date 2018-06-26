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
public class Player {
    private String uname;
    private String game;
    private int isPlay;

    public Player(String uname, String game, int isPlay) {
        this.uname = uname;
        this.game = game;
        this.isPlay = isPlay;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getIsPlay() {
        return isPlay;
    }

    public void setIsPlay(int isPlay) {
        this.isPlay = isPlay;
    }
    
    
}
