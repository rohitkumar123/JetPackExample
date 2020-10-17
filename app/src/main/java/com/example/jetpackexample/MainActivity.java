package com.example.jetpackexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Activity onCreate");
        new MyObserver(getLifecycle());
        loadFragment(new MainFragment());
        // myObserver.enable();

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Activity onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Activity onResume");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Activity onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Activity onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Activity onDestroy");
    }
}