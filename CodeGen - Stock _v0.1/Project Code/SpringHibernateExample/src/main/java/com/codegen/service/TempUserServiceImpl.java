/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.dao.TempUserDAO;
import com.codegen.dao.UserDAO;
import com.codegen.model.TblTempUser;
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
public class TempUserServiceImpl implements TempUserService {
    
     @Autowired
    private TempUserDAO tuserdao;
     
     @Override
    public int addTempUser(TblTempUser tuser) {
        return tuserdao.addTempUser(tuser);
    }
    
    @Override
    public List<TblTempUser> getIsPlay(int status){
        return tuserdao.getIsPlay(status);
    }
    
    @Override
    public int deleteById(String name){
        return tuserdao.deleteById(name);
    }
    
    @Override
    public int updateIsPlayByPId(int isPlay, String pname){
        return tuserdao.updateIsPlayByPId(isPlay, pname);
    }
    
}
