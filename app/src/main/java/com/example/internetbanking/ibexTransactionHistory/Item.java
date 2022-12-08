package com.example.internetbanking.ibexTransactionHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {


    @SerializedName("transac_no")
    @Expose
    private String transacNo;
    @SerializedName("acc_no")
    @Expose
    private String accNo;
    @SerializedName("gl_acc_no")
    @Expose
    private String glAccNo;
    @SerializedName("tran_date")
    @Expose
    private String tranDate;
    @SerializedName("tran_amt")
    @Expose
    private String tranAmt;
    @SerializedName("new_bal")
    @Expose
    private String newBal;
    @SerializedName("particular")
    @Expose
    private String particular;


    public Item(String transacNo, String accNo, String glAccNo, String tranDate, String tranAmt, String newBal, String particular) {
        this.transacNo = transacNo;
        this.accNo = accNo;
        this.glAccNo = glAccNo;
        this.tranDate = tranDate;
        this.tranAmt = tranAmt;
        this.newBal = newBal;
        this.particular = particular;
    }

    public String getTransacNo() {
        return transacNo;
    }

    public void setTransacNo(String transacNo) {
        this.transacNo = transacNo;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getGlAccNo() {
        return glAccNo;
    }

    public void setGlAccNo(String glAccNo) {
        this.glAccNo = glAccNo;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(String tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getNewBal() {
        return newBal;
    }

    public void setNewBal(String newBal) {
        this.newBal = newBal;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }
}
