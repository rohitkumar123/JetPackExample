package com.example.jetpackexample.databinding.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.jetpackexample.R;
import com.example.jetpackexample.databinding.ActivityDatabindingBinding;
import com.example.jetpackexample.databinding.contract.DataBindingActivityContract;
import com.example.jetpackexample.databinding.model.User;
import com.example.jetpackexample.databinding.model.UserData;
import com.example.jetpackexample.databinding.model.UserDataObserver;
import com.example.jetpackexample.databinding.presenter.DataBindingActivityPresenter;

public class DataBindingActivity extends AppCompatActivity implements DataBindingActivityContract.View {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        DataBindingActivityPresenter dataBindingActivityPresenter = new DataBindingActivityPresenter(this, getApplicationContext());
        User user = new User("Test", "User");
        binding.setUser(user);
        UserData userData = new UserData("Testing Base Observer", "User Base Observer");
        binding.setUserData(userData);
        UserDataObserver userDataObserver = new UserDataObserver();
        userDataObserver.firstName.set("Testing Observable");
        userDataObserver.lastName.set("User Observable");
        binding.setUserDataObserver(userDataObserver);
        binding.setPresenter(dataBindingActivityPresenter);
    }

    @Override
    public void showData(UserDataObserver userData) {
        String firstName = userData.firstName.get();
        String lastName = userData.lastName.get();
        Toast.makeText(this, "FirstName: "+ firstName +"\n"+ "LastName: " +lastName, Toast.LENGTH_SHORT).show();
    }
}
