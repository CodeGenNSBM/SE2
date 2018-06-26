/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.utility;

import java.util.Random;

/**
 *
 * @author Ruvin
 */
public class GameTrends {
    int returnVal=0;
    int r=0;
    int m=0;
    int sectMarktplus[] = {3, 2, 1};
    int sectMarktminus[] = {-3, -2, -1};
    int random[] = {1, 2};
    int randomnegativ[] = { -1,  -2};
    int defaultWay[]={1,-1};
    int eventnegativ[] = { -1, -2,-3,-4,-5};
    int eventpositiv[] = { 1,2,3,4,5};
    int scandal[] = { -6,  -5,-4,-3};
    int profitwarning[] = { 2,  3};
    int tempEvent=0;
    private int oldSect;
    private boolean  generated=false;
    private double probEve;
    public GameTrends() {
        oldSect=0;
        probEve=0;
    }
    
    
    public double determineTrend(int round,double price) {
        returnVal=returnVal+sectTrend();
        returnVal=returnVal+marketTrend();
        returnVal=returnVal+randomTrend();
       returnVal=returnVal+eventHandler(round);
       if(returnVal>0){
       return   priceUpdater(price);
       }
       else
       {
       return price; 
       }
        
    }

    public int sectTrend() {
        if(generated){
            Random rand = new Random();
         r = rand.nextInt(10000000);
         m = r % 10;
        if (m < 6) {
            oldSect=oldSect-1; 
            return oldSect;
        }
        else
        {
            oldSect=oldSect+1; 
            return oldSect;
        }
            
        }
        else{
        generated=true;    
        Random rand = new Random();
         r = rand.nextInt(10000000);
         m = r % 10;
        if (m < 3) {
           return new Random().nextInt(sectMarktminus.length); 
        }
        else if(m<6){
             return new Random().nextInt(sectMarktplus.length);    
        } else {
          return 0;
        }
        }
    }

    public int marketTrend() {
                  Random rand = new Random();
        r = rand.nextInt(10000000);
        m = r % 10;
        if (m < 3) {
           return new Random().nextInt(sectMarktminus.length); 
        }
        else if(m<6){
             return new Random().nextInt(sectMarktplus.length);    
        } else {
          return 0;
        }
    }

    public int randomTrend() {
        Random rand = new Random();
        r = rand.nextInt(10000000);
        m = r % 10;
        if (m < 3) {
           return new Random().nextInt(randomnegativ.length); 
        }
        else if(m<6){
             return new Random().nextInt(random.length);    
        } else {
          return 0;
        }
    }

    public int eventHandler(int counter) {
        probEve=probEve+0.1;
        if(probEve>=0.33 && probEve<0.67 && counter>=2 && counter<=5)
        {  
            Random rand = new Random();
        r = rand.nextInt(10000000);
        m = r % 10;
        if (m < 6) {
            probEve=0;
           tempEvent= new Random().nextInt(eventnegativ.length); 
           
           //bust
        }
        else {
            probEve=0;
             tempEvent= new Random().nextInt(eventpositiv.length);  
             //boom event
        } 
        }
        else if(probEve>=0.67 && counter>=1 && counter<=7)
        {
            //stock events
        Random rand = new Random();
        r = rand.nextInt(10000000);
        m = r % 10;
        if (m < 3) {
            //take over
            probEve=0;
          tempEvent= new Random().nextInt(eventnegativ.length); 
        }
        else if(m>2.5 && m<6){
            //scandal
            probEve=0;
            tempEvent= new Random().nextInt(scandal.length);    
        } else {
            //profit warning
          probEve=0;
          tempEvent= new Random().nextInt(profitwarning.length); 
        }
        }
        return tempEvent;
           
    }
    public double priceUpdater(double price)
    {
        return price*(returnVal/100)+price;
    }

}
