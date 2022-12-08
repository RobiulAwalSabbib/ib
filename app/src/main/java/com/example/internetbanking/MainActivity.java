package com.example.internetbanking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.internetbanking.ibexlogin.IbexLoginReponse;
import com.example.internetbanking.ibexlogin.LoginReqM;
import com.example.internetbanking.retrofit.ApiClient;
import com.example.internetbanking.retrofit.ApiService;
import com.example.internetbanking.util.CustomAlert;
import com.example.internetbanking.util.ErrorUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    EditText et_ibex_user_log,et_ibex_pass_log;
    Button btn_ibex_login_log;
    TextView tv_reg_log;
    Intent intent;

    private ApiService apiService;
    private CompositeDisposable disposable = new CompositeDisposable();
    private ProgressDialog pDialog;

    SharedPreferences logindata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_ibex_user_log = findViewById(R.id.et_ibex_user_log);
        et_ibex_pass_log = findViewById(R.id.et_ibex_pass_log);
        btn_ibex_login_log = findViewById(R.id.btn_ibex_login_log);
        tv_reg_log = findViewById(R.id.tv_reg_log);


        //////////////////////// network call initialization ////////////////////////////

        apiService = ApiClient.getService(getApplicationContext());



        ////////////////// SharedPreferences initialization /////////////////////

        logindata = getSharedPreferences("logindata",MODE_PRIVATE);


        /////////////////////// go to registration -//////////////////////

        tv_reg_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, IbexRegistrationActivity.class);
//                                    intent.putExtra("id", reqM.getUser_id());
//                                    intent.putExtra("pass", reqM.getUser_password());
                startActivity(intent);


            }
        });





        btn_ibex_login_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pDialog = new ProgressDialog(MainActivity.this);
                pDialog.setMessage("Please waite..");


                String user = et_ibex_user_log.getText().toString();
                String pass = et_ibex_pass_log.getText().toString();

                if(user.isEmpty()){

                    et_ibex_user_log.setError("Please Enter User first!");
                    et_ibex_user_log.requestFocus();

                }else if(pass.isEmpty()){

                    et_ibex_pass_log.setError("Please Enter Password first!");
                    et_ibex_pass_log.requestFocus();

                }else{


                    LoginReqM reqM = new LoginReqM();
                    reqM.setUser_id(user);
                    reqM.setUser_password(pass);

                    pDialog.show();
                    doIbexLogin(reqM);


                }
            }
        });



    }



    private void doIbexLogin(final LoginReqM reqM) {


        disposable.add(
                apiService

                        //change 1
                        .getIbexLoginApi(reqM.getUser_id(),
                                reqM.getUser_password())


                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<IbexLoginReponse>() {//change 2
                            @Override
                            public void onSuccess(IbexLoginReponse receiveM) {//change 3

                                pDialog.dismiss();

                                //change 4
                                //Login Result
                                if (receiveM.getSuccess().equals("1")) {
                                    //Successful

                                    new CustomAlert().showSuccessMessage(MainActivity.this, "","Hi "+ receiveM.getAccName() +" !");

                                    logindata.edit().clear().apply();
                                    logindata.edit().putString("acNo", receiveM.getAccNo()).apply();
                                    logindata.edit().putString("acName", receiveM.getAccName()).apply();
                                    logindata.edit().putString("buCode", receiveM.getBuCode()).apply();
                                    logindata.edit().putString("eMail", receiveM.getEmail()).apply();
                                    logindata.edit().putString("mobile", receiveM.getMobile()).apply();
                                    logindata.edit().putString("unitCode", receiveM.getUnitCode()).apply();
                                    logindata.edit().putString("userType", receiveM.getUsertype()).apply();
                                    logindata.edit().putString("changePassNext", receiveM.getChangePassOnNextLogin()).apply();
                                    logindata.edit().putString("userID", receiveM.getUserId()).apply();
                                    logindata.edit().putString("parentMenu", receiveM.getParentMenuCode()).apply();
                                    logindata.edit().putString("success", receiveM.getSuccess()).apply();

                                    Intent intent = new Intent(MainActivity.this, IbexMenuActivity.class);
                                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);

                                } else {
                                    //Failed
                                    new CustomAlert().showErrorMessage(MainActivity.this, "", "No Data Found !");

                                }

                            }

                            @Override
                            public void onError(Throwable e) {
                                pDialog.dismiss();

                                // Log.e(TAG, "onError: " + e.getMessage());
                                ErrorUtil.userPassError(e, MainActivity.this);
                            }
                        }));


    }

    //////////////////////////// keyboard updown //////////////////////////////////////////////
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }



}