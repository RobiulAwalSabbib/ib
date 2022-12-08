package com.example.internetbanking.ibexTransactionHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.internetbanking.R;

import java.util.ArrayList;

public class IbexTranHistoryRV extends RecyclerView.Adapter<IbexTranHistoryRV.ViewHolder> {

    ArrayList<Item> dataModels;
    Context context;

    public IbexTranHistoryRV(ArrayList<Item> dataModels, Context context) {
        this.dataModels = dataModels;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ibex_transaction_history,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        holder.tv_tran_no.setText(dataModels.get(position).getTransacNo());
        holder.tv_acc_no.setText(dataModels.get(position).getAccNo());
        //holder.tv_gl_no.setText(dataModels.get(position).getGlAccNo());
        holder.tv_tran_date.setText(dataModels.get(position).getTranDate());
        holder.tv_tran_amt.setText(dataModels.get(position).getTranAmt());
        holder.tv_new_balance.setText(dataModels.get(position).getNewBal());
        //holder.tv_particular.setText(dataModels.get(position).getParticular());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_tran_no,tv_acc_no,tv_gl_no,tv_tran_date,tv_tran_amt,tv_new_balance,tv_particular;


        public ViewHolder(View itemView) {
            super(itemView);

            tv_tran_no = itemView.findViewById(R.id.tv_tran_no);
            tv_acc_no = itemView.findViewById(R.id.tv_acc_no);
            //tv_gl_no = itemView.findViewById(R.id.tv_gl_no);
            tv_tran_date = itemView.findViewById(R.id.tv_tran_date);
            tv_tran_amt = itemView.findViewById(R.id.tv_tran_amt);
            tv_new_balance = itemView.findViewById(R.id.tv_new_balance);
            //tv_particular = itemView.findViewById(R.id.tv_particular);
        }
    }

}
