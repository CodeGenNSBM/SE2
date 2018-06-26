/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.dao;

import com.codegen.model.TblHistory;
import com.codegen.model.Tbluser;
import java.util.List;
import javax.transaction.Transactional;
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
public class HistoryDAOImpl implements HistoryDAO {
    
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public int addData(TblHistory history) {
        
        Session session = sessionFactory.getCurrentSession();
        int id = (int) session.save(history);
        return id;
       

    }
    
    @Override
    public List<TblHistory> getBySectName(String sectname) {
        List<TblHistory> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            String sectorName = sectname;
            String sql = "SELECT * FROM tblhistory WHERE sectorName LIKE :SectName";
            Query query = session.createSQLQuery(sql).addEntity(TblHistory.class);
            query.setString("SectName", "%" + sectorName + "%"); // again, the leading wild card may be a problem
            lst = query.list();
            

            System.out.println("0000000000*********************************************");
            System.out.println(lst.get(0).getCprice());

           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    @Override
    public List<TblHistory> getByStkName(String stkname) {
        List<TblHistory> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            String stockName = stkname;
            String sql = "SELECT * FROM tblhistory WHERE stockName LIKE :StkName";
            Query query = session.createSQLQuery(sql).addEntity(TblHistory.class);
            query.setString("StkName", "%" + stockName + "%"); // again, the leading wild card may be a problem
            lst = query.list();
            

            System.out.println("0000000000*********************************************");
            System.out.println(lst.get(0).getSectname());

           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
}
