package com.example.jetpackexample.databinding.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.jetpackexample.R;
import com.example.jetpackexample.databinding.ActivityTwowayBinding;
import com.example.jetpackexample.databinding.model.UserData;

public class TwoWayDataBinding extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTwowayBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_twoway);
        UserData userData = new UserData("Rohit", "Kumar");
        binding.setUserData(userData);
    }
}
