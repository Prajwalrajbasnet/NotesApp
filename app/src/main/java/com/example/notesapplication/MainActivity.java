package com.example.notesapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String PREF_NAME = "notes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String prevtext = preference.getString("firstnote", "");
        EditText text1 = findViewById(R.id.notes);
        text1.setText(prevtext);
    }

    public void saveText(View view)
    {
        EditText txt = findViewById(R.id.notes);
        String inputtxt = txt.getText().toString();
        SharedPreferences preferences =  getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("firstnote", inputtxt);
        editor.apply();
        Toast.makeText(this, "The text file is saved successfully", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EditText txt = findViewById(R.id.notes);
        String inputtxt = txt.getText().toString();
        SharedPreferences preferences =  getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("firstnote", inputtxt);
        editor.apply();
        finishAffinity();

    }

    @Override
    protected void onStop() {
        super.onStop();
        EditText txt = findViewById(R.id.notes);
        String inputtxt = txt.getText().toString();
        SharedPreferences preferences =  getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("firstnote", inputtxt);
        editor.apply();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        switch (id)
        {
            case R.id.about:
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                break;

            case  R.id.settings:
                Intent settingIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingIntent);
                break;


            case R.id.help:
                Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(helpIntent);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
