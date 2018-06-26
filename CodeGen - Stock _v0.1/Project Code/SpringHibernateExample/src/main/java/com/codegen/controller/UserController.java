/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.controller;

import com.codegen.model.PlayerBankDetails;
import com.codegen.model.TblTempUser;
import com.codegen.model.Tbluser;
import com.codegen.service.BankTransactionService;
import com.codegen.service.PlayerBankDetailsService;
import com.codegen.service.TempUserService;
import com.codegen.service.UserService;
import com.codegen.utility.Encryption;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vishwa
 */
@Controller
//@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService userservice;
    @Autowired
    private TempUserService tmpservice;
    @Autowired
    private PlayerBankDetailsService bankservice;
    @Autowired
    private BankTransactionService transservice;
    
     //Login
    @RequestMapping(value="/login" )
    public @ResponseBody String testGet(@RequestBody Tbluser user ,HttpServletRequest request){
         System.out.println(user.getUname());
        List<Tbluser> users=null;
        Tbluser actualuser=null;
        boolean isSuccess=false;
        System.out.println("aaaaaaaaaaaaaaaaa");
        users=userservice.getAllDS();
        
        for (int i=0; i<users.size(); i++) 
       {
         if(users.get(i).getUname().equals(user.getUname()) && users.get(i).getPassword().equals(Encryption.encrypt(user.getPassword())))
         {
             isSuccess=true;
             actualuser=users.get(i);
             break;
         }
       }
        if(isSuccess)
        {     System.out.println("Success");
              request.getSession().setAttribute("user", actualuser.getUname());
              request.getSession().setAttribute("userid",actualuser.getId());
              Date date=new Date();
           Timestamp timestamp;
           //keep logged users in temp
             timestamp = new java.sql.Timestamp(date.getTime());
              TblTempUser temp= new TblTempUser();
              temp.setDateTime(timestamp);
              temp.setId(user.getId());
              temp.setIsPlay(0);
              temp.setName(user.getUname());
            tmpservice.addTempUser(temp);
            //bank amount update
            PlayerBankDetails detailsB=new PlayerBankDetails();
            detailsB.setActiveDate(date);
            detailsB.setAvailableBalance(1000);
            detailsB.setBankName("StockV3");
            detailsB.setIsActive(true);
            detailsB.setPlayerId(actualuser.getId());
            bankservice.addPlayerBankDetails(detailsB);
            return "success";
        }
        else
        {    System.out.println("fail"); 
            return "fail";
        }
        
    }

    //Login
    
    
    //signin
     @RequestMapping(value="/signin" )
    public  @ResponseBody String signIn(@RequestBody Tbluser tuser ){
         System.out.println(tuser.getUname());
       
        if(userservice.getByUName(tuser.getUname()).size()>0)
        {
            return "exists";
        }
        else
        {
       // boolean isSuccess=false;
        System.out.println("aaaaaaaaaaaaaaaaa");
        tuser.setPassword(Encryption.encrypt(tuser.getPassword()));
        
        int id = userservice.addUser(tuser);
        if(id!=0)
        {     System.out.println("Success");
            return "success";
        }
        else
        {    System.out.println("fail"); 
             return "fail";
        }
        }
        
    }

    
    //signin
    
    //signOut
    
    @RequestMapping(value="/signout" )
    public  String signOut(HttpServletRequest request){
       
       List<TblTempUser> logged=tmpservice.getIsPlay(1);
       for(int c=0;c<logged.size();c++){
       if(logged.get(c).getName().equals(request.getSession().getAttribute("user"))) { 
           System.out.println("delete enter");
       tmpservice.deleteById(logged.get(c).getName());
       }
       }
       //delete bank details when log off 
       bankservice.deletePlayerBankDetail((int)request.getSession().getAttribute("userid"));
       transservice.deleteBankTransaction((int)request.getSession().getAttribute("userid"));
       request.getSession().invalidate();
       //delete user from temp
     
       return "login";
    }
    
    
    
    
    
    
    
    //
    
    
    
    
    
    @RequestMapping(value="/addUser")
    public String addUser(){
        System.out.println("dfghjkjhgfd");
        Tbluser u = new Tbluser();
        u.setName("me");
        u.setUname("me");
        u.setPassword(Encryption.encrypt("123"));
        
        int id = userservice.addUser(u);
        
        if(id!=0){
            return "success";
        }
        else        
        return "fail";
  
    }
    
    
    @RequestMapping(value="/getById") 
    public @ResponseBody  Tbluser getById(@RequestBody int id){ //requestbody, response body ekai add karnnna ona and string ekk wenuwata oblect or list ekk return krnna ona
        Tbluser tbluser = userservice.getById(id);
        return tbluser;    //oblect or list eka return krnwa
    }
    
    @RequestMapping(value="/getByName")
    public String getByName(String name){ 
        name="qwe";
        List<Tbluser> lst = null;
        lst = userservice.getByName(name); 
        if(lst != null)
            return "success";
        else
            return "fail";
    }
    
    @RequestMapping(value="/getAllDS")
    public String getAllDs()
    {
        List<Tbluser> lst = null;
        lst = userservice.getAllDS();    
        //System.out.println("&&&&&&&&&&&&&&&&&&&&&  "+lst.get(0).getName());
        if(lst != null)
            return "success";
        else
            return "fail";
    }
    
    
    
    @RequestMapping(value="/getByUName")
    public String getByUName(Tbluser tbluser){
        //uname="bbbnn";
        List<Tbluser> lst = null;
        lst = userservice.getByUName(tbluser.getUname()); 
        if(lst != null)
            return "success";
        else
            return "fail";
    }
    
    @RequestMapping(value="/updateById")
    public String updateByID(){
        Tbluser tblUser=new Tbluser();
        tblUser.setId(4);
        tblUser.setName("vvv");
        tblUser.setUname("aaa");
        tblUser.setPassword("12345");
        System.out.println("22222222222222222222222");
        userservice.updateByID(tblUser);
        return "success";
    }
    
    @RequestMapping(value="/deleteByID")
    public String deleteByID(Tbluser tbluser){
        
        //int id=3;
        //id=Long.valueOf(5);
        //BigInteger a = (BigInteger.valueOf(id));
        userservice.deleteById(tbluser.getId());
        return "success";
    }
    
    
    
   
   
    
}
