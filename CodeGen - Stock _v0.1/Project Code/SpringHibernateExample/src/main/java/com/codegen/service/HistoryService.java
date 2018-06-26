/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.model.TblHistory;
import java.util.List;

/**
 *
 * @author Vishwa
 */
public interface HistoryService {
    
    public int addData(TblHistory history);
    public List<TblHistory> getBySectName(String sectname);
    public List<TblHistory> getByStkName(String stkname);
    
}
