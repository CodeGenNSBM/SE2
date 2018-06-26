/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.dao;

import java.util.List;
import com.codegen.model.BankTransaction;
import com.codegen.model.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.Date;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ayesh
 * 
 */
@Repository
@Transactional
public class BankTransactionDAOImpl implements BankTransactionDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
     public BankTransaction getById(int id)
    {
        System.out.println("Student name2 : "+ id);
        BankTransaction tblTemp=null;
        try{
        Session session = sessionFactory.getCurrentSession();
        tblTemp = (BankTransaction) session.get(BankTransaction.class, id);
        System.out.println("Student name : "+ tblTemp.getId());
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
    //********************getBankTransaction(0,null,0,null,null,null)
    //********************getBankTransaction(10,null,0,null,null,null)
    //********************getBankTransaction(0,"Ayesh",0,null,null,null)
    //********************getBankTransaction(0,null,2,1,null,null)
    @Override
    public List<BankTransaction> getBankTransaction(BankTransaction tblTemp) {

        int v_playerID;
        int v_transferDate;
        int v_type;
        int v_isActive;
        int v_isSuccess;
        int v_recieverOrSender;

        if (tblTemp.getPlayerId() == 0) {
            v_playerID = 0;
        } else {
            v_playerID = 1;
        }
        if (tblTemp.getTransferDate() == null || "".equals(tblTemp.getTransferDate())) {
            v_transferDate = 0;
        } else {
            v_transferDate = 1;
        }
        if (tblTemp.getType() == 0) {
            v_type = 0;
        } else {
            v_type = 1;
        }
        if (tblTemp.isIsActive()== false) {
            v_isActive = 0;
        } else {
            v_isActive = 1;
        }
        if (tblTemp.isIsSuccess() == false) {
            v_isSuccess = 0;
        } else {
            v_isSuccess = 1;
        }
        if (tblTemp.getReceiverOrSender() == null || "".equals(tblTemp.getReceiverOrSender())) {
            v_recieverOrSender = 0;
        } else {
            v_recieverOrSender = 1;
        }

        List<BankTransaction> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "from BankTransaction"
                    + " where "
                    + " ((:v_player_id = 1 and playerId = :player_id) or :v_player_id = 0) "
                    + "and ((:v_transfer_Date = 1 and transferDate = :transfer_Date) or :v_transfer_Date = 0) "
                    + "and ((:v_type = 1 and type = :type) or :v_type = 0) "
                    + "and ((:v_is_Active = 1 and isActive = :is_Active) or :v_is_Active = 0) "
                    + "and ((:v_is_Success = 1 and isSuccess = :is_Success) or :v_is_Success = 0) "
                    + "and ((:v_reciever_Or_Sender = 1 and receiverOrSender = :reciever_Or_Sender) or :v_reciever_Or_Sender = 0)";

            Query query = session.createQuery(hql);

            query.setParameter("v_player_id", v_playerID);
            query.setParameter("player_id", tblTemp.getPlayerId());

            query.setParameter("v_transfer_Date", v_transferDate);
            query.setParameter("transfer_Date", tblTemp.getTransferDate());

            query.setParameter("v_type", v_type);
            query.setParameter("type", tblTemp.getType());

            query.setParameter("v_is_Active", v_isActive);
            query.setParameter("is_Active", tblTemp.isIsActive());

            query.setParameter("v_is_Success", v_isSuccess);
            query.setParameter("is_Success", tblTemp.isIsSuccess());

            query.setParameter("v_reciever_Or_Sender", v_recieverOrSender);
            query.setParameter("reciever_Or_Sender", tblTemp.getReceiverOrSender());
            
System.out.println("Bank name : "+ tblTemp.getPlayerId());
            lst = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    //*************delete query with player name
    //*************return 0 or more
    @Override
    public int deleteBankTransaction(int playerID) {
        System.out.println("player name : "+ playerID);
        int result = 0;
        try {
            Session session = sessionFactory.getCurrentSession();

            String hql = "delete BankTransaction where playerId =:player_id";

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
    public int addBankTransaction(BankTransaction bank_transaction) {
        try {
            Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(bank_transaction);
        return Integer.valueOf(id.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }        
    }
    
    @Override
    public BankTransaction updateBankTransaction(BankTransaction bank_transaction) {
        Session session = sessionFactory.getCurrentSession();
        BankTransaction temp=null;
        try {
            temp = (BankTransaction)session.get(BankTransaction.class, bank_transaction.getId());
            temp.setPlayerId(bank_transaction.getPlayerId());
            temp.setAmount(bank_transaction.getAmount());
            temp.setTransferDate(bank_transaction.getTransferDate());
            temp.setType(bank_transaction.getType());
            temp.setIsSuccess(bank_transaction.isIsSuccess());
            temp.setIsActive(true);
            temp.setReceiverOrSender(bank_transaction.getReceiverOrSender());
            temp.setActiveDate(bank_transaction.getActiveDate());
            session.update(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return temp;
    }
    
    @Override
    public BankTransaction deleteBankTransaction(BankTransaction bank_transaction) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(bank_transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bank_transaction;
    }
}
