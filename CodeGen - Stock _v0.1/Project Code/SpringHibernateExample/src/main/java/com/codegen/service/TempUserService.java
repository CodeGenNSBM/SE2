/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.model.TblTempUser;
import java.util.List;

/**
 *
 * @author Vishwa
 */
public interface TempUserService {
    
    public int addTempUser(TblTempUser tuser);
    public List<TblTempUser> getIsPlay(int status);
    public int deleteById(String name);
    
    public int updateIsPlayByPId(int isPlay, String pname);
}
