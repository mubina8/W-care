package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity implements View.OnClickListener {

    TextView loPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registration_page );

        loPage = (TextView) findViewById( R.id.backtologinpage );
        loPage.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent( RegistrationPage.this,SignIn.class );
        startActivity( intent );

        Toast.makeText(RegistrationPage.this,"Login Successful",Toast.LENGTH_SHORT).show();
    }
}
