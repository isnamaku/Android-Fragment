package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadFragment(new HomeFragment());
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case  R.id.menu_home :
                        loadFragment(new HomeFragment());
                        break;
                    case R.id.menu_profile :
                        loadFragment(new ProfileFragment());
                        break;
                }

                return false;
            }
        });
    }

    private void  loadFragment (Fragment fragment){
       getSupportFragmentManager()
               .beginTransaction()
               .replace(R.id.frame_container,fragment)
               .show(fragment)
               .commit();
    }
}
