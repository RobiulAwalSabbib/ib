package com.example.internetbanking.ibexregistration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDataM {

    @SerializedName("acc_no")
    @Expose
    private String accNo;
    @SerializedName("acc_name")
    @Expose
    private String accName;
    @SerializedName("curr_bal")
    @Expose
    private Double currBal;
    @SerializedName("avail_bal")
    @Expose
    private Double availBal;
    @SerializedName("mailing_address")
    @Expose
    private String mailingAddress;
    @SerializedName("acc_status")
    @Expose
    private String accStatus;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("fathers_name")
    @Expose
    private String fathersName;
    @SerializedName("mothers_name")
    @Expose
    private String mothersName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("cust_id")
    @Expose
    private String custId;
    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_group_code")
    @Expose
    private String productGroupCode;
    @SerializedName("product_group_name")
    @Expose
    private String productGroupName;
    @SerializedName("product_group_type")
    @Expose
    private String productGroupType;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("product_master_name")
    @Expose
    private String productMasterName;
    @SerializedName("success")
    @Expose
    private String success;

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

    public Double getCurrBal() {
        return currBal;
    }

    public void setCurrBal(Double currBal) {
        this.currBal = currBal;
    }

    public Double getAvailBal() {
        return availBal;
    }

    public void setAvailBal(Double availBal) {
        this.availBal = availBal;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductGroupCode() {
        return productGroupCode;
    }

    public void setProductGroupCode(String productGroupCode) {
        this.productGroupCode = productGroupCode;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public String getProductGroupType() {
        return productGroupType;
    }

    public void setProductGroupType(String productGroupType) {
        this.productGroupType = productGroupType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductMasterName() {
        return productMasterName;
    }

    public void setProductMasterName(String productMasterName) {
        this.productMasterName = productMasterName;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
