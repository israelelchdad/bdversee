package com.example.bdiverse.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;

import com.example.bdiverse.Fragment.LoginFragment;
import com.example.bdiverse.R;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {
    public static final String MY_PREFS = "mysessio";
    public static final String USER_NAME="userName";
    public static final String PASSWORD="password";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initFragmentLogin();


    }

    private void initFragmentLogin() {
        LoginFragment loginFragment = LoginFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.AL_fragment_container,loginFragment).commit();

    }

    @Override
    public void moveToActivityNavigation(Boolean isSelect, String userName, String password) {
        if(isSelect){
            sharedPreferences = this.getSharedPreferences(MY_PREFS,0);
            editor = sharedPreferences.edit();
            editor.putString(USER_NAME,userName );
            editor.putString(PASSWORD,password);
            editor.apply();

        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }









}
