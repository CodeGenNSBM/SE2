/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.dao;

import com.codegen.model.Person;
import com.codegen.model.Tbluser;
import java.io.Console;
import java.math.BigInteger;
import java.util.List;
import javax.faces.convert.BigIntegerConverter;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vishwa
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int addUser(Tbluser user) {
        System.out.println("Add user Done");
        Session session = sessionFactory.getCurrentSession();
        int id = (int) session.save(user);
        return id;
        //return Integer.valueOf(id.toString());
        //session.save(user);

    }

    /*
    @Override
    public Tbluser getById() {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(Tbluser.class);
        SessionFactory factory = config.configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        String queryString = "from User where id = :id";
        Query query = session.createQuery(queryString);
        query.setInteger("id", 4);
        Object queryResult = query.uniqueResult();
        Tbluser user = (Tbluser) queryResult;
        session.getTransaction().commit();
        return user;
    }
*/

    
     @Override
     public Tbluser getById(int id)
    {
        Tbluser tblUser=null;
        try{
        Session session = sessionFactory.getCurrentSession();
         System.out.println("bbbbbbb ");      
         System.out.println("aaaa");
        tblUser = (Tbluser) session.get(Tbluser.class, id);
        System.out.println("Student name : "+ tblUser.getName());
        //session.close();
        
        }
        catch(Exception x)
        {
            System.out.println(x.toString());
        }
        return tblUser;
    }
    
     
    @Override
    public List<Tbluser> getAllDS() {
        List<Tbluser> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "from Tbluser";
            Query query = session.createQuery(hql);
            lst = query.list();
            
            System.out.println("*******************  "+lst.get(0).getName());

           // session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    @Override
    public List<Tbluser> getByName(String name) 
    {
        List<Tbluser> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            String playerName = name;
            String sql = "SELECT * FROM tbluser WHERE name LIKE :Name";
            Query query = session.createSQLQuery(sql).addEntity(Tbluser.class);
            query.setString("Name", "%" + playerName + "%"); // again, the leading wild card may be a problem
            lst = query.list();

            System.out.println("*********************************************");
            System.out.println(lst.get(0).getUname());

            //session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    @Override
    public List<Tbluser> getByUName(String uname) {
        List<Tbluser> lst = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            String userName = uname;
            String sql = "SELECT * FROM tbluser WHERE userName LIKE :UserName";
            Query query = session.createSQLQuery(sql).addEntity(Tbluser.class);
            query.setString("UserName", "%" + userName + "%"); // again, the leading wild card may be a problem
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
    public Tbluser updateByID(Tbluser tblUser) {
        //Tbluser tblUser = new Tbluser();

        Tbluser tblUser2=null;
        try {
                Session session = sessionFactory.getCurrentSession();
                //Transaction tx = session.beginTransaction();
       
        tblUser2 = (Tbluser) session.get(Tbluser.class, tblUser.getId());
       
        tblUser2.setName(tblUser.getName());
        tblUser2.setPassword(tblUser.getPassword());
        tblUser2.setUname(tblUser.getUname());
        session.update(tblUser2);

        //session.getTransaction().commit();
        //session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return tblUser2;
    }

    
    
    @Override
    public int deleteById(int id) {
        System.out.println("entered");
        //Tbluser tblUser = null;
        try{
            Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();

       
            String hql = "delete Tbluser where id =:player_id";

            Query query = session.createQuery(hql);
            query.setParameter("player_id", id);

            query.executeUpdate();
        
        /*
        tblUser = (Tbluser) session.get(Tbluser.class, id);

        //session.delete(tblUser);
        
        session.delete(tblUser);

        

        System.out.println("Deleted");
        session.getTransaction().commit();
        session.close();

        return 0;//Integer.valueOf(flag.toString());
        //return tblUser;
                */
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
            return 0;
    }
    
    

}
