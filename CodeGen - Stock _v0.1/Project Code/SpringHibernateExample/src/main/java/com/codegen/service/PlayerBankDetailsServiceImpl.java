/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.dao.PlayerBankDetailsDAO;
import com.codegen.model.PlayerBankDetails;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ayesh
 */
@Service
@Transactional
public class PlayerBankDetailsServiceImpl implements PlayerBankDetailsService{
    @Autowired
    private PlayerBankDetailsDAO player_bank_detailsdao;
    
    @Override
    public PlayerBankDetails getById(int id){
        return player_bank_detailsdao.getById(id);
    }
    
    @Override
    public List<PlayerBankDetails> getPlayerBankDetail(PlayerBankDetails _obj){
        return player_bank_detailsdao.getPlayerBankDetail(_obj);
    }
            
    @Override
    public int deletePlayerBankDetail(int playerID){
        return player_bank_detailsdao.deletePlayerBankDetail(playerID);
    }
    
    /////
    
    @Override
    public int addPlayerBankDetails(PlayerBankDetails player_bank_details){
        return player_bank_detailsdao.addPlayerBankDetails(player_bank_details);
    }
    
    @Override
    public PlayerBankDetails updatePlayerBankDetails(PlayerBankDetails player_bank_details){
        return player_bank_detailsdao.updatePlayerBankDetails(player_bank_details);
    }
    
    @Override
    public PlayerBankDetails deletePlayerBankDetails(PlayerBankDetails player_bank_details){
        return player_bank_detailsdao.deletePlayerBankDetails(player_bank_details);
    }
    
    ////
    @Override
    public List<PlayerBankDetails> getPlayerBankDetailsByPId(int pid){
        return player_bank_detailsdao.getPlayerBankDetailsByPId(pid);
    }
    
    @Override
    public int updateCashByPId(double cash, int pid){
        return player_bank_detailsdao.updateCashByPId(cash, pid);
    }
}
