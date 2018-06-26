/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.dao;

import com.codegen.model.BankTransaction;
import java.util.List;
import com.codegen.model.PlayerBankDetails;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ayesh
 */
@Repository
@Transactional
public class PlayerBankDetailsDAOImlp implements PlayerBankDetailsDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
     public PlayerBankDetails getById(int id)
    {
        PlayerBankDetails tblTemp=null;
        try{
        Session session = sessionFactory.getCurrentSession();
        tblTemp = (PlayerBankDetails) session.get(PlayerBankDetails.class, id);
        //session.close();
        
        }
        catch(Exception x)
        {
            System.out.println(x.toString());
        }
        return tblTemp;
    }
    
    
    //********************select query with return list for any selection type
    //********************example
    //********************getPlayerBankDetail(0,null,null,null)
    //********************getPlayerBankDetail(10,null,null,null)
    //********************getPlayerBankDetail(0,"Ayesh",null,null)
    //********************getPlayerBankDetail(0,null,null,1)
    @Override
    public List<PlayerBankDetails> getPlayerBankDetail(PlayerBankDetails _obj) {

        int v_playerID;
        int v_playerName;
        int v_bankName;
        int v_isActive;

        if (_obj.getPlayerId() == 0) {
            v_playerID = 0;
        } else {
            v_playerID = 1;
        }
        if (_obj.getBankName() == null || "".equals(_obj.getBankName())) {
            v_bankName = 0;
        } else {
            v_bankName = 1;
        }
        if (_obj.isIsActive() == false) {
            v_isActive = 0;
        } else {
            v_isActive = 1;
        }

        List<PlayerBankDetails> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            String hql = "from PlayerBankDetails where "
                    + "((:v_player_id = 1 and playerId = :player_id) or :v_player_id = 0) "
                    + "and ((:v_bank_name = 1 and bankName = :bank_name) or :v_bank_name = 0) "
                    + "and ((:v_is_Active = 1 and isActive = :is_Active) or :v_is_Active = 0)";
            Query query = session.createQuery(hql);

            query.setParameter("v_player_id", v_playerID);
            query.setParameter("player_id", _obj.getPlayerId());
            
            query.setParameter("v_bank_name", v_bankName);
            query.setParameter("bank_name", _obj.getBankName());

            query.setParameter("v_is_Active", v_isActive);
            query.setParameter("is_Active", _obj.isIsActive());

            lst = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
   
    //*************delete query with player name
    //*************return 0 or more
    @Override
    public int deletePlayerBankDetail(int playerID){
        System.out.println("player name : "+ playerID);
        int result = 0;
        try {
            Session session = sessionFactory.getCurrentSession();

            String hql = "delete PlayerBankDetails where playerId =:player_id";

            Query query = session.createQuery(hql);
            query.setParameter("player_id", playerID);

            result = query.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /////////////////////////////////////////
    
    
    @Override
    public int addPlayerBankDetails(PlayerBankDetails player_bank_details) {
        try {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(player_bank_details);
        return Integer.valueOf(id.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }       
    }
    
    @Override
    public PlayerBankDetails updatePlayerBankDetails(PlayerBankDetails player_bank_details) {
        Session session = sessionFactory.getCurrentSession();
        PlayerBankDetails temp =null;
        try {
        temp = (PlayerBankDetails) session.get(PlayerBankDetails.class, player_bank_details.getPlayerId());
        temp.setPlayerId(player_bank_details.getPlayerId());
        temp.setBankName(player_bank_details.getBankName());
        temp.setAvailableBalance(player_bank_details.getAvailableBalance());
        temp.setIsActive(player_bank_details.isIsActive());
        temp.setActiveDate(player_bank_details.getActiveDate());
        session.update(player_bank_details);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return temp;
    }
    
    @Override
    public PlayerBankDetails deletePlayerBankDetails(PlayerBankDetails player_bank_details) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(player_bank_details);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return player_bank_details;
    }
    
    
    
    /////
    
    @Override
    public List<PlayerBankDetails> getPlayerBankDetailsByPId(int pid) {
        List<PlayerBankDetails> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            int player_ID = pid;
            String sql = "SELECT * FROM player_bank_details WHERE player_Id LIKE :playerid";
            Query query = session.createSQLQuery(sql).addEntity(PlayerBankDetails.class);
            query.setString("playerid", "%" + player_ID + "%"); // again, the leading wild card may be a problem
            lst = query.list();
            

            System.out.println("0000000000*********************************************");
            System.out.println(lst.get(0).getId());

           // session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    
    @Override
    public int updateCashByPId(double cash, int pid) {
        System.out.println("entered");
        //Tbluser tblUser = null;
        try{
            Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();

       
            String hql = "update PlayerBankDetails set availableBalance =:cash where playerId =:player_id";

            Query query = session.createQuery(hql);
            query.setParameter("cash", cash);
            query.setParameter("player_id", pid);

            query.executeUpdate();
        
        
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
            return 0;
    }
}
