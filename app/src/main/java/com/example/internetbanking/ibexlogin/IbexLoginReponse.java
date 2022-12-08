package com.example.internetbanking.ibexlogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IbexLoginReponse {


    @SerializedName("SUCCESS")
    @Expose
    private String success;
    @SerializedName("ACC_NO")
    @Expose
    private String accNo;
    @SerializedName("ACC_NAME")
    @Expose
    private String accName;
    @SerializedName("BU_CODE")
    @Expose
    private String buCode;
    @SerializedName("UNIT_CODE")
    @Expose
    private String unitCode;
    @SerializedName("USERTYPE")
    @Expose
    private String usertype;
    @SerializedName("CHANGE_PASS_ON_NEXT_LOGIN")
    @Expose
    private String changePassOnNextLogin;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("USER_ID")
    @Expose
    private String userId;
    @SerializedName("Parent_Menu_Code")
    @Expose
    private String parentMenuCode;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getBuCode() {
        return buCode;
    }

    public void setBuCode(String buCode) {
        this.buCode = buCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getChangePassOnNextLogin() {
        return changePassOnNextLogin;
    }

    public void setChangePassOnNextLogin(String changePassOnNextLogin) {
        this.changePassOnNextLogin = changePassOnNextLogin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentMenuCode() {
        return parentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        this.parentMenuCode = parentMenuCode;
    }

}
