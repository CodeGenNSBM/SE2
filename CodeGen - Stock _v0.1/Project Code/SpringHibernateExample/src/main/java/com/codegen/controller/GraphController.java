/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.controller;

import com.codegen.model.PlayerBankDetails;
import com.codegen.model.TblTempUser;
import com.codegen.model.TblestockSectorDetails;
import com.codegen.model.Tblsector;
import com.codegen.model.Tbltemp_buy_sell;
import com.codegen.service.BrokerService;
import com.codegen.service.PlayerBankDetailsService;
import com.codegen.service.TempUserService;
import com.codegen.utility.Cash;
import com.codegen.utility.Sect;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ruvin
 */
@Controller
public class GraphController {
   @Autowired
    private BrokerService brokerservice;
  
   @Autowired
    private PlayerBankDetailsService playerbankdetailsservice;
   
   @Autowired
   private TempUserService tempeoryservice;
   
   
     @RequestMapping(value="/graphsup1")
    public @ResponseBody List<Sect> getRelevantPrices(HttpServletRequest request){
        request.getSession().getAttribute("userid");
        int counterStock=0;
        int total=0;
        //(int)request.getSession().getAttribute("userid")
        List<Tblsector> sectors=brokerservice.getAllSectors(); 
        List<Tbltemp_buy_sell> list=brokerservice.getTempBuySellByUID((int)request.getSession().getAttribute("userid"));
        List<Sect> graphsup=new ArrayList<Sect>();
        //  List<TblestockSectorDetails> listElement=new ArrayList<TblestockSectorDetails>();
        for(int co=0;co<sectors.size();co++)
        {
            counterStock=0;
        for(int r=0; r<list.size();r++)
        {
            if(list.get(r).getSectorID_fk()==sectors.get(co).getSectorId())
            {
                counterStock=counterStock+list.get(r).getStockAmount();
            }
            
        }
        total=total+counterStock;
        Sect sect=new Sect(sectors.get(co).getSectorName(),counterStock);
        graphsup.add(sect);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return graphsup;
    }
    
     @RequestMapping(value="/graphsup3")
    public @ResponseBody List<Sect> getRelevantPricesBuy(HttpServletRequest request){
        request.getSession().getAttribute("userid");
        int counterStock=0;
        int total=0;
        //(int)request.getSession().getAttribute("userid")
        List<Tblsector> sectors=brokerservice.getAllSectors(); 
        List<Tbltemp_buy_sell> list=brokerservice.getTempBuySellByUID((int)request.getSession().getAttribute("userid"));
        List<Sect> graphsup=new ArrayList<Sect>();
        //  List<TblestockSectorDetails> listElement=new ArrayList<TblestockSectorDetails>();
        for(int co=0;co<sectors.size();co++)
        {
            counterStock=0;
        for(int r=0; r<list.size();r++)
        {
            if(list.get(r).getSectorID_fk()==sectors.get(co).getSectorId() && list.get(r).getIsBuy()==1 )
            {
                counterStock=counterStock+list.get(r).getStockAmount();
            }
            
        }
        total=total+counterStock;
        Sect sect=new Sect(sectors.get(co).getSectorName(),counterStock);
        graphsup.add(sect);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return graphsup;
    }
    
      @RequestMapping(value="/graphsup4")
    public @ResponseBody List<Sect> getRelevantPricesSell(HttpServletRequest request){
        request.getSession().getAttribute("userid");
        int counterStock=0;
        int total=0;
        //(int)request.getSession().getAttribute("userid")
        List<Tblsector> sectors=brokerservice.getAllSectors(); 
        List<Tbltemp_buy_sell> list=brokerservice.getTempBuySellByUID((int)request.getSession().getAttribute("userid"));
        List<Sect> graphsup=new ArrayList<Sect>();
        //  List<TblestockSectorDetails> listElement=new ArrayList<TblestockSectorDetails>();
        for(int co=0;co<sectors.size();co++)
        {
            counterStock=0;
        for(int r=0; r<list.size();r++)
        {
            if(list.get(r).getSectorID_fk()==sectors.get(co).getSectorId() && list.get(r).getIsBuy()==0 )
            {
                counterStock=counterStock+list.get(r).getStockAmount();
            }
            
        }
        total=total+counterStock;
        Sect sect=new Sect(sectors.get(co).getSectorName(),counterStock);
        graphsup.add(sect);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return graphsup;
    }
    
  /////
     @RequestMapping(value="/graphsup5")
    public @ResponseBody List<Cash> getRelevantCashList(HttpServletRequest request){
        request.getSession().getAttribute("userid");
        int counterStock=0;
        int total=0;      
        List<Cash> graphsup=new ArrayList<Cash>();
        Double amnt=playerbankdetailsservice.getPlayerBankDetailsByPId((int)request.getSession().getAttribute("userid")).get(0).getAvailableBalance();        
        Cash cash =new Cash(amnt,"Current Amount");
        graphsup.add(cash);        
        return graphsup;
    }
    
    @RequestMapping(value="/graphsup6")
    public @ResponseBody List<Cash> getRelevantCashListAll(HttpServletRequest request){
        request.getSession().getAttribute("userid");
       
        List<Cash> graphsup=new ArrayList<Cash>();
        List<TblTempUser> userslogged=tempeoryservice.getIsPlay(1);
       // PlayerBankDetails details=new PlayerBankDetails();
        System.out.println("fuck.........."+userslogged.size());
        for(int count=0; count<userslogged.size();count++)
        {
            Double amnt=playerbankdetailsservice.getPlayerBankDetailsByPId((int)request.getSession().getAttribute("userid")).get(0).getAvailableBalance();  
           if(amnt!=null){
            Cash cash =new Cash(amnt,userslogged.get(count).getName());
            graphsup.add(cash); 
        }
        }
        return graphsup;
        
    }
    
    
    
    
    
}
