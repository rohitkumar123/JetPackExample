package com.example.jetpackexample.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.jetpackexample.room.dao.UserDao;
import com.example.jetpackexample.room.entity.User;

@Database(entities = User.class, exportSchema = false, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static volatile UserDatabase instance;
    private static final String DB_NAME = "user_db";

    public static UserDatabase getInstance(Context context) {
        if(instance == null){
            synchronized (UserDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DB_NAME).
                            fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return instance;
    }

    public abstract UserDao userDao();
}
