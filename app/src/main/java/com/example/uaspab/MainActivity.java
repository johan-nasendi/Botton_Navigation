package com.example.uaspab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.uaspab.FragmentAbout;
import com.example.uaspab.FragmentHome;
import com.example.uaspab.FragmentShop;
import com.example.uaspab.FragmentTodo;
import com.example.uaspab.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.button_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new FragmentHome()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new FragmentHome();
                        break;
                    case R.id.nav_todo:
                        fragment = new FragmentTodo();
//
                        break;
                    case R.id.nav_abaout:
                        fragment = new FragmentAbout();

                        break;
                    case R.id.nav_shop:
                        fragment = new FragmentShop();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
    }
}