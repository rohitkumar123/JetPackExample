package com.example.jetpackexample.databinding.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.jetpackexample.R;
import com.example.jetpackexample.databinding.ActivitySecondBinding;
import com.example.jetpackexample.databinding.adapter.MyRecyclerViewAdapter;
import com.example.jetpackexample.databinding.model.DataModel;

import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        binding.recycle.setHasFixedSize(true);
        populateData();
    }

    private void populateData() {
        List<DataModel> dataModelList =
                Arrays.asList(new DataModel("Android Oreo", 8),
                        new DataModel("Android Pie", 9), new DataModel("Android Nougat", 7), new DataModel("Android Marshmallow", 6));

//        dataModelList.add(new DataModel("Android Oreo", 8));
//        dataModelList.add(new DataModel("Android Pie", 9));
//        dataModelList.add(new DataModel("Android Nougat", 7));
//        dataModelList.add(new DataModel("Android Marshmallow", 6));

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataModelList, this);
        binding.setMyAdapter(myRecyclerViewAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
