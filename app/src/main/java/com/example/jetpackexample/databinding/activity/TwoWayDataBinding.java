package com.example.jetpackexample.databinding.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.jetpackexample.R;
import com.example.jetpackexample.databinding.ActivityTwowayBinding;
import com.example.jetpackexample.databinding.model.UserDataObserver;

public class TwoWayDataBinding extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTwowayBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_twoway);
        UserDataObserver userDataObserver = new UserDataObserver();
        userDataObserver.firstName.set("Rohit");
        userDataObserver.lastName.set("Kumar");
        binding.setUserDataObserver(userDataObserver);
    }
}
