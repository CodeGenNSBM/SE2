/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.service;

import com.codegen.dao.BankTransactionDAO;
import com.codegen.model.BankTransaction;
import java.util.Date;
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
public class BankTransactionServiceImpl implements BankTransactionService{
    @Autowired
    private BankTransactionDAO bank_transactiondao;
    
    @Override
    public BankTransaction getById(int id){
        return bank_transactiondao.getById(id);
    }
    
    @Override
    public List<BankTransaction> getBankTransaction(BankTransaction tblTemp){
        return bank_transactiondao.getBankTransaction(tblTemp);
    }
            
    @Override
    public int deleteBankTransaction(int playerID){
        return bank_transactiondao.deleteBankTransaction(playerID);
    }
    
    @Override
    public int addBankTransaction(BankTransaction bank_transaction){
        return bank_transactiondao.addBankTransaction(bank_transaction);
    }
    
    @Override
    public BankTransaction updateBankTransaction(BankTransaction bank_transaction){
        return bank_transactiondao.updateBankTransaction(bank_transaction);
    }
    
    @Override
    public BankTransaction deleteBankTransaction(BankTransaction bank_transaction){
        return bank_transactiondao.deleteBankTransaction(bank_transaction);
    }
}
