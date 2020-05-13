package com.example.notesapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences(MainActivity.PREF_NAME, MODE_PRIVATE);
                String pwd = preferences.getString("password", "");


                if(pwd.equals(""))
                {
                    Intent splashIntent = new Intent(SplashActivity.this, CreateAccountActivity.class );
                    startActivity(splashIntent);
                }

                else{
                    Intent splash = new Intent(SplashActivity.this, LoginActivity.class );
                    startActivity(splash);
                }

            }
        }, 3000);

    }



}
