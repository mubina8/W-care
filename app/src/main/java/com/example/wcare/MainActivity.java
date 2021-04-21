package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button trial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        trial = (Button) findViewById( R.id.trial );
        trial.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent( MainActivity.this,pregnancy.class );
        startActivity( intent );

        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
    }
}
