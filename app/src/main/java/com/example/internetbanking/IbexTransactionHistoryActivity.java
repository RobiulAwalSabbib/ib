package com.example.internetbanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.internetbanking.ibexTransactionHistory.IbexTranHistoryRV;
import com.example.internetbanking.ibexTransactionHistory.Item;
import com.example.internetbanking.ibexTransactionHistory.TransactionHistoryModel;
import com.example.internetbanking.retrofit.ApiClient;
import com.example.internetbanking.retrofit.ApiService;
import com.example.internetbanking.util.CustomAlert;
import com.example.internetbanking.util.ErrorUtil;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class IbexTransactionHistoryActivity extends AppCompatActivity {

    //Network call
    private ApiService apiService;
    private CompositeDisposable disposable = new CompositeDisposable();
    private ProgressDialog pDialog;

    RecyclerView rv_ibex_transaction_history;

    ArrayList<Item> dataModels = new ArrayList<>();

    SharedPreferences logindata;

    String acc_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibex_transaction_history);


        rv_ibex_transaction_history = findViewById(R.id.rv_ibex_transaction_history);

        ////////////////// SharedPreferences initialization /////////////////////

        logindata = getSharedPreferences("logindata",MODE_PRIVATE);

        acc_no = logindata.getString("acNo","");
        //////////////////////// network call initialization ////////////////////////////
        //Network call
        apiService = ApiClient.getService(getApplicationContext());
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please waite..");



        get_Ibex_Transaction_History(acc_no);

    }


    /////////////////////////////// transaction history Api call /////////////////////////////

    private void get_Ibex_Transaction_History(String accNo){

        disposable.add(
                (Disposable) apiService

                        //change 1
                        .getIbexTransactionHistory(accNo)


                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<TransactionHistoryModel>() {//change 2
                            @Override
                            public void onSuccess( TransactionHistoryModel recM ) {//change 3

                                pDialog.dismiss();

                                //change 4
                                //Receive  Result
                                if (recM == null || recM.getItems().size() <1) {
                                    //UnSuccessful

                                    new CustomAlert().showErrorMessage(IbexTransactionHistoryActivity.this, "", "No Data Found.....!");

                                } else {
                                    //Successful

                                    try {

                                        dataModels.clear();
                                        dataModels = new ArrayList<>();


                                    }catch (Exception e){

                                    }



                                    for(int i=0; i < recM.getItems().size(); i++ ){

                                        dataModels.add(new Item(recM.getItems().get(i).getTransacNo()+"",
                                                recM.getItems().get(i).getAccNo()+"",
                                                recM.getItems().get(i).getGlAccNo()+"",
                                                recM.getItems().get(i).getTranDate()+"",
                                                recM.getItems().get(i).getTranAmt()+"",
                                                recM.getItems().get(i).getNewBal()+"",
                                                recM.getItems().get(i).getParticular()+""
                                        ));


                                    }

                                }

                                // rv_ibex_transaction_history = findViewById(R.id.rv_ibex_transaction_history);
                                IbexTranHistoryRV adapter = new IbexTranHistoryRV(dataModels,IbexTransactionHistoryActivity.this);

                                //rv_ibex_transaction_history.setHasFixedSize(true);
                                rv_ibex_transaction_history.setLayoutManager(new LinearLayoutManager(IbexTransactionHistoryActivity.this));
                                rv_ibex_transaction_history.setAdapter(adapter);


                            }

                            @Override
                            public void onError(Throwable e) {
                                pDialog.dismiss();

                                // Log.e(TAG, "onError: " + e.getMessage());
                                ErrorUtil.showError(e, IbexTransactionHistoryActivity.this);
                            }
                        }));



    }


}