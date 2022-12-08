package com.example.internetbanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class IbexMenuActivity extends AppCompatActivity {

    LinearLayout beneficiary_add,ac_info,fund_tns_btn,lout_ibex_transaction_history;
    SharedPreferences logindata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibex_menu);

        logindata = getSharedPreferences("logindata",MODE_PRIVATE);

        beneficiary_add = findViewById(R.id.beneficiary_add);
        ac_info = findViewById(R.id.ac_info);
        fund_tns_btn = findViewById(R.id.fund_tns_btn);
        lout_ibex_transaction_history = findViewById(R.id.lout_ibex_transaction_history);


        ////////////////////////// layout on click /////////////////////////////
//        beneficiary_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(IbexMenuActivity.this, BeneficiaryAddActivity.class);
//                startActivity(intent);
//            }
//        });

        ac_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IbexMenuActivity.this, IbexAccountInfoActivity.class);
                startActivity(intent);
            }
        });


//        fund_tns_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(IbexMenuActivity.this, FundTransferActivity.class);
//                startActivity(intent);
//            }
//        });
//
        lout_ibex_transaction_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IbexMenuActivity.this, IbexTransactionHistoryActivity.class);
                startActivity(intent);
            }
        });


    }
}