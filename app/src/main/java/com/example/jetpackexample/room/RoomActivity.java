package com.example.jetpackexample.room;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.jetpackexample.R;
import com.example.jetpackexample.databinding.ActivityRoomBinding;
import com.example.jetpackexample.room.database.UserDatabase;
import com.example.jetpackexample.room.entity.User;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityRoomBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_room);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                UserDatabase appData = UserDatabase.getInstance(getApplicationContext());
                User user = new User("Test", "User");
                appData.userDao().insertAll(user);
                appData.userDao().findByName("Test", "User");
                final User user1 = appData.userDao().getAll().get(0);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        if (user1 != null) {
                            binding.firstName.setText(user1.getFirstName());
                            binding.lastName.setText(user1.getLastName());
                        }
                    }
                });
            }
        });
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
