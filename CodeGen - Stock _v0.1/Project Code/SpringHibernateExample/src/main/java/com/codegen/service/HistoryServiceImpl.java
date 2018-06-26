/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.dao.HistoryDAO;
import com.codegen.dao.UserDAO;
import com.codegen.model.TblHistory;
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
public class HistoryServiceImpl implements HistoryService{
    
     @Autowired
    private HistoryDAO historydao;
     
     @Override
     public int addData(TblHistory history){
         return historydao.addData(history);
     }
     
     @Override
     public List<TblHistory> getBySectName(String sectname){
         return historydao.getBySectName(sectname);
     }
     
     @Override
     public List<TblHistory> getByStkName(String stkname){
         return historydao.getByStkName(stkname);
     }
    
}
