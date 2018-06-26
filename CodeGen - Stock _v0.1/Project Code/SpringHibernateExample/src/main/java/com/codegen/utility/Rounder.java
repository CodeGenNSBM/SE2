/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.utility;

import com.codegen.model.Tbluser;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruvin
 */
public class Rounder {
    public static List<Player> usersPlay=new ArrayList<Player>();
    public static List<Game> games=new ArrayList<Game>();
   public static void makeList(String uname,String gameName)
   {
       Player player =new Player(uname, gameName, 1);
       usersPlay.add(player);
       Game g=new Game(gameName);
       games.add(g);
        
    
   }
   public static List<Player> getByGame(String game)
   {
        List<Player> usersByGame=new ArrayList<Player>();
       for(int c=0;c<usersPlay.size();c++)
       {
           if(usersPlay.get(c).getGame().equals(game))
           {
               usersByGame.add(usersPlay.get(c));
           }
       }
       return usersByGame;
   }
    public static Player getByGameName(String uname,String game)
   {
        Player usersByNme=null;
       for(int c=0;c<usersPlay.size();c++)
       {
           if(usersPlay.get(c).getGame().equals(game) && usersPlay.get(c).getUname().equals(uname) )
           {
               usersByNme=usersPlay.get(c);
           }
       }
       return usersByNme;
   } 
   
    public static void setGames(String gamename)
    {
        Game game=new Game(gamename);
        games.add(game);
        
    }
    public static List<Game> getAllgame()
    {
        return games;
    }
    public static Game Notstartred()
    {   Game notstart=null;
        for(int c=0;c<games.size();c++)
       {
           if(games.get(c).getFull()==0 )
           {
               notstart=games.get(c);
           }
       }
       return notstart;
    }
}
