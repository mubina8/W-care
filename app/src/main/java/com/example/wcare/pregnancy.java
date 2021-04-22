package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pregnancy extends AppCompatActivity implements View.OnClickListener {
    Button after,before,special,mental;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy);
        this.setTitle("Pregnancy");
        after = (Button)findViewById(R.id.AfterId);
        before = (Button)findViewById(R.id.beforeId);
        special = (Button)findViewById(R.id.specialTipsId);
        mental = (Button)findViewById(R.id.mentalHeailthId);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.AfterId){
            Intent intent = new Intent(getApplicationContext(), AfterActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.beforeId){
            Intent intent = new Intent(getApplicationContext(), beforeActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.specialTipsId){
            Intent intent = new Intent(getApplicationContext(), AfterActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.mentalHeailthId){
            Intent intent = new Intent(getApplicationContext(), mentalHealthActivity.class);
            startActivity(intent);
        }
    }


}