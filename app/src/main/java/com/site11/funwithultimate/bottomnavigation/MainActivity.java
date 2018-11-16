package com.site11.funwithultimate.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Home_Fragment home_fragment;
    private UP_Food_Fragment up_food_fragment;
    private Down_Food_Fragment down_food_fragment;

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_fragment = new Home_Fragment();
        up_food_fragment = new UP_Food_Fragment();
        down_food_fragment = new Down_Food_Fragment();
        
        frameLayout = (FrameLayout) findViewById(R.id.frame_layoutf);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_barf);

        setFragment(home_fragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_fhome:
                        bottomNavigationView.setBackgroundResource(R.color.colorPrimary);
                        setFragment(home_fragment);
                        return true;

                    case R.id.nav_fstore:
                        bottomNavigationView.setBackgroundResource(R.color.colorAccent);
                        setFragment(down_food_fragment);
                        return true;

                    case R.id.nav_fsell:
                        bottomNavigationView.setBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(up_food_fragment);
                        return true;

                    default:
                        return false;
                }

            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layoutf,fragment);
        fragmentTransaction.commit();
    }
}
