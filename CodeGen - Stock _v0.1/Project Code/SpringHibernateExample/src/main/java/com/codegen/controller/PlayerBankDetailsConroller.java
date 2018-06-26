/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.controller;

import com.codegen.model.PlayerBankDetails;
import com.codegen.service.PlayerBankDetailsService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author Ayesh
 */
@Controller
@RequestMapping("bankDetail")
public class PlayerBankDetailsConroller {
    @Autowired
    private PlayerBankDetailsService playerbankdetailsservice;
    
    @RequestMapping(value="/addBankDetail")
    public @ResponseBody String addPlayerBankDetails(@RequestBody PlayerBankDetails _obj){        
        int id = playerbankdetailsservice.addPlayerBankDetails(_obj);
        
        if(id!=0){
            return "success";
        }
        else        
        return "fail";  
    }
    
    @RequestMapping(value="/getById") 
    public @ResponseBody  PlayerBankDetails getById(@RequestBody PlayerBankDetails _obj){ 
        PlayerBankDetails tblTemp = playerbankdetailsservice.getById(_obj.getId());
        return tblTemp; 
    }
    
    // okkoma data select krna ona nm null hama ekatama
    @RequestMapping(value="/getPlayerBankDetail")
    public @ResponseBody List<PlayerBankDetails> getPlayerBankDetail(@RequestBody PlayerBankDetails _obj,HttpServletRequest request){ 
        _obj.setPlayerId((int)request.getSession().getAttribute("userid"));
        List<PlayerBankDetails> lst = null;
        lst = playerbankdetailsservice.getPlayerBankDetail(_obj);        
        return lst;
    }
    
    @RequestMapping(value="/updateById")
    public String updatePlayerBankDetails(@RequestBody PlayerBankDetails _obj){
        playerbankdetailsservice.updatePlayerBankDetails(_obj);
        return "success";
    }
    
    @RequestMapping(value="/deleteByID")
    public @ResponseBody String deleteByID(@RequestBody PlayerBankDetails _obj){
        playerbankdetailsservice.deletePlayerBankDetail(_obj.getPlayerId());
        return "success";
    }
    
    
    /////
    @RequestMapping(value="/getPlayerBankDetailsById") 
    public String getPlayerBankDetailsById(PlayerBankDetails pbd){ 
        
         List<PlayerBankDetails> lst = null;
        lst = playerbankdetailsservice.getPlayerBankDetailsByPId(pbd.getPlayerId()); 
        if(lst != null)
            return "success";
        else
            return "fail";
    }
    
    @RequestMapping(value="/updateCashByPId")
    public String updateCashByPId(){
        
        double cash=800.0;
        int pid=9;
        playerbankdetailsservice.updateCashByPId(cash,pid);
        return "success";
    }
}                                                                                        