package com.example.jetpackexample.databinding.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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

public class DataBindingActivity extends AppCompatActivity implements DataBindingActivityContract.View, View.OnClickListener {
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
        // ViewBindingAdapter
        binding.includeLayout.textView.setText("Testing Include Secondary Layout");
        binding.setMethodListener(this);
        binding.setEventListener(new EventHandler(this));
    }

    public void onClickFriend(View view) {
        Toast.makeText(this, "<<<==onClickFriend==>>>", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showData(UserDataObserver userData) {
        String firstName = userData.firstName.get();
        String lastName = userData.lastName.get();
        Toast.makeText(this, "FirstName: "+ firstName +"\n"+ "LastName: " +lastName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "<<<====DataBindingActivity=>>>>", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onClick(View v) {
//        Toast.makeText(this.mContext, "Event Handler", Toast.LENGTH_SHORT).show();
//    }

    public class EventHandler implements View.OnClickListener {
        Context mContext;
        public EventHandler(Context context){
            this.mContext = context;
        }
        @Override
        public void onClick(View v) {
            Toast.makeText(this.mContext, "Event Handler", Toast.LENGTH_SHORT).show();
        }
    }
}
