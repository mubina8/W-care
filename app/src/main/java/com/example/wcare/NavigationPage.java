package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wcare.fragments.AlertFragment;
import com.example.wcare.fragments.BlogFragment;
import com.example.wcare.fragments.CareFragment;
import com.example.wcare.fragments.ProfileFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class NavigationPage extends AppCompatActivity {

    ChipNavigationBar bottomNavigation;

    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_navigation_page );

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        bottomNavigation = findViewById( R.id.bottomNavigation );
        bottomNavigation.setOnItemSelectedListener( navListener );
        //setting home fragment as initial fragment
        if(savedInstanceState==null)
        {
            bottomNavigation.setItemSelected(R.id.home,true);
        }
        bottomNavigation.setOnItemSelectedListener(navListener);



        // checking if email has been verified
        if(!user.isEmailVerified())
        {
            Toast.makeText(NavigationPage.this, "Verify your email first", Toast.LENGTH_SHORT).show();
            mAuth.signOut();
            Intent intent = new Intent(NavigationPage.this, SignIn.class);
            startActivity(intent);
            finish();
        }
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
