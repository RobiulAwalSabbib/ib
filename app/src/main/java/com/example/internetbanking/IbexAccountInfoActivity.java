package com.example.internetbanking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.internetbanking.ibexregistration.Reqinfo;
import com.example.internetbanking.ibexregistration.RequestJsonDataModel;
import com.example.internetbanking.ibexregistration.ResponseDataM;
import com.example.internetbanking.retrofit.ApiClient;
import com.example.internetbanking.retrofit.ApiService;
import com.example.internetbanking.util.CustomAlert;
import com.example.internetbanking.util.ErrorUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class IbexAccountInfoActivity extends AppCompatActivity {

    //TextView et_ibex_accNo;
    SharedPreferences logindata;

    TextView tv_accNo,tv_accName,tv_curr_bal,tv_avail_bal,tv_mailing_address,tv_acc_status,tv_dob,tv_father_name,tv_mother_name,tv_email;
    TextView tv_mobile,tv_cutsID,tv_product_code,tv_product_name,tv_product_group_code,tv_product_group_name,tv_product_group_type;
    TextView tv_product_id,tv_product_master_name,tv_success;

    //Network call
    private ApiService apiService;
    private CompositeDisposable disposable = new CompositeDisposable();
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibex_account_info);



        ////////////////// get Shared Preference ///////////////////////////
        logindata = getSharedPreferences("logindata",MODE_PRIVATE);

        /////////////////// view initialization //////////////////////////

        tv_accNo = findViewById(R.id.tv_accNo);
        tv_accName = findViewById(R.id.tv_accName);
        tv_curr_bal = findViewById(R.id.tv_curr_bal);
        tv_avail_bal = findViewById(R.id.tv_avail_bal);
        tv_mailing_address = findViewById(R.id.tv_mailing_address);
        tv_acc_status = findViewById(R.id.tv_acc_status);
        tv_dob = findViewById(R.id.tv_dob);
        tv_father_name = findViewById(R.id.tv_father_name);
        tv_mother_name = findViewById(R.id.tv_mother_name);
        tv_email = findViewById(R.id.tv_email);
        tv_mobile = findViewById(R.id.tv_mobile);
        tv_cutsID = findViewById(R.id.tv_cutsID);
        tv_product_code = findViewById(R.id.tv_product_code);
        tv_product_name = findViewById(R.id.tv_product_name);
        tv_product_group_code = findViewById(R.id.tv_product_group_code);
        tv_product_group_name = findViewById(R.id.tv_product_group_name);
        tv_product_group_type = findViewById(R.id.tv_product_group_type);
        tv_product_id = findViewById(R.id.tv_product_id);
        tv_product_master_name = findViewById(R.id.tv_product_master_name);
        tv_success = findViewById(R.id.tv_success);



        //////////////////////// network call initialization ////////////////////////////
        //Network call
        apiService = ApiClient.getExternalApiService(getApplicationContext());
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please waite..");


        String accNo = logindata.getString("acNo","");
        //Log.e("acc", accNo);
        //String accNo = intent.getStringExtra("acNo");
        //et_ibex_accNo = findViewById(R.id.et_ibex_accNo);
        //et_ibex_accNo.setText(accNo);



        //////////////////////////////////// set account and convert to json and map it ////////////////////////////////////


//        Reqinfo reqinfo = new Reqinfo();
//        reqinfo.setAccNo(accNo);

        RequestJsonDataModel jsonDataModel = new RequestJsonDataModel();
        Reqinfo reqinfo = new Reqinfo();
        reqinfo.setAccNo(accNo);
        jsonDataModel.setReqinfo(reqinfo);
        String request=new Gson().toJson(jsonDataModel);

        //Here the json data is add to a hash map with key data
        Map<String,String> params = new HashMap<String, String>();
        params.put("vinjdata", request);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////// get account info from cbs ///////////////////////////
        get_cbsApiAccInfo("BEFTN","01","ATM001","OTHER2ATM","123456",params);



    }


    private void get_cbsApiAccInfo(String beftn, String s, String atm001, String other2ATM, String s1,  Map<String, String> params){

        disposable.add(
                (Disposable) apiService

                        //change 1
                        //.getCBSTestApi(beftn,s,atm001,other2ATM,s1,params)
                        .getCBSTestApi("BEFTN","01","ATM001","OTHER2ATM","123456",params)


                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<ResponseDataM>() {//change 2
                            @Override
                            public void onSuccess( ResponseDataM recM ) {//change 3

                                pDialog.dismiss();

                                //change 4
                                //Receive Topup Result  Result
                                if (recM.getSuccess().equals("1")) {
                                    //Successful

                                    tv_accNo.setText(recM.getAccNo());
                                    tv_accName.setText(recM.getAccName());
                                    tv_curr_bal.setText(String.valueOf(recM.getCurrBal()));
                                    tv_avail_bal.setText(String.valueOf(recM.getAvailBal()));
                                    tv_mailing_address.setText(recM.getMailingAddress());
                                    tv_acc_status.setText(recM.getAccStatus());
                                    tv_dob.setText(recM.getDob());
                                    tv_father_name.setText(recM.getFathersName());
                                    tv_mother_name.setText(recM.getMothersName());
                                    tv_email.setText(recM.getEmail());
                                    tv_mobile.setText(recM.getMobile());
                                    tv_cutsID.setText(recM.getCustId());
                                    tv_product_code.setText(recM.getProductCode());
                                    tv_product_name.setText(recM.getProductName());
                                    tv_product_group_code.setText(recM.getProductGroupCode());
                                    tv_product_group_name.setText(recM.getProductGroupName());
                                    tv_product_group_type.setText(recM.getProductGroupType());
                                    tv_product_id.setText(recM.getProductId());
                                    tv_product_master_name.setText(recM.getProductMasterName());
                                    tv_success.setText(recM.getSuccess());


//                                    Notification notification = new NotificationCompat.Builder(TopupRequestActivity.this, CHANNEL_1_ID)
//                                            .setSmallIcon(R.drawable.alert_icon)
//                                            .setContentTitle(recM.getpErrorFlag())
//                                            .setContentText(recM.getpErrorMessage())
//                                            .setPriority(NotificationCompat.PRIORITY_HIGH)
//                                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                                            .build();
//                                    notificationManager.notify(1, notification);


//                                    session.edit().putString("user_id", reqM.getUser_id()).commit();
//                                    session.edit().putString("session_id", "039248098").commit();
//                                    session.edit().putString("user_type", "ADMIN").commit();
//                                    session.edit().putString("user_mobile", "093284098").commit();
//                                    session.edit().putString("user_name", loginResult.user_name).commit();

                                    // new CustomAlert().showSuccessMessage(IbexAccountInfoActivity.this, "", "Api Calling Successfully !");
                                    //Intent intent = new Intent(NavigationDrawer.this, Dashboard2.class);
//                                    intent.putExtra("id", reqM.getUser_id());
//                                    intent.putExtra("pass", reqM.getUser_password());
                                    // startActivity(intent);
                                } else {
                                    //Failed
                                    new CustomAlert().showErrorMessage(IbexAccountInfoActivity.this, "","Data Not Found !");
                                }

                            }

                            @Override
                            public void onError(Throwable e) {
                                pDialog.dismiss();

                                // Log.e(TAG, "onError: " + e.getMessage());
                                ErrorUtil.showError(e, IbexAccountInfoActivity.this);
                            }
                        }));



    }




}