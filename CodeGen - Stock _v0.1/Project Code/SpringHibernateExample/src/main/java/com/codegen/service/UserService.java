/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.model.Tbluser;
import java.util.List;

/**
 *
 * @author Vishwa
 */
public interface UserService {
    
    public int addUser(Tbluser user);
    public  Tbluser getById(int id);
    public List<Tbluser> getAllDS();
    public List<Tbluser> getByName(String name); 
    public List<Tbluser> getByUName(String uname);
    public  Tbluser updateByID(Tbluser tblUser);
    public int deleteById(int id);
    

   
    
}
