/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.dao.PersonDAO;
import com.codegen.dao.UserDAO;
import com.codegen.model.Person;
import com.codegen.model.TblestockSectorDetails;
import com.codegen.model.Tbluser;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vishwa
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userdao;
    
    
    @Override
    public int addUser(Tbluser user) {
        return userdao.addUser(user);
    }
    
    
    @Override
    public  Tbluser getById(int id){
        return userdao.getById(id);
    }
    
    @Override
    public List<Tbluser> getAllDS(){
        return userdao.getAllDS();
    }
    
    @Override
    public List<Tbluser> getByName(String name){ 
        return userdao.getByName(name); 
    }
    
    @Override
    public List<Tbluser> getByUName(String uname){
        return userdao.getByUName(uname);
    }
    
    @Override
    public  Tbluser updateByID(Tbluser tblUser){
        return userdao.updateByID(tblUser);
    }
    
    @Override
    public int deleteById(int id){
        return userdao.deleteById(id);
    }
    
    
    
}
