package com.example.internetbanking.retrofit;

import com.example.internetbanking.ibexTransactionHistory.TransactionHistoryModel;
import com.example.internetbanking.ibexlogin.IbexLoginReponse;
import com.example.internetbanking.ibexregistration.IbexRegisterReturn;
import com.example.internetbanking.ibexregistration.ResponseDataM;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    //    @FormUrlEncoded
//    @POST("LoginApi")
//    Single<LoginDataM> getLogin(
//
//            @Field("user_id") String user_id,
//            @Field("user_password") String user_password
//    );


//    @FormUrlEncoded
//    @POST("LoginPostApi")
//    Single<LoginDataM> postLogin(
//
//            @Field("user_id") String user_id,
//            @Field("user_password") String user_password,
//            @Field("user_name") String user_name
//    );

//
//    @FormUrlEncoded
//    @POST("CreateUserS")
//    Single<CustomerDataM> postCustomerRequest(
//
//            @Field("custid") String custid,
//            @Field("dob") String dob
//    );

//    @FormUrlEncoded
//    @POST("StatementS")
//    List<StatementDataM> getAllStatement(
//            @Field("acNo") StatementReqM acNo
//    );

//
//    @POST("StatementS?acNo=A00001")
//    Call<List<StatementDataM>> getAllStatement(
//
//    );


//
//    @FormUrlEncoded
//    @POST("StatementS?acNo=A00001")
//    List<StatementDataM> getAllStatement2();


//    @GET("LoginApi")
//    Single<LoginDataM> getLogin(
//
//            @Query("user_id") String user_id,
//            @Query("user_password") String user_password
//    );

//    @FormUrlEncoded
//    @POST("Customer")
//    Single<CustomerDataM> customer_registration(
//            @Field("customer_id") String customer_id,
//            @Field("customer_name") String customer_name,
//            @Field("customer_mobile") String customer_mobile,
//            @Field("customer_father_name") String customer_father_name,
//            @Field("customer_mother_name") String customer_mother_name,
//            @Field("customer_dob") String customer_dob,
//            @Field("branch_id") String branch_id,
//            @Field("customer_nid") String customer_nid
//    );

//    @FormUrlEncoded
//    @POST("AG_Customer_Api")
//    Single<AGCustomerRecM> postAGcustomer(
//
//            @Field("cust_id") String cust_id,
//            @Field("cust_name") String cust_name,
//            @Field("cust_gender") String cust_gender,
//            @Field("cust_dob") String cust_dob
//    );
//
//
//    @POST("Ag_Customer_Getall_Data_Api")
//    Single<List<AGCustomerGetAllDataM>> getAGcustomerAllData();
//
//
//
//    @FormUrlEncoded
//    @POST("Transaction_Post_Api")
//    Single<Transaction_Post_Receive_Model> postTransaction(
//
//            @Field("sender_acc") String sender_acc,
//            @Field("receiver_acc") String receiver_acc,
//            @Field("transaction_amount") String transaction_amount,
//            @Field("transaction_medium") String transaction_medium,
//            @Field("transaction_type") String transaction_type
//    );
//
//
//    @POST("Transaction_Type_Get_All_Data_Api")
//    Single<List<Transaction_Type_Get_All_Data_Return_M>> getTransactionTypeAllData();
//
//
//
//
//
//    @POST("Transaction_Medium_Get_All_Data_Api")
//    Single<List<Transaction_Medium_Get_All_Data_Return_M>> getTransactionMediumAllData();
//
//
//
//    @FormUrlEncoded
//    @POST("StatementS")
//    Single<List<StatementReceiveModel>> getAllStatementData(
//            @Field("acNo") String acNo
//    );
//
//
//    @FormUrlEncoded
//    @POST("Get_Transaction_History_curProcedure_Api")
//    Single<List<Single_Account_DateRange_Record_Receive_Model>> get_Tran_Hist_Single_Acc_Record(
//
//            @Field("acc_no") String acc_no,
//            @Field("from_date") String from_date,
//            @Field("to_date") String to_date
//    );
//
//
//    @FormUrlEncoded
//    @POST("Benificiary_Info_Post_Api")
//    Single<ReturnModel> postBenificierInfo(
//
//            @Field("cust_id") String cust_id,
//            @Field("acc_no") String acc_no,
//            @Field("acc_type") String acc_type,
//            @Field("acc_title") String acc_title
//    );
//
//
//    @FormUrlEncoded
//    @POST("Topup_Request_Post_Api")
//    Single<Recharge_Request_Post_Receive_Data_Model> postRechargeRequest(
//
//            @Field("MOBILE") String MOBILE,
//            @Field("OPERATORS_CODE") String OPERATORS_CODE,
//            @Field("SIM_TYPE_NAME") String SIM_TYPE_NAME,
//            @Field("AMOUNT") String AMOUNT,
//            @Field("RECHARGE_CODE") String RECHARGE_CODE
//    );
//
//
//    @FormUrlEncoded
//    @POST("LoginApi")
//    Single<LoginDataM> getLogin(
//
//            @Field("user_id") String user_id,
//            @Field("user_password") String user_password
//    );
//
//    @POST("Menu_Get_Api")
//    Single<List<ReceiveModel>> getMenuAllData();
//
//
//
//    @FormUrlEncoded
//    @POST("ProfilePicUploadS")
//    Single<ProfileUploadDataM> uploadProfilePic(
//            @Field("id") String id,
//            @Field("image") String image
//    );

//    @FormUrlEncoded
//    @POST("DownloadProfileS")
//    Single<ProfileUploadDataM> getImage(
//            @Field("id") String id
//    );


//    @FormUrlEncoded
//    @POST("Customer_Registration_Api")
//    Single<Customer_Registration_Receive_Model> postCustomerRegistration(
//
//            @Field("applicant_name") String applicant_name,
//            @Field("mobile") String mobile,
//            @Field("email") String email,
//            @Field("dob") String dob,
//            @Field("passwords") String passwords,
//            @Field("confirm_passwords") String confirm_passwords
//    );
//
//    @FormUrlEncoded
//    @POST("Create_Customer_Api")
//    Single<UserInfo_Receive_Model> postUserInfoRegistration(
//
//            @Field("custid") String custid,
//            @Field("dob") String dob
//    );
//
//    @FormUrlEncoded
//    @POST("BillPayApi")
//    Single<BillPayRecM> billpay(
//            @Field("acc_no") String acc_no,
//            @Field("mobile_no") String mobile_no,
//            @Field("billpay__name") String billpay__name,
//            @Field("billpay_type") String billpay_type,
//            @Field("bill_no") String bill_no,
//            @Field("meter_no") String meter_no,
//            @Field("amount") String amount,
//            @Field("pin") String pin
//    );
//
//    @POST("BillPay_Operator_Api")
//    Single<List<BillPay_Operator_RecM>> billpayoperator(
//    );
//
//    @POST("BillPay_Operator_Type_Api")
//    Single<List<BillPay_Operator_Type_RcvM>> billpayoperatortype(
//
//    );
//
//    @POST("BillPay_AccApi")
//    Single<List<BillPay_Acc_RcvM>> billpayacc(
//
//    );
//
//
//
//
//    @FormUrlEncoded
//    @POST("Benificiary_Info_Post_Api")
//    Single<ReturnModel> post_Benificiary_Info(
//
//            @Field("cust_id") String cust_id,
//            @Field("acc_no") String acc_no,
//            @Field("acc_type") String acc_type,
//            @Field("acc_title") String acc_title,
//            @Field("beni_acc_holder_name") String beni_acc_holder_name
//    );
//
//
//    @FormUrlEncoded
//    @POST("Benificiary_Single_Account_Get_Api")
//    Single<List<com.bcl.bexiapp_i_banking.Benificier_Single_Account_Get.ReceiveModel>> get_Benificiary_Single_Acc(
//
//            @Field("acNo") String acNo
//    );
//
//    @FormUrlEncoded
//    @POST("Get_Balance_Api")
//    Single<List<ReceiveDataModel>> getAccountBalance(
//            @Field("acNo") String acNo
//    );


    ////////////////////////// CBS test Api calling /////////////////////////////

    @FormUrlEncoded
    @POST("ibex1/service/api")

    Single<ResponseDataM> getCBSTestApi(

            @Field("vchanl") String vchanl,
            @Field("vreqtyp") String vreqtyp,
            @Field("vuserid") String vuserid,
            @Field("vauthkey") String vauthkey,
            @Field("vchksum") String vchksum,
            @FieldMap Map<String,String> params
            //@Body @Field("vinjdata") RequestJsonDataModel vinjdata
    );
    ////////////////////////////////// porichoy api ///////////////////////
//    @Headers("x-api-key:62ef1921-a1d2-4ee9-ab23-5d41b380f2a4")
//    @POST("nid-person-values")
//    Single<Porichoy> getNidVerification(@Body String request);
//

    ////////////////////////// ibex login ////////////////////////

    @FormUrlEncoded
    @POST("ibanking/login")

    Single<IbexLoginReponse> getIbexLoginApi(

            @Field("user") String user,
            @Field("password") String password
    );



    ////////////////////////// ibex Registration ////////////////////////

    @FormUrlEncoded
    @POST("registration/insert")

    Single<IbexRegisterReturn> getIbexRegistrationApi(


            @Field("acc_no") String acc_no,

            @Field("dob") String dob,
            @Field("email") String email,
            @Field("mobile") String mobile
    );



    ///////////////////////// ibex benificiary type ///////////////////////

    //http://202.84.45.54:9999/bexibank/api/beneficiary-type/description
//
//    @GET("beneficiary-type/description")
//
//        //Single<List<Item>> getIbexBenificiaryType();
//    Single<BenificiaryTypeResponseDataModel> getIbexBenificiaryType();


    ////////////////////////// ibex Beni Otp Send ////////////////////////

//    @FormUrlEncoded
//    @POST("beni-otp/send")
//
//    Single<SendOtpReceiveModel> getBenificiaryOtp(
//
//
//            @Field("APPUSERID") String APPUSERID
//    );


    ////////////////////////// ibex Beni Add ////////////////////////

//    @FormUrlEncoded
//    @POST("benificiary/add")
//
//    Single<IbexRegisterReturn> addBenificiary(
//
//
//
//            @Field("APPUSERID") String APPUSERID,
//            @Field("BEN_TYPE_CODE") String BEN_TYPE_CODE,
//            @Field("BEN_ACC_NO") String BEN_ACC_NO,
//            @Field("NICKNAME") String NICKNAME,
//            @Field("BEN_NAME") String BEN_NAME,
//            @Field("BEN_MOBILE_NO") String BEN_MOBILE_NO,
//            @Field("BEN_EMAIL_ID") String BEN_EMAIL_ID,
//            @Field("OTP_TEXT") String OTP_TEXT
//    );


    ///////////////////////// ibex To AccList ///////////////////////

    //http://202.84.45.54:9999/bexibank/api/to/accList
//
//    @GET("to/accList")
//
//        //Single<List<Item>> getIbexBenificiaryType();
//    Single<ToAccResponseModel> getIbexToAccList(
//
//            @Query("BEN_TYPE_CODE") String BEN_TYPE_CODE,
//            @Query("USERS") String USERS
//    );



    ///////////////////////// ibex From AccList ///////////////////////

    //http://202.84.45.54:9999/bexibank/api/user/accList

//    @GET("user/accList")
//
//
//    Single<FromAccResponseModel> getIbexFromAccList(
//            @Query("USERS") String USERS
//    );

/////////////////////////////////////////////////////////////////////
    ///////////////////////////// ibex ftwb insert log and send otp ////////////

//    @FormUrlEncoded
//    @POST("insertLog/send-OTP")
//
//    Single<IbexRegisterReturn> insert_log_and_send_otp(
//
////http://202.84.45.54:9999/bexibank/api/insertLog/send-OTP
//
//            @Field("ACC_NO") String ACC_NO,
//            @Field("TOACC_NO") String TOACC_NO,
//            @Field("AMOUNT") String AMOUNT,
//            @Field("REMARKS") String REMARKS,
//            @Field("APP_USER") String APP_USER
//    );

    /////////////////////////////////////////////////////////////////////
    ///////////////////////////// fund transfer within Bank ////////////

    ///////////// http://202.84.45.54:9999/bexibank/api/fundTransfer/withinBank

//    @FormUrlEncoded
//    @POST("fundTransfer/withinBank")
//
//    Single<IbexRegisterReturn> fund_transfer_within_Bank(
//
//
//
//            @Field("APP_USER") String APP_USER,
//            @Field("OTP_TEXT") String OTP_TEXT,
//            @Field("FROM_ACC_NO") String FROM_ACC_NO,
//            @Field("AMOUNT") String AMOUNT,
//            @Field("TOACC_NO") String TOACC_NO,
//            @Field("REMARKS") String REMARKS
//    );


    ///////////////////////// ibex Transaction History ///////////////////////

    //http://202.84.45.54:9999/bexibank/api/transaction/history

    @GET("transaction/history")


    Single<TransactionHistoryModel> getIbexTransactionHistory(
            @Query("ACC_NO") String ACC_NO
    );



}
