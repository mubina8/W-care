package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class pregnancy extends AppCompatActivity implements View.OnClickListener {
    Button after,before,special,mental;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String foodText,medicine,lifeStyle,mentalhealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy);
        this.setTitle("Pregnancy");
        after = (Button)findViewById(R.id.AfterId);
        before = (Button)findViewById(R.id.beforeId);
        special = (Button)findViewById(R.id.specialTipsId);
        mental = (Button)findViewById(R.id.mentalHeailthId);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        mental.setOnClickListener(this);
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
            intent.putExtra("name","Mental Health");
            mentalhealth = "As many as 1 in 5 women have mental health problems in pregnancy or after birth.1-3 It can happen to anyone. Depression and anxiety are the most common mental health problems in pregnancy";

            DocumentReference documentReference = fStore.collection("healthCare").document("mental");
            Map<String,Object> mental = new HashMap<>();
            mental.put("Mentalhealth",mentalhealth);

            intent.putExtra("disease","bloodPressure");
            documentReference.set(mental).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Mental Health Details",Toast.LENGTH_SHORT).show();
                }
            });

            startActivity(intent);
        }
    }


}