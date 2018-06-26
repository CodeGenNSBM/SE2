/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.dao.BrokerDAO;
import com.codegen.dao.PersonDAO;
import com.codegen.model.Person;
import com.codegen.model.TblestockSectorDetails;
import com.codegen.model.Tblsector;
import com.codegen.model.Tblstock;
import com.codegen.model.Tbltemp_buy_sell;
import com.codegen.utility.SectorStockDetail;
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
public class BrokerServiceImpl implements BrokerService{
    
    @Autowired
    private BrokerDAO brokerdao;
    
    
    @Override
    public int addStock(Tblstock tblstock) {
        return brokerdao.addStock(tblstock);
    }
    
    @Override
    public int addSector(Tblsector tblsector){
        return brokerdao.addSector(tblsector);
    }
    
    @Override
    public int addTblStock_sector_details(TblestockSectorDetails tblSSD){
        return brokerdao.addTblStock_sector_details(tblSSD);
    }
    
    @Override
    public int addTbltemp_buy_sell(Tbltemp_buy_sell tblTBS){
        return brokerdao.addTbltemp_buy_sell(tblTBS);
    }
    
    @Override
    public List<TblestockSectorDetails> getSSDS(){
        return brokerdao.getSSDS();
    }
    
    @Override
    public TblestockSectorDetails getSSDbyId(int id){
        return brokerdao.getSSDbyId(id);
    }
    
    @Override
    public List<Tbltemp_buy_sell> gettempBuySellDS(){
        return brokerdao.gettempBuySellDS();
    }
    
    @Override
    public Tbltemp_buy_sell getTBSById(int id){
        return brokerdao.getTBSById(id);
    }
    
    
       
    @Override
    public List<TblestockSectorDetails> getStocksBySID(int sid){
        return brokerdao.getStocksBySID(sid);
    }
    
    @Override
    public void updateSSD(TblestockSectorDetails tblssd){
         brokerdao.updateSSD(tblssd);
    }  
   
    
        
    @Override
    public List<Tblsector> getAllSectors(){
        return brokerdao.getAllSectors();
    }
    
    @Override
    public Tblstock getStockById(int id){
        return brokerdao.getStockById(id);
    }
    
     @Override
    public List<Tbltemp_buy_sell> getTempBuySellByUID(int uid){
        return brokerdao.getTempBuySellByUID(uid);
    }
      @Override
    public List<SectorStockDetail> getSSDSWithJoin(int sectorID){
        return brokerdao.getSSDSWithJoin(sectorID);
    }
}
