/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.model.TblestockSectorDetails;
import com.codegen.model.Tblsector;
import com.codegen.model.Tblstock;
import com.codegen.model.Tbltemp_buy_sell;
import com.codegen.utility.SectorStockDetail;
import java.util.List;

/**
 *
 * @author Vishwa
 */
public interface BrokerService {
    
    public int addStock(Tblstock tblstock);
    public int addSector(Tblsector tblsector);
    public int addTblStock_sector_details(TblestockSectorDetails tblSSD);
    public int addTbltemp_buy_sell(Tbltemp_buy_sell tblTBS);
    public List<TblestockSectorDetails> getSSDS();
    public TblestockSectorDetails getSSDbyId(int id);
    public List<Tbltemp_buy_sell> gettempBuySellDS();
    public Tbltemp_buy_sell getTBSById(int id);
     public List<TblestockSectorDetails> getStocksBySID(int sid);
    public void updateSSD(TblestockSectorDetails tblssd);
   
        
    public List<Tblsector> getAllSectors();
    public Tblstock getStockById(int id);
    public List<Tbltemp_buy_sell> getTempBuySellByUID(int uid);
    public List<SectorStockDetail> getSSDSWithJoin(int sectorID);
}
