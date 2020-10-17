package com.example.jetpackexample.viewbinding;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jetpackexample.R;
import com.example.jetpackexample.databinding.ActivityViewbindingBinding;

public class ViewBindingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewbindingBinding binding = ActivityViewbindingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.firstName.setText(getString(R.string.first_name));
        binding.lastName.setText(getString(R.string.last_name));
    }
}

