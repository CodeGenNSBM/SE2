/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.controller;

import com.codegen.model.BankTransaction;
import com.codegen.service.BankTransactionService;
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
@RequestMapping("transaction")
public class BankTransactionController {
    @Autowired
    private BankTransactionService banktransactionservice;
    
    @RequestMapping(value="/addBankTransaction")
    public @ResponseBody String addBankTransaction(@RequestBody BankTransaction obj){
        int id = banktransactionservice.addBankTransaction(obj);
        
        if(id!=0){
            return "success";
        }
        else        
        return "fail";  
    }
    
    @RequestMapping(value="/getById") 
    public @ResponseBody  BankTransaction getById(@RequestBody BankTransaction obj){        
        BankTransaction tblTemp = banktransactionservice.getById(obj.getId());
        return tblTemp; 
    }
    
    // okkoma data select krna ona nm null hama ekatama
    @RequestMapping(value="/getBankTransaction")
    public @ResponseBody List<BankTransaction> getBankTransaction(@RequestBody BankTransaction obj,HttpServletRequest request){
        obj.setPlayerId((int)request.getSession().getAttribute("userid"));
        List<BankTransaction> lst = null;
        lst = banktransactionservice.getBankTransaction(obj);        
        return lst;
    }
    
    @RequestMapping(value="/updateById")
    public @ResponseBody String updateBankTransaction(@RequestBody BankTransaction obj){
        banktransactionservice.updateBankTransaction(obj);
        return "success";
    }
    
    @RequestMapping(value="/deleteByID")
    public @ResponseBody  String deleteByID(@RequestBody BankTransaction obj){
        banktransactionservice.deleteBankTransaction(obj.getPlayerId());
        return "success";
    }
}
