package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        frameLayout = (FrameLayout) findViewById(R.id.frameContainer);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temporaryFragment = null;
                switch (item.getItemId()){
                    case R.id.menu_home:
                        temporaryFragment = new HomeFragment();
                        break;

                    case R.id.menu_call:
                        temporaryFragment = new CallFragment();
                        break;

                    case R.id.menu_search:
                        temporaryFragment = new SearchFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,temporaryFragment).commit();
                return true;
            }
        });
    }
}