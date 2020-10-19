package com.example.jetpackexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jetpackexample.databinding.ActivitySampleBinding;
import com.example.jetpackexample.databinding.activity.DataBindingActivity;
import com.example.jetpackexample.observer.MainActivity;
import com.example.jetpackexample.room.RoomActivity;
import com.example.jetpackexample.viewbinding.ViewBindingActivity;

public class SampleActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "SampleActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "SampleActivity onCreate called");
        ActivitySampleBinding binding = ActivitySampleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.lifecycle.setOnClickListener(this);
        binding.viewBinding.setOnClickListener(this);
        binding.dataBinding.setOnClickListener(this);
        binding.room.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lifecycle:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.viewBinding:
                startActivity(new Intent(this, ViewBindingActivity.class));
                break;
            case R.id.dataBinding:
                startActivity(new Intent(this, DataBindingActivity.class));
                break;
            case R.id.room:
                startActivity(new Intent(this, RoomActivity.class));
                break;
            default:
                break;
        }
    }
}
