package com.example.notesapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
    }

    public void setPassword(View view)
    {
        EditText e1 = findViewById(R.id.pwdfield);
        EditText e2 = findViewById(R.id.repwdfield);

        String p1 = e1.getText().toString();
        String p2 = e2.getText().toString();

        if(p1.equals(p2))
        {
            SharedPreferences preferences = getSharedPreferences(MainActivity.PREF_NAME,MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("password",p1);
            editor.apply();
            finish();

            startActivity(new Intent(this, MainActivity.class));



        }

        else
        {
            Toast.makeText(this, "Passwords didn't match!", Toast.LENGTH_SHORT).show();

        }





    }
}


