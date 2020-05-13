package com.example.notesapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void changepwd(View view) {

        EditText o1 = findViewById(R.id.oldpwd);
        EditText t1 = findViewById(R.id.newpwd);
        EditText t2 = findViewById(R.id.newpwd2);

        String old = o1.getText().toString();
        String s1 = t1.getText().toString();
        String s2 = t2.getText().toString();

        SharedPreferences pref = getSharedPreferences(MainActivity.PREF_NAME, MODE_PRIVATE);
        String pwd =  pref.getString("password", "");

        if(!(old.equals(pwd)))
        {
            Toast.makeText(this,"Enter correct password", Toast.LENGTH_SHORT).show();
        }

        else
        {

            if(s1.equals(s2))
            {
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("password", s1);
                edit.apply();
                Toast.makeText(this,"New password set successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));

            }

            else
            {
                Toast.makeText(this, "New passwords didn't match!", Toast.LENGTH_SHORT).show();
            }
        }




    }
}
