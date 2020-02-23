package com.example.bdiverse;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.bdiverse.Activitys.LoginActivity;
import com.example.bdiverse.Activitys.MainActivity;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences myPrefs;
        myPrefs = this.getSharedPreferences(LoginActivity.MY_PREFS, MODE_PRIVATE);

        String userName = myPrefs.getString(LoginActivity.USER_NAME, null);
        String password = myPrefs.getString(LoginActivity.PASSWORD, null);
        if (userName !=null && password!=null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }

    }
}
