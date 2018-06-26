/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.dao;

import com.codegen.model.Person;
import com.codegen.model.Tblsector;
import com.codegen.model.Tblstock;
import com.codegen.model.TblestockSectorDetails;
import com.codegen.model.Tbltemp_buy_sell;
import com.codegen.utility.SectorStockDetail;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vishwa
 */

@Repository
@Transactional

public class BrokerDAOImpl implements BrokerDAO{
    @Autowired(required = true)
    private SessionFactory sessionFactory;
    
     @Override
    public List<SectorStockDetail> getSSDSWithJoin(int sectorID) {
        List<SectorStockDetail> lst = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "select sec.sectorName, stc.stockName, det.currentRate from TblestockSectorDetails det, Tblsector sec, Tblstock stc "
                        + "where "
                        + "det.sectorId_fk = sec.id "
                        + "and det.stockID_fk = stc.id ";
                        //+ "and sectorId_fk = :v_sectorId_fk ";
                   // +"inner join Det.tblsector as sec";
            Query query = session.createQuery(hql);
            //query.setParameter("v_sectorId_fk", sectorID);
            lst = query.list();

            System.out.println("*sadafasf*******  ");
           // session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    } 
    @Override
    public int addStock(Tblstock tblstock) {
        Session session = sessionFactory.getCurrentSession();
        int id = (int) session.save(tblstock);
        return id;
    }
    
    @Override
    public int addSector(Tblsector tblsector) {
        Session session = sessionFactory.getCurrentSession();
        int id = (int) session.save(tblsector);
        return id;
    }
    
    @Override
    public int addTblStock_sector_details(TblestockSectorDetails tblSSD){
        Session session = sessionFactory.getCurrentSession();
        int id = (int) session.save(tblSSD);
        return id;
    }
    
    @Override
    public int addTbltemp_buy_sell(Tbltemp_buy_sell tblTBS){
        Session session = sessionFactory.getCurrentSession();
        int id = (int) session.save(tblTBS);
        return id;
    }
    
    @Override
    public List<TblestockSectorDetails> getSSDS() {
        List<TblestockSectorDetails> lst = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "from TblestockSectorDetails";
            Query query = session.createQuery(hql);
            lst = query.list();

            System.out.println("*******************  "+lst.get(0).getStockAmount());
           // session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    } 
    
    @Override
    public TblestockSectorDetails getSSDbyId(int id)
    {
        TblestockSectorDetails tblSSD = null;
        
        try {
             Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
             
        
        tblSSD = (TblestockSectorDetails) session.get(TblestockSectorDetails.class, id);
        System.out.println("*******11 : "+ tblSSD.getStockID_fk());
        
        //session.getTransaction().commit();
        //session.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
       
        
        return tblSSD;
    }
    
    @Override
    public List<Tbltemp_buy_sell> gettempBuySellDS() {
        List<Tbltemp_buy_sell> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "from Tbltemp_buy_sell";
            Query query = session.createQuery(hql);
            lst = query.list();
            
            System.out.println("1111111 : "+lst.get(0).getStockAmount());

            //session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    } 
    
    @Override
    public Tbltemp_buy_sell getTBSById(int id)
    {
        Tbltemp_buy_sell tblTBS = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
       // session.beginTransaction();
        
        tblTBS = (Tbltemp_buy_sell) session.get(Tbltemp_buy_sell.class, id);
        System.out.println("is Buy : "+tblTBS.getIsBuy());
        
        //session.getTransaction().commit();
        //session.close();
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        
        return tblTBS;
    }
    
      
    //*****************************************
    
    
    @Override
    public List<TblestockSectorDetails> getStocksBySID(int sid) 
    {
        List<TblestockSectorDetails> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            int secID = sid;
            String sql = "SELECT * FROM tblestock_sector_details WHERE sectorId_fk LIKE :sectorID";
            
            Query query = session.createSQLQuery(sql).addEntity(TblestockSectorDetails.class);
            
            query.setString("sectorID", "%" + secID + "%"); 
            lst = query.list();
              
            
            System.out.println(lst.get(1).getStockID_fk());

            //session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    
    @Override
    public void updateSSD(TblestockSectorDetails tblssd) 
    {
       // update stock_sector_details table from sector id and stock id
        try {
            Session session = sessionFactory.getCurrentSession();

            int id = tblssd.getId();
            int secID = tblssd.getSectorId_fk();
            int stockID = tblssd.getStockID_fk();
            Double CRate = tblssd.getCurrentRate();
            int SAmount = tblssd.getStockAmount();
            
           
            //String sql = "UPDATE tblestock_sector_details SET currentRate=:cRate, sectorId_fk=:sectorID, stockAmount=:sAmount, stockID_fk=:stockID WHERE stockID_fk=:stockID AND sectorId_fk=:sectorID";
            String sql = "UPDATE tblestock_sector_details SET currentRate LIKE :cRate, sectorId_fk LIKE :sectorID, stockAmount LIKE :sAmount, stockID_fk LIKE :stockID WHERE stockID_fk LIKE :stockID AND sectorId_fk LIKE :sectorID";
            
            Query query = session.createSQLQuery(sql).addEntity(TblestockSectorDetails.class);
            query.setString("cRate", "%" + CRate + "%");
            query.setString("sAmount", "%" + SAmount + "%");
            query.setString("sectorID", "%" + secID + "%");
            query.setString("stockID", "%" + stockID + "%");
            //query.setString("ID", "%" + id + "%");

            //lst = query.list();
           
            query.executeUpdate();
        
            //session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // return tblssd;
    }
    
        //*****************************************
    
    
   
    
        
    
    
    
    @Override
    public List<Tblsector> getAllSectors() {
        List<Tblsector> lst = null;
        
        try {
           
            Session session = sessionFactory.getCurrentSession();
            String hql = "from Tblsector";
            Query query = session.createQuery(hql);
            lst = query.list();

            System.out.println(lst);
           // session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    } 
    
    
    @Override
    public Tblstock getStockById(int id)
    {
        Tblstock tblStock = null;
        
        try {
             Session session = sessionFactory.getCurrentSession();
        
        tblStock = (Tblstock) session.get(Tblstock.class, id);
        System.out.println("*******11 : "+ tblStock.getStockName());
        
        //session.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
       
        
        return tblStock;
    } 
    
    //
      
    @Override
    public List<Tbltemp_buy_sell> getTempBuySellByUID(int uid) {
        List<Tbltemp_buy_sell> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            int userID = uid;
            String sql = "SELECT * FROM tbltemp_buy_sell WHERE userId_fk LIKE :userID";
            Query query = session.createSQLQuery(sql).addEntity(Tbltemp_buy_sell.class);
            query.setString("userID", "%" + userID + "%"); 
            lst = query.list();
            

                        System.out.println(lst.get(0).getStockAmount());

            //session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
}
