package com.example.jetpackexample.databinding.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.jetpackexample.databinding.activity.SecondActivity;
import com.example.jetpackexample.databinding.contract.DataBindingActivityContract;
import com.example.jetpackexample.databinding.model.UserDataObserver;

public class DataBindingActivityPresenter implements DataBindingActivityContract.Presenter {
    private static final String TAG = "DataBindingActivityPres";
    private DataBindingActivityContract.View view;
    private Context mContext;
    public DataBindingActivityPresenter(DataBindingActivityContract.View view, Context context) {
        this.view = view;
        this.mContext = context;
    }
    @Override
    public void onShowData(UserDataObserver userData) {
        Log.i(TAG, "onShowData: "+userData);
        this.view.showData(userData);
    }

    @Override
    public void showList() {
        this.mContext.startActivity(new Intent(this.mContext, SecondActivity.class));
    }
}
