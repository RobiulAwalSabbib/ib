package com.example.internetbanking.ibexregistration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reqinfo {


    @SerializedName("ACC_NO")
    @Expose
    private String accNo;

    public Reqinfo(String accNo) {
        this.accNo = accNo;
    }

    public Reqinfo() {

    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

}
