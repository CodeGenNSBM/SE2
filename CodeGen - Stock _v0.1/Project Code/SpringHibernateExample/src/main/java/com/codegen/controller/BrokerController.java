/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.controller;

import com.codegen.model.BankTransaction;
import com.codegen.model.Person;
import com.codegen.model.PlayerBankDetails;
import com.codegen.model.TblestockSectorDetails;
import com.codegen.model.Tblsector;
import com.codegen.model.Tblstock;
import com.codegen.model.Tbltemp_buy_sell;
import com.codegen.model.Tbluser;
import com.codegen.service.BankTransactionService;
import com.codegen.service.BrokerService;
import com.codegen.service.PlayerBankDetailsService;
import com.codegen.service.UserService;
import com.codegen.utility.SectorStockDetail;
import java.util.AbstractList;
import java.util.ArrayList;
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
@RequestMapping("broker")
public class BrokerController {
    
    @Autowired
    private BrokerService brokerservice;
     @Autowired
    private UserService userservice;
    
    @Autowired
    private PlayerBankDetailsService bservice;
    @Autowired
    private  BankTransactionService trans;
    
    @RequestMapping(value="/addStock")
    public String addStock(){
        Tblstock t = new Tblstock();
        t.setStockName("asdf");
        
        
        int id= brokerservice.addStock(t);
        
        if(id!=0){
            return "success";
        }
        else        
        return "fail";
    }
    
    @RequestMapping(value="/addSector")
    public String addSector(){
        Tblsector t = new Tblsector();
        t.setSectorName("sector1");
        
        
        int id= brokerservice.addSector(t);
        
        if(id!=0){
            return "success";
        }
        else        
        return "fail";
    }
    
    
    @RequestMapping(value="/addTblStock_sector_details")
    public String addTblStock_sector_details(@RequestBody TblestockSectorDetails tbDetail){
        
        System.out.println("Entere to sell section");
        
        int id= brokerservice.addTblStock_sector_details(tbDetail);
        
        if(id!=0){
            return "success";
        }
        else        
        return "fail";
    }
    
    
    @RequestMapping(value="/addTbltemp_buy_sell")
    public String addTbltemp_buy_sell(@RequestBody Tbltemp_buy_sell tbs,HttpServletRequest request){
        Date date=new Date();
        double amonutstock=0;
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxqaqqqaHard jump"+tbs.getId()+tbs.getSectorID_fk()+tbs.getStockAmount()+tbs.getStockID_fk()+tbs.getUserId_fk());
        PlayerBankDetails det=new PlayerBankDetails();
             det.setPlayerId((int)request.getSession().getAttribute("userid"));
             det.setIsActive(true);
              List<PlayerBankDetails> listB=bservice.getPlayerBankDetail(det);
       tbs.setUserId_fk(userservice.getByUName((String)request.getSession().getAttribute("user")).get(0).getId());
        System.out.println(tbs.getStockAmount());
        int id= brokerservice.addTbltemp_buy_sell(tbs);
       List <TblestockSectorDetails> itr=brokerservice.getSSDS();
       for(int x=0;x<itr.size();x++)
       {
           if(itr.get(x).getSectorId_fk()==tbs.getSectorID_fk() && itr.get(x).getStockID_fk()==tbs.getStockID_fk())
           {
              amonutstock=tbs.getStockAmount()*itr.get(x).getCurrentRate();
           }
       }
        
        //update bank summaries
        BankTransaction tran=new BankTransaction((int)request.getSession().getAttribute("userid"), amonutstock, date, 1, true, true, "StockV3", date);
          /* tran.setActiveDate(date);
           tran.setAmount(amonutstock);
           tran.setIsActive(true);
           tran.setIsSuccess(true);
           tran.setPlayerId((int)request.getSession().getAttribute("userid"));
           tran.setType(1);
           tran.setTransferDate(date);
           tran.setReceiverOrSender("StockV3");*/
           trans.addBankTransaction(tran);
           System.out.println("---------ssssssssssssss"+(int)request.getSession().getAttribute("userid")+amonutstock);
           //PlayerBankDetails bdetail=new PlayerBankDetails();
           //bdetail.setActiveDate(date);
           if(tbs.getIsBuy()==1){
          // bdetail.setAvailableBalance(listB.get(0).getAvailableBalance()-amonutstock);
            bservice.updateCashByPId(listB.get(0).getAvailableBalance()-amonutstock,(int)request.getSession().getAttribute("userid"));
           }
           else
           {
           //bdetail.setAvailableBalance(listB.get(0).getAvailableBalance()+amonutstock);
           bservice.updateCashByPId(listB.get(0).getAvailableBalance()+amonutstock,(int)request.getSession().getAttribute("userid"));
           }
           //bdetail.setBankName("StockV3");
           //bdetail.setIsActive(true);
          // bdetail.setPlayerId((int)request.getSession().getAttribute("userid"));
           
           //bservice.updatePlayerBankDetails(bdetail);
           
        if(id!=0){
            return "success";
            
        }
        else        
        return "fail";
    }
    
    
    @RequestMapping(value="/getSSDS")
    public String getSSDS(){
        
        List <TblestockSectorDetails> lst = null;
        lst = brokerservice.getSSDS(); 
        if(lst != null)
            return "success";
        else
            return "fail";
    }
    
    
    @RequestMapping(value="/getBySsdId")
    public @ResponseBody TblestockSectorDetails getBySSDId(@RequestBody int id){
        
        TblestockSectorDetails tblSSD = brokerservice.getSSDbyId(id);
        
        return tblSSD;
    }
    
    
    @RequestMapping(value="/getTempBuySellDS")
    public String gettempBuySellDS(){
        
        List <Tbltemp_buy_sell> lst = null;
        lst = brokerservice.gettempBuySellDS(); 
        if(lst != null)
            return "success";
        else
            return "fail";
    }
    
    
    @RequestMapping(value="/getTBSById")
    public @ResponseBody Tbltemp_buy_sell getTBSById(@RequestBody int id){ 
        
        Tbltemp_buy_sell tblBS = brokerservice.getTBSById(id);
        
            return tblBS; 
        
       
    }
    
    
        
    //*********************
    @RequestMapping(value="/getStocksBySID")
    public @ResponseBody List<TblestockSectorDetails>  getStocksBySID(@RequestBody int secID){ 
        
        List<TblestockSectorDetails> lst = null;
        lst = brokerservice.getStocksBySID(secID); 
        return lst;
    }
        
    
    
    //*******************************
    
    @RequestMapping(value="/getAllSectors")
    public @ResponseBody List<Tblsector> getAllSectors()
    {  
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        List<Tblsector> lst = null;
        lst = brokerservice.getAllSectors();    
        System.out.println(lst);
       return lst;
       
    }
    
    @RequestMapping(value="/getAllSectorsBuy")
    public @ResponseBody List<Tblsector> getAllSectorsFromBuy(HttpServletRequest request)
    {  
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        List<Tbltemp_buy_sell> lst = null;
        List<Tblsector> lstsect = null;
        List<Tbluser> users=userservice.getByUName((String)request.getSession().getAttribute("user"));
        List<Tblsector> elemnt=new ArrayList<Tblsector>();
        lst = brokerservice.getTempBuySellByUID(users.get(0).getId()); 
        lstsect=brokerservice.getAllSectors();
        for(int count=0;count<lstsect.size();count++)
        {    
               for(int r=0;r<lst.size();r++)
               {   
                   if(lst.get(r).getSectorID_fk()==lstsect.get(count).getSectorId())
                   {
                       elemnt.add(lstsect.get(count));
                       break;
                   }               
               }
        
        }
       return elemnt;
       
    }
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
     @RequestMapping(value="/getAllStockssBuy")
    public @ResponseBody List<Tblstock> getAllStocksFromBuy(@RequestBody Tblsector sector,HttpServletRequest request)
    {  
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        List<Tbltemp_buy_sell> lst = null;
        List<TblestockSectorDetails> lstsect = null;
        List<Tbluser> users=userservice.getByUName((String)request.getSession().getAttribute("user"));
        List<Tblstock> elemnt=new ArrayList<Tblstock>();
        lst = brokerservice.getTempBuySellByUID(users.get(0).getId()); 
        lstsect=brokerservice.getSSDS();
        for(int count=0;count<lstsect.size();count++)
        {    
               for(int r=0;r<lst.size();r++)
               {   
                   if(lst.get(r).getStockID_fk()==lstsect.get(count).getStockID_fk() && lst.get(r).getSectorID_fk()==sector.getSectorId() )
                   {
                       elemnt.add(brokerservice.getStockById(lst.get(r).getStockID_fk()));
                       break;
                   }               
               }
        
        }
       return elemnt;
       
    }
    
    
    
    
    
    @RequestMapping(value="/getStockById")
    public @ResponseBody Tblstock getStockById(@RequestBody int id){
        
        Tblstock tblSSD = brokerservice.getStockById(id);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return tblSSD;
    }
    
     @RequestMapping(value="/getStockAccordingSector")
    public @ResponseBody List<Tblstock> getStockAll(@RequestBody Tblsector sector){
        
        List<Tblstock>  listOfStocks = new ArrayList<Tblstock>();
        List<TblestockSectorDetails> list=null;
        System.out.println(sector.getSectorId());
         list=brokerservice.getStocksBySID(sector.getSectorId());
         for(int r=0;r<list.size();r++)
         {
             
           Tblstock stock=brokerservice.getStockById(list.get(r).getStockID_fk());
           if(stock!=null)
           {
               listOfStocks.add(stock);
           }
         }
        
        System.out.println("fired");
        return listOfStocks;
    }
    
    /////
    
    @RequestMapping(value="/getStockPrices")
    public @ResponseBody List<TblestockSectorDetails> getRelevantPrices(@RequestBody TblestockSectorDetails tble,HttpServletRequest request){
        request.getSession().getAttribute("userid");
        System.out.println("fuck"+tble.getSectorId_fk()+""+tble.getStockID_fk());
        List<TblestockSectorDetails> list=brokerservice.getSSDS();

          List<TblestockSectorDetails> listElement=new ArrayList<TblestockSectorDetails>();
        for(int r=0; r<list.size();r++)
        {
            if(list.get(r).getSectorId_fk()==tble.getSectorId_fk() && list.get(r).getStockID_fk()==tble.getStockID_fk())
            {
                listElement.add(list.get(r));
            }
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return listElement;
    }
    
    
      @RequestMapping(value="/getTempBuySellByUID")
    public String getTempBuySellByUID(){
        //uname="bbbnn";
        List<Tbltemp_buy_sell> lst = null;
        int uid=4;
        lst = brokerservice.getTempBuySellByUID(uid); 
        if(lst != null)
            return "success";
        else
            return "fail";
    }
    
    
     @RequestMapping(value="/getSSDSWithJoin")
    public @ResponseBody List<SectorStockDetail>  getSSDSWithJoin(@RequestBody Tblsector _obj){ 
        System.out.println("efsgdgdgdghdfhfhfh");
        List<SectorStockDetail> lst = null;
        lst = brokerservice.getSSDSWithJoin(_obj.getSectorId());
        return lst;
    }
    
}
