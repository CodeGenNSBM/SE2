/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.dao;
import com.codegen.model.BankTransaction;
import com.codegen.model.PlayerBankDetails;
import java.util.List;
/**
 *
 * @author Ayesh
 */
public interface PlayerBankDetailsDAO {
    public  PlayerBankDetails getById(int id);
    public List<PlayerBankDetails> getPlayerBankDetail(PlayerBankDetails _obj);
    public int deletePlayerBankDetail(int playerID);
    
    /////
    
    public int addPlayerBankDetails(PlayerBankDetails player_bank_details);
    public PlayerBankDetails updatePlayerBankDetails(PlayerBankDetails player_bank_details);
    public PlayerBankDetails deletePlayerBankDetails(PlayerBankDetails player_bank_details);
    
    /////
    
    public List<PlayerBankDetails> getPlayerBankDetailsByPId(int pid);
    public int updateCashByPId(double cash, int pid);
    
}
