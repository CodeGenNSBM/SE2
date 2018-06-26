/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
@Table(name = "tbl_temp_user")
public class TblTempUser implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "dateTime")
    private Timestamp dateTime;
    
    @Column(name = "isPlay")
    private int isPlay;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

   
    public int getIsPlay() {
        return isPlay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    
    public void setIsPlay(int isPlay) {
        this.isPlay = isPlay;
    }
    
    
    
}
