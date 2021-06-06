package com.example.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class StartedActivity extends AppCompatActivity {

    private androidx.viewpager.widget.ViewPager screenPager;
    private ViewPager adapter;
    private Button buttonGetStarted;
    TabLayout tabIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started);
        tabIndicator = findViewById(R.id.tab_indicator);
        buttonGetStarted = findViewById(R.id.btn_start);
        screenPager = findViewById(R.id.viewpager);
        adapter = new ViewPager(this);

        screenPager.setAdapter(adapter);

        tabIndicator.setupWithViewPager(screenPager);
        buttonGetStarted.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        });
    }
}
// 05-06-2021
// 10118331
// Devidli Setiawan
// IF-8