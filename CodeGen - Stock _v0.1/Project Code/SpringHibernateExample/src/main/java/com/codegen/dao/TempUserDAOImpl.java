/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.dao;

import com.codegen.model.TblTempUser;
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
public class TempUserDAOImpl implements TempUserDAO {
    
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public int addTempUser(TblTempUser tuser) {
        Session session = sessionFactory.getCurrentSession();
        //session.save(tuser);
        session.saveOrUpdate(tuser);
        System.out.println("Add user Done");
        return 0;
       
    }
    
    
    @Override
    public List<TblTempUser> getIsPlay(int status) {
        List<TblTempUser> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            int isPlay = status;
            String sql = "SELECT * FROM tbl_temp_user WHERE isPlay LIKE :IsPlay";
            Query query = session.createSQLQuery(sql).addEntity(TblTempUser.class);
            query.setString("IsPlay", "%" + isPlay + "%"); // again, the leading wild card may be a problem
            lst = query.list();
            
            System.out.println(lst.get(0).getId());

            //session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    
   @Override
    public int deleteById(String name) {
        try{
            Session session = sessionFactory.getCurrentSession();
            String hql = "delete TblTempUser where Name =:player_name";

            Query query = session.createQuery(hql);
            query.setParameter("player_name", name);
            query.executeUpdate();
        
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
            return 0;
    }
    
    
    @Override
    public int updateIsPlayByPId(int isPlay, String pname) {
        System.out.println("entered");
        //Tbluser tblUser = null;
        try{
            Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();

       
            String hql = "update TblTempUser set isPlay =:is_play where name =:player_name";

            Query query = session.createQuery(hql);
            query.setParameter("is_play", isPlay);
            query.setParameter("player_name", pname);

            query.executeUpdate();
        
        
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
            return 0;
    }

    
}
