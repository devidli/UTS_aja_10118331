package com.example.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.view.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,new HomeFragment()).commit();
        bottomNavigationView
                .setOnNavigationItemSelectedListener(item -> {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_note:
                            selectedFragment = new NoteFragment();
                            break;
                        case R.id.nav_info:
                            selectedFragment = new InfoFragment();
                            break;

                    }
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,selectedFragment).commit();

                    return true;
                });
    }
}
// 05-06-2021
// 10118331
// Devidli Setiawan
// IF-8