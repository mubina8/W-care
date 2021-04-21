package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.wcare.fragments.AlertFragment;
import com.example.wcare.fragments.BlogFragment;
import com.example.wcare.fragments.CareFragment;
import com.example.wcare.fragments.ProfileFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class NavigationPage extends AppCompatActivity {

    ChipNavigationBar bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_navigation_page );

        bottomNavigation = findViewById( R.id.bottomNavigation );
        bottomNavigation.setOnItemSelectedListener( navListener );
        //setting home fragment as initial fragment
        if(savedInstanceState==null)
        {
            bottomNavigation.setItemSelected(R.id.home,true);
        }
        bottomNavigation.setOnItemSelectedListener(navListener);
    }

    private ChipNavigationBar.OnItemSelectedListener navListener = new ChipNavigationBar.OnItemSelectedListener() {
        @Override
        public void onItemSelected(int i) {

            Fragment selectedFragment =null;

            switch (i){

                case R.id.home:
                    selectedFragment = new CareFragment();
                    break;

                case R.id.selfCare:
                    selectedFragment = new AlertFragment(); // replace this part
                    break;

                case R.id.blog:
                    selectedFragment = new BlogFragment(); // replace this part

                    break;
                case R.id.profile:
                    selectedFragment = new ProfileFragment(); // replace this part

                    break;



            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();




        }
    };

}
