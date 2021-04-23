package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    private static int SPLASH_SCREEN = 3000;
    Animation topanim;
    ImageView logoimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView( R.layout.activity_main );

        mAuth = FirebaseAuth.getInstance();

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_anim);

        logoimg = findViewById( R.id.logo );
        logoimg.setAnimation( topanim );


        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                // if user don't logout then user will sent to dashbord every time user opens the app
                if(mAuth.getCurrentUser()!=null)
                {
                    Intent intent= new Intent(MainActivity.this,NavigationPage.class);
                    startActivity(intent);
                    finish();

                }
                else {
                    Intent intent = new Intent(MainActivity.this,SignIn.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_SCREEN);



    }

}
