package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity  {

    TextView signup;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_in );

        signup = (TextView) findViewById( R.id.regtxt );
        signup.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( SignIn.this,RegistrationPage.class );
                startActivity( intent );

                Toast.makeText(SignIn.this,"Login Successful",Toast.LENGTH_SHORT).show();
            }
        } );

        login = findViewById( R.id.loginButton );
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( SignIn.this,NavigationPage.class );
                startActivity( intent );

                Toast.makeText(SignIn.this,"Login Successful",Toast.LENGTH_SHORT).show();

            }
        } );
    }

}
