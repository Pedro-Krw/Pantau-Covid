package com.pedro.latihanapi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pedro.latihanapi.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().hide();
    }

    public void git(View view) {
        Intent intent = new Intent(InfoActivity.this , MainActivity.class);
        startActivity(intent);
    }
}