/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.controller;

import com.codegen.model.BankTransaction;
import com.codegen.model.PlayerBankDetails;
import com.codegen.model.TblTempUser;
import com.codegen.model.TblestockSectorDetails;
import com.codegen.model.Tblsector;
import com.codegen.model.Tblstock;
import com.codegen.model.Tbltemp_buy_sell;
import com.codegen.model.Tbluser;
import com.codegen.service.BankTransactionService;
import com.codegen.service.BrokerService;
import com.codegen.service.PlayerBankDetailsService;
import com.codegen.service.TempUserService;
import com.codegen.service.TempUserServiceImpl;
import com.codegen.service.UserService;
import com.codegen.utility.Game;
import com.codegen.utility.GameTrends;
import com.codegen.utility.Player;
import com.codegen.utility.Rounder;
import java.io.PrintStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *using algorithm update prices as probabilities provides
 * 
 * @author Ruvin
 */
@Controller
public class GameController {
    
    @Autowired
    private BrokerService brokerservice;
    @Autowired
    private PlayerBankDetailsService bservice;
    @Autowired
    private  BankTransactionService trans;
    @Autowired
    private TempUserService uservice;
    @Autowired
    private UserService userservice;
  
    @RequestMapping(value="/updatePricesRealm")
    public String getRelevantPrices(HttpServletRequest request)  {
       GameTrends trend=new GameTrends();
       request.getSession().getAttribute("userid");
       List<TblestockSectorDetails> stockKeeper=new ArrayList <TblestockSectorDetails>();
       TblestockSectorDetails keeperContent=new TblestockSectorDetails();
       int currentSectId=0;
       int currentStockId=0;
       List<Tblsector> sectList=brokerservice.getAllSectors();
       List<TblestockSectorDetails> compList=null;
       List<Tblstock> stockList=new ArrayList <Tblstock>();
      for(int counter=0; counter<sectList.size();counter++)
      {   
          stockList.clear();
          stockKeeper.clear();
          compList=brokerservice.getStocksBySID(sectList.get(counter).getSectorId());
          for(int c=0;c<compList.size(); c++)
          {
             keeperContent.setId(compList.get(c).getId());
             keeperContent.setSectorId_fk(compList.get(c).getSectorId_fk());
             keeperContent.setStockID_fk(compList.get(c).getStockID_fk());
             stockKeeper.add(keeperContent);
             stockList.add(brokerservice.getStockById(compList.get(c).getSectorId_fk()));
             
          }
          for(int secondRound=0; secondRound<stockKeeper.size();secondRound++)
          {
              //@ResponseBody List<TblestockSectorDetails>
              double updatedprice=trend.determineTrend(secondRound,stockKeeper.get(secondRound).getCurrentRate() );
              System.out.println("damn shit price ...............@@@@@"+updatedprice);
              if(updatedprice!=0)
              {
                  stockKeeper.get(secondRound).setCurrentRate(updatedprice);
                  brokerservice.updateSSD(stockKeeper.get(counter));
                  System.out.println("updatere..............encoutered");
              }    
          }
                      compList.clear();
                     
      }
       return "success";
    }
    //@ResponseBody
    @RequestMapping(value="/makeRounder")
    public @ResponseBody String getGamegoing(HttpServletRequest request)  {
        Random rand = new Random();
        int value = rand.nextInt(50);
        String ret="";
        //Game game=new Game(Integer.toString(value));
        Rounder.setGames(Integer.toString(value));
        
        if( request.getSession().getAttribute("rounds")==null)
        {   System.out.println("zzzzzzzzzzzzz.......");
            request.getSession().setAttribute("rounds",1);
            request.getSession().setAttribute("min",5);
	    request.getSession().setAttribute("sec",0);
            Rounder.makeList((String) request.getSession().getAttribute("user"),Rounder.getAllgame().get(0).getName());
            do {                
                //wait till others join
            } while (Rounder.getByGame(Rounder.getAllgame().get(0).getName()).size()<3);
        }
        if( Rounder.getByGame(Rounder.getAllgame().get(0).getName()).size()>=3 || request.getSession().getAttribute("rounds")!=null)
        {
            System.out.println("zzzzzzzzzzzzz.......");
            
        try {
            Thread.sleep(30000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("hiiiiiiiiiiiiiiiiiiiii");
        /*if(request.getSession().getAttribute("rounds")==null){
            
        request.getSession().setAttribute("rounds",1);
           ret="Go";
        }*/
         if(10>=(int)request.getSession().getAttribute("rounds"))
        {
            
            System.out.println((int)request.getSession().getAttribute("rounds"));
          int round=(int) request.getSession().getAttribute("rounds");
          request.getSession().setAttribute("rounds",round+1); 
          request.getSession().setAttribute("min",5);
	  request.getSession().setAttribute("sec",0);
          ret= "Go";
        }
        else{
            ret= "Stop";
            //deside winner ***************************************
        }
        
        }
        return ret;
    }
    
    
    @RequestMapping(value="/makeRounderAuto")
    public @ResponseBody String gautoPlay(HttpServletRequest request)  {
         int[] chance={1,0};
         int[] amount={35,8,15,25,7,12};
         String console="";
         Date date=new Date();
         int rnd = new Random().nextInt(chance.length);
         if(chance[rnd]==1)
         {
             //buy section
           List <TblestockSectorDetails> stocksect=brokerservice.getSSDS();
           rnd=new Random().nextInt(stocksect.size());
             Tbltemp_buy_sell temp=new Tbltemp_buy_sell();
             temp.setIsBuy(1);
             temp.setSectorID_fk(stocksect.get(rnd).getSectorId_fk());
             //rnd=new Random().nextInt(stocksect.size());
             PlayerBankDetails det=new PlayerBankDetails();
             det.setPlayerId((int)request.getSession().getAttribute("userid"));
             det.setIsActive(true);
             List<PlayerBankDetails> listB=bservice.getPlayerBankDetail(det);
           double amonutstock=5*stocksect.get(rnd).getCurrentRate();
             temp.setStockAmount(5);
             
             temp.setStockID_fk(stocksect.get(rnd).getStockID_fk());
             temp.setUserId_fk((int)request.getSession().getAttribute("userid"));
           brokerservice.addTbltemp_buy_sell(temp);
           
           //update balance
           BankTransaction tran=new BankTransaction();
           tran.setActiveDate(date);
           tran.setAmount(amonutstock);
           tran.setIsActive(true);
           tran.setIsSuccess(true);
           tran.setPlayerId((int)request.getSession().getAttribute("userid"));
           tran.setType(1);
           tran.setTransferDate(date);
           tran.setReceiverOrSender("StockV3");
           trans.addBankTransaction(tran);
           
           PlayerBankDetails bdetail=new PlayerBankDetails();
           bdetail.setActiveDate(date);
           bdetail.setAvailableBalance(listB.get(0).getAvailableBalance()-amonutstock);
           bdetail.setBankName("StockV3");
           bdetail.setIsActive(true);
           bdetail.setPlayerId((int)request.getSession().getAttribute("userid"));
          // bservice.updatePlayerBankDetails(bdetail);
           bservice.updateCashByPId(listB.get(0).getAvailableBalance()-amonutstock,(int)request.getSession().getAttribute("userid") );
          // if(stocksect.get(rnd).getStockID_fk()!=nu)
           console="Computer buys "+brokerservice.getStockById(stocksect.get(rnd).getStockID_fk()).getStockName()+" 5 units.";
         }
         else if(brokerservice.getTempBuySellByUID((int)request.getSession().getAttribute("userid")).size()>0 && chance[rnd]==0)
         {// sel section
             List<Tbltemp_buy_sell> buysell=brokerservice.getTempBuySellByUID((int)request.getSession().getAttribute("userid"));
             PlayerBankDetails det=new PlayerBankDetails();
             det.setPlayerId((int)request.getSession().getAttribute("userid"));
             det.setIsActive(true);
              List<PlayerBankDetails> listB=bservice.getPlayerBankDetail(det);
            
             rnd=new Random().nextInt(buysell.size());
             buysell.get(rnd).getStockAmount();
             Tbltemp_buy_sell temp=new Tbltemp_buy_sell();
             temp.setIsBuy(1);
             temp.setSectorID_fk(buysell.get(rnd).getSectorID_fk());
             //rnd=new Random().nextInt(stocksect.size());
             temp.setStockAmount(buysell.get(rnd).getStockAmount());
             temp.setStockID_fk(buysell.get(rnd).getStockID_fk());
             temp.setUserId_fk((int)request.getSession().getAttribute("userid"));
           brokerservice.addTbltemp_buy_sell(temp);
           
          TblestockSectorDetails itr=brokerservice.getSSDbyId(buysell.get(rnd).getSectorID_fk());
          double amonutstock=3*itr.getCurrentRate();
           //update bank amounts
            BankTransaction tran=new BankTransaction();
           tran.setActiveDate(date);
           tran.setAmount(amonutstock);
           tran.setIsActive(true);
           tran.setIsSuccess(true);
           tran.setPlayerId((int)request.getSession().getAttribute("userid"));
           tran.setType(1);
           tran.setTransferDate(date);
           tran.setReceiverOrSender("StockV3");
           trans.addBankTransaction(tran);
           
           PlayerBankDetails bdetail=new PlayerBankDetails();
           bdetail.setActiveDate(date);
           bdetail.setAvailableBalance(listB.get(0).getAvailableBalance()+amonutstock);
           bdetail.setBankName("StockV3");
           bdetail.setIsActive(true);
           bdetail.setPlayerId((int)request.getSession().getAttribute("userid"));
           bservice.updatePlayerBankDetails(bdetail);
           bservice.updateCashByPId(listB.get(0).getAvailableBalance()+amonutstock,(int)request.getSession().getAttribute("userid"));
           console="Computer sells "+brokerservice.getStockById(buysell.get(rnd).getStockID_fk()).getStockName()+" 3 units.";

         }
         else
         {
              List <TblestockSectorDetails> stocksect=brokerservice.getSSDS();
              PlayerBankDetails det=new PlayerBankDetails();
             det.setPlayerId((int)request.getSession().getAttribute("userid"));
             det.setIsActive(true);
              List<PlayerBankDetails> listB=bservice.getPlayerBankDetail(det);
           rnd=new Random().nextInt(stocksect.size());
             Tbltemp_buy_sell temp=new Tbltemp_buy_sell();
             temp.setIsBuy(1);
             temp.setSectorID_fk(stocksect.get(rnd).getSectorId_fk());
             rnd=new Random().nextInt(stocksect.size());
             temp.setStockAmount(3);
             double amonutstock=3*stocksect.get(rnd).getCurrentRate();
             temp.setStockID_fk(stocksect.get(rnd).getStockID_fk());
             temp.setUserId_fk((int)request.getSession().getAttribute("userid"));
           brokerservice.addTbltemp_buy_sell(temp);
           
           BankTransaction tran=new BankTransaction();
           tran.setActiveDate(date);
           tran.setAmount(amonutstock);
           tran.setIsActive(true);
           tran.setIsSuccess(true);
           tran.setPlayerId((int)request.getSession().getAttribute("userid"));
           tran.setType(1);
           tran.setTransferDate(date);
           tran.setReceiverOrSender("StockV3");
           trans.addBankTransaction(tran);
           
           PlayerBankDetails bdetail=new PlayerBankDetails();
           bdetail.setActiveDate(date);
           bdetail.setAvailableBalance(listB.get(0).getAvailableBalance()+amonutstock);
           bdetail.setBankName("StockV3");
           bdetail.setIsActive(true);
           bdetail.setPlayerId((int)request.getSession().getAttribute("userid"));
           bservice.updatePlayerBankDetails(bdetail);
           bservice.updateCashByPId(listB.get(0).getAvailableBalance()+amonutstock,(int)request.getSession().getAttribute("userid"));
          console="Computer buys "+brokerservice.getStockById(stocksect.get(rnd).getStockID_fk()).getStockName()+" 5 units.";
         }
         return console;
    }
    
    
    @RequestMapping(value="/roundertest")
    public @ResponseBody String gamr(HttpServletRequest request)  {
        
        if(request.getSession().getAttribute("round")==null){
        Game game=new Game("StockV3");
        Player play=new Player((String)request.getSession().getAttribute("user"),"StockV3",1);
        Rounder.makeList((String)request.getSession().getAttribute("user"),"StockV3");
        request.getSession().setAttribute("round",1);
        request.getSession().setAttribute("play",1);
        do{
            //wait till 3 player have
        }
        while(uservice.getIsPlay(0).size()<3);
               
        return "Go";
        }
        else if((int)request.getSession().getAttribute("round")<11  && request.getSession().getAttribute("play")!=null)
        {
            uservice.updateIsPlayByPId(1,(String)request.getSession().getAttribute("user"));
            int newround=(int)request.getSession().getAttribute("round")+1;
            request.getSession().setAttribute("round",newround);
            
            return  "Go";
        }
        else
        {
            return "stop";
        }
    }
    
    @RequestMapping(value="/result")
    public String getResult(HttpServletRequest request)  {
        String userwin="";
        double amounthighest=0;
        double usercash=0;
        List<TblTempUser> tempLogged=uservice.getIsPlay(1);
        usercash=bservice.getPlayerBankDetailsByPId((int)request.getSession().getAttribute("userid")).get(0).getAvailableBalance();
        //usercash=bservice.getById( (int)request.getSession().getAttribute("userid")).getAvailableBalance();
        
        for(int counter=0;counter<tempLogged.size();counter++)
        {
            if(counter==0)
            {
                int nme=userservice.getByName(tempLogged.get(counter).getName()).get(0).getId();
                 amounthighest=bservice.getPlayerBankDetailsByPId(nme).get(0).getAvailableBalance();
                 userwin=tempLogged.get(counter).getName();
            }
            else
            {
                 int nme=userservice.getByName(tempLogged.get(counter).getName()).get(0).getId();
                
                if(amounthighest<bservice.getPlayerBankDetailsByPId(nme).get(0).getAvailableBalance())
                {
                    amounthighest=bservice.getPlayerBankDetailsByPId(nme).get(0).getAvailableBalance();
                    userwin=tempLogged.get(counter).getName();
                }
            }
        }
        if(userwin==(String)request.getSession().getAttribute("user"))
        {
            return "win";
        }
        else
        {
            return "loss";
        }
           
    }
    
    /*
    request.getSession().setAttribute("totalNumberOfQuizQuestions",document.getElementsByTagName("totalQuizQuestions").item(0).getTextContent());
    request.getSession().setAttribute("quizDuration",document.getElementsByTagName("quizDuration").item(0).getTextContent());
    request.getSession().setAttribute("min",document.getElementsByTagName("quizDuration").item(0).getTextContent());
    request.getSession().setAttribute("sec",0);
    */
    
}
