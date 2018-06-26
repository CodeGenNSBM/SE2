/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.controller;

import com.codegen.model.TblHistory;
import com.codegen.service.HistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Vishwa
 */
@Controller
@RequestMapping(value="/historyController")
public class HistoryController {
    
    @Autowired
    private HistoryService historyservice;
    
    
    @RequestMapping(value="/addData")
    public String addData(){
        TblHistory tblhistory = new TblHistory();
        tblhistory.setSectname("qqq");
        tblhistory.setStkname("www");
        tblhistory.setCprice(20.5);
        
        int id = historyservice.addData(tblhistory);
        
        if(id!=0){
            return "success";
        }
        else        
        return "fail";
  
    }
    
    
    @RequestMapping(value="/getBySectName")
    public String getBySectName(){
        //uname="bbbnn";
        List<TblHistory> lst = null;
        String secname="qqq";
        lst = historyservice.getBySectName(secname); 
        if(lst != null)
            return "success";
        else
            return "fail";
    }
    
    
    @RequestMapping(value="/getByStkName")
    public String getByStkName(){
        //uname="bbbnn";
        List<TblHistory> lst = null;
        String stkname="www";
        lst = historyservice.getByStkName(stkname); 
        if(lst != null)
            return "success";
        else
            return "fail";
    }
    
}
