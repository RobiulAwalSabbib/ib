package com.example.internetbanking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.internetbanking.ibexregistration.IbexRegisterReturn;
import com.example.internetbanking.ibexregistration.Reqinfo;
import com.example.internetbanking.ibexregistration.RequestJsonDataModel;
import com.example.internetbanking.ibexregistration.ResponseDataM;
import com.example.internetbanking.retrofit.ApiClient;
import com.example.internetbanking.retrofit.ApiService;
import com.example.internetbanking.util.CustomAlert;
import com.example.internetbanking.util.ErrorUtil;
import com.example.internetbanking.util.SimpleDatePicker;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class IbexRegistrationActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText et_cbs_accno, et_cbs_mobile, et_cbs_email, et_cbs_dob;
    TextView et_cbs_father_name, et_cbs_mailing_address,tv_goto_loginActivity;
    Button btn_cbs_acc_chek, btn_cbs_reg,btn_choose_date;

    String accNo, mobile, email, dob;

    SharedPreferences ibexRegistration;

    //Network call
    private ApiService cbsApiService;
    private ApiService ibexApiService;
    private CompositeDisposable cbsDisposable = new CompositeDisposable();
    private CompositeDisposable ibexDisposable = new CompositeDisposable();
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibex_registration);

        et_cbs_accno = findViewById(R.id.et_cbs_accno);
        et_cbs_mobile = findViewById(R.id.et_cbs_mobile);
        et_cbs_email = findViewById(R.id.et_cbs_email);
        et_cbs_dob = findViewById(R.id.et_cbs_dob);
        et_cbs_father_name = findViewById(R.id.et_cbs_father_name);
        et_cbs_mailing_address = findViewById(R.id.et_cbs_mailing_address);
        btn_cbs_acc_chek = findViewById(R.id.btn_cbs_acc_chek);
        tv_goto_loginActivity = findViewById(R.id.tv_goto_loginActivity);
        btn_cbs_reg = findViewById(R.id.btn_cbs_reg);
        //btn_choose_date = findViewById(R.id.btn_choose_date);

        ibexRegistration = getSharedPreferences("register", MODE_PRIVATE);


        et_cbs_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.DialogFragment picker = SimpleDatePicker.getInstance(IbexRegistrationActivity.this, et_cbs_dob);
                picker.show(getFragmentManager(), "datePicker");
            }
        });

//////////////////////// network call initialization ////////////////////////////
        //Network call
        //Network call
        cbsApiService = ApiClient.getExternalApiService(getApplicationContext());
        ibexApiService = ApiClient.getService(getApplicationContext());
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please waite..");
///----------------------------------------------------------------------------------------
        btn_cbs_acc_chek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //////////////////////////////////// set account and convert to json and map it ////////////////////////////////////

                accNo = et_cbs_accno.getText().toString();
                mobile = et_cbs_mobile.getText().toString();
                email = et_cbs_email.getText().toString();
                dob = et_cbs_dob.getText().toString();


                if(accNo.isEmpty()){

                    et_cbs_accno.setError("Please Enter Account No. first!");
                    et_cbs_accno.requestFocus();

                }else if(mobile.isEmpty()){

                    et_cbs_mobile.setError("Please Enter Mobile  first!");
                    et_cbs_mobile.requestFocus();

                }else if(email.isEmpty()){

                    et_cbs_email.setError("Please Enter Email  first!");
                    et_cbs_email.requestFocus();

                }else if(dob.isEmpty()){

                    et_cbs_dob.setError("Please Enter DOB  first!");
                    et_cbs_dob.requestFocus();

                }
                else {


                    RequestJsonDataModel jsonDataModel = new RequestJsonDataModel();
                    Reqinfo reqinfo = new Reqinfo();
                    reqinfo.setAccNo(accNo);
                    Log.e("Acc_no:", accNo);
                    jsonDataModel.setReqinfo(reqinfo);
                    String request = new Gson().toJson(jsonDataModel);
                    Log.e("request:", request);

                    //Here the json data is add to a hash map with key data
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("vinjdata", request);


                    ////////////////////////////// call api //////////////////////////////////////////////

                    get_cbsApiAccInfo("BEFTN", "01", "ATM001", "OTHER2ATM", "123456", params);


                }


            }
        });

 /////---------------------------------------------------------------------------------

        btn_cbs_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String acc_name = ibexRegistration.getString("acc_name", "0");
                String acc_no = ibexRegistration.getString("acc_no", "0");
                mobile = et_cbs_mobile.getText().toString();
                String dob = ibexRegistration.getString("dob", "0");
                String email = ibexRegistration.getString("email", "0");
                String reg_type = "MOBILE";
/*
                Intent intent = new Intent(IbexRegistrationActivity.this,RegistrationSuccessActivity.class);
                intent.putExtra("mobile",mobile);
                startActivity(intent);

 */

                get_ibexRegistration( acc_no, dob, email,mobile);

            }
        });


        ////////////////// goto login Activity /////////////////////////

        tv_goto_loginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IbexRegistrationActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });


    }



    private void get_cbsApiAccInfo(String beftn, String s, String atm001, String other2ATM, String s1, Map<String, String> params) {

        cbsDisposable.add(
                (Disposable) cbsApiService

                        .getCBSTestApi("BEFTN", "01", "ATM001", "OTHER2ATM", "123456", params)


                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<ResponseDataM>() {//change 2
                            @Override
                            public void onSuccess(ResponseDataM recM) {//change 3

                                pDialog.dismiss();

                                //change 4
                                //Receive Topup Result  Result
                                if (recM.getSuccess().equals("1")) {
                                    //Successful

                                    if (recM.getDob().equals(dob)) {

                                        et_cbs_father_name.setText(recM.getFathersName());
                                        et_cbs_mailing_address.setText(recM.getMailingAddress());
                                        btn_cbs_acc_chek.setVisibility(View.GONE);
                                        btn_cbs_reg.setVisibility(View.VISIBLE);

                                        //// set data to sharedpref

                                        ibexRegistration.edit().putString("acc_name", recM.getAccName()).apply();
                                        ibexRegistration.edit().putString("acc_no", recM.getAccNo()).apply();
                                        ibexRegistration.edit().putString("curr_bal", String.valueOf(recM.getCurrBal())).apply();
                                        ibexRegistration.edit().putString("avail_bal", String.valueOf(recM.getAvailBal())).apply();
                                        ibexRegistration.edit().putString("mailing_address", recM.getMailingAddress()).apply();
                                        ibexRegistration.edit().putString("acc_status", recM.getAccStatus()).apply();
                                        ibexRegistration.edit().putString("dob", recM.getDob()).apply();
                                        ibexRegistration.edit().putString("fathers_name", recM.getFathersName()).apply();
                                        ibexRegistration.edit().putString("mothers_name", recM.getMothersName()).apply();
                                        ibexRegistration.edit().putString("email", recM.getEmail()).apply();
                                        ibexRegistration.edit().putString("mobile", recM.getMobile()).apply();
                                        ibexRegistration.edit().putString("cust_id", recM.getCustId()).apply();
                                        ibexRegistration.edit().putString("product_code", recM.getProductCode()).apply();
                                        ibexRegistration.edit().putString("product_name", recM.getProductName()).apply();
                                        ibexRegistration.edit().putString("product_group_code", recM.getProductGroupCode()).apply();
                                        ibexRegistration.edit().putString("product_group_name", recM.getProductGroupName()).apply();
                                        ibexRegistration.edit().putString("product_group_type", recM.getProductGroupType()).apply();
                                        ibexRegistration.edit().putString("product_id", recM.getProductId()).apply();
                                        ibexRegistration.edit().putString("product_master_name", recM.getProductMasterName()).apply();
                                        ibexRegistration.edit().putString("success", recM.getSuccess()).apply();


                                        new CustomAlert().showSuccessMessage(IbexRegistrationActivity.this, "", "Data Found !");

                                    } else {

                                        new CustomAlert().showErrorMessage(IbexRegistrationActivity.this, "", "Data Not Match !!!!");

                                    }


                                    //new CustomAlert().showSuccessMessage(IbexRegistrationActivity.this, "", "Api Calling Successfully !");
                                    //Intent intent = new Intent(NavigationDrawer.this, Dashboard2.class);
//                                    intent.putExtra("id", reqM.getUser_id());
//                                    intent.putExtra("pass", reqM.getUser_password());
                                    // startActivity(intent);

                                } else {
                                    //Failed
                                    new CustomAlert().showErrorMessage(IbexRegistrationActivity.this, "", "Data Not Found !");

                                }

                            }

                            @Override
                            public void onError(Throwable e) {
                                pDialog.dismiss();

                                // Log.e(TAG, "onError: " + e.getMessage());
                                ErrorUtil.showError(e, IbexRegistrationActivity.this);
                            }
                        }));



    }


    private void get_ibexRegistration(String s2, String s3, String s4, String s5) {


        ibexDisposable.add(
                (Disposable) ibexApiService

                        //change 1
                        //.getCBSTestApi(beftn,s,atm001,other2ATM,s1,params)
                        .getIbexRegistrationApi(s2, s3, s4, s5)


                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<IbexRegisterReturn>() {//change 2
                            @Override
                            public void onSuccess(IbexRegisterReturn recM) {//change 3

                                pDialog.dismiss();

                                //change 4
                                //Receive Topup Result  Result
                                if (!recM.getSuccessMsg().isEmpty()) {
                                    //Successful

                                    btn_cbs_acc_chek.setVisibility(View.VISIBLE);
                                    btn_cbs_reg.setVisibility(View.GONE);

                                    new CustomAlert().showSuccessMessage(IbexRegistrationActivity.this, "", "" + recM.getSuccessMsg());


                                } else {

                                    new CustomAlert().showErrorMessage(IbexRegistrationActivity.this, "", "Failed To Register !!!!");

                                }


                            }


                            @Override
                            public void onError(Throwable e) {
                                pDialog.dismiss();

                                // Log.e(TAG, "onError: " + e.getMessage());
                                ErrorUtil.showError(e, IbexRegistrationActivity.this);
                            }
                        }));



    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        //String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());

         /*

        SimpleDateFormat formatIn = new SimpleDateFormat("mm/dd/yy");
        SimpleDateFormat formatout = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            formatout = new SimpleDateFormat("DD/MON/YYYY");
        }
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(formatIn.parse(currentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //String newDate = "";
        String newDate = formatout.format(calendar.getTime());
*/


        //String strCurrentDate = "Wed, 18 Apr 2012 07:55:29 +0000";
       /* SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
        Date newDate = null;
        try {
            newDate = format.parse(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        format = new SimpleDateFormat("dd"+"-"+"MMM"+"-"+"yyyy");
        String date = format.format(newDate);
*/


        et_cbs_dob.setText(currentDate);

    }
}