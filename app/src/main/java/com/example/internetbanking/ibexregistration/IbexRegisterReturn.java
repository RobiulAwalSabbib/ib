package com.example.internetbanking.ibexregistration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IbexRegisterReturn {

    @SerializedName("SUCCESS_MSG")
    @Expose
    private String successMsg;

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }
}
