package com.codegen.model;
// Generated May 26, 2018 2:32:35 PM by Hibernate Tools 4.3.1
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * BankTransaction generated by hbm2java
 */
@Entity
@Table(name = "bank_transaction")
public class BankTransaction  implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "player_Id")
    private int playerId;
    
    @Column(name = "amount")
    private double amount;
    
    @Column(name = "transfer_Date")
    private Date transferDate;
    
    @Column(name = "type")
    private int type;
    
    @Column(name = "is_Success")
    private boolean isSuccess;
     
    @Column(name = "is_Active")
    private boolean isActive;
     
    @Column(name = "receiver_OR_sender")
    private String receiverOrSender;
    
    @Column(name = "active_Date")
    private Date activeDate;

    public BankTransaction() {
    }

	
    public BankTransaction(int playerId, double amount, Date transferDate, int type, boolean isSuccess, boolean isActive) {
        this.playerId = playerId;
        this.amount = amount;
        this.transferDate = transferDate;
        this.type = type;
        this.isSuccess = isSuccess;
        this.isActive = isActive;
    }
    public BankTransaction(int playerId, double amount, Date transferDate, int type, boolean isSuccess, boolean isActive, String receiverOrSender, Date activeDate) {
       this.playerId = playerId;
       this.amount = amount;
       this.transferDate = transferDate;
       this.type = type;
       this.isSuccess = isSuccess;
       this.isActive = isActive;
       this.receiverOrSender = receiverOrSender;
       this.activeDate = activeDate;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getPlayerId() {
        return this.playerId;
    }
    
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Date getTransferDate() {
        return this.transferDate;
    }
    
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }
    public int getType() {
        return this.type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    public boolean isIsSuccess() {
        return this.isSuccess;
    }
    
    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
    public boolean isIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getReceiverOrSender() {
        return this.receiverOrSender;
    }
    
    public void setReceiverOrSender(String receiverOrSender) {
        this.receiverOrSender = receiverOrSender;
    }
    public Date getActiveDate() {
        return this.activeDate;
    }
    
    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}


