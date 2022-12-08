package com.example.internetbanking.ibexregistration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestJsonDataModel {

    @SerializedName("REQINFO")
    @Expose
    private Reqinfo reqinfo;

    public RequestJsonDataModel(Reqinfo reqinfo) {
        this.reqinfo = reqinfo;
    }

    public RequestJsonDataModel() {

    }

    public Reqinfo getReqinfo() {
        return reqinfo;
    }

    public void setReqinfo(Reqinfo reqinfo) {
        this.reqinfo = reqinfo;
    }

}
