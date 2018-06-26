/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codegen.dao;
import com.codegen.model.BankTransaction;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Ayesh
 */
public interface BankTransactionDAO {
    public  BankTransaction getById(int id);
    public List<BankTransaction> getBankTransaction(BankTransaction tblTemp);
    public int deleteBankTransaction(int playerID);
    
    /////
    
    public int addBankTransaction(BankTransaction bank_transaction);
    public BankTransaction updateBankTransaction(BankTransaction bank_transaction);
    public BankTransaction deleteBankTransaction(BankTransaction bank_transaction);
}
