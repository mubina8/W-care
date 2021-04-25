package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class beforeActivity extends AppCompatActivity implements View.OnClickListener {
    TextView foodText,medicine,lifeStyleText;
    ImageView back,up,down,meddown,medup,lifedown,lifeup;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("name");
        this.setTitle(title);
        back = (ImageView) findViewById(R.id.backId) ;
        up = (ImageView) findViewById(R.id.upId);
        down = (ImageView) findViewById(R.id.downId);
        medup = (ImageView) findViewById(R.id.medupId);
        meddown = (ImageView) findViewById(R.id.meddownId);
        lifeup = (ImageView) findViewById(R.id.lifeupId);
        lifedown = (ImageView) findViewById(R.id.lifedownId);
        back.setOnClickListener(this);
        up.setOnClickListener(this);
        down.setOnClickListener(this);
        medup.setOnClickListener(this);
        meddown.setOnClickListener(this);
        lifeup.setOnClickListener(this);
        lifedown.setOnClickListener(this);
        foodText = (TextView)findViewById(R.id.foodTextViewId);
        medicine = (TextView)findViewById(R.id.medicineTextViewId);
        lifeStyleText = (TextView)findViewById(R.id.lifestyleTextViewId);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fStore.collection("healthCare").document("beforeBirth");
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                foodText.setText(documentSnapshot.getString("food"));
                medicine.setText(documentSnapshot.getString("medicine"));
                lifeStyleText.setText(documentSnapshot.getString("lifeStyle"));
            }
        });
    }

    @Override
    public void onClick(View v) {

            if(v.getId()==R.id.backId){
                Intent intent = new Intent(getApplicationContext(),pregnancy.class);
                startActivity(intent);
                finish();
            }
        if(v.getId()==R.id.downId){
            up.setVisibility(View.VISIBLE);
            foodText.setVisibility(View.VISIBLE);
            down.setVisibility(View.INVISIBLE);
        }
        if(v.getId()==R.id.upId){
            up.setVisibility(View.INVISIBLE);
            foodText.setVisibility(View.GONE);
            down.setVisibility(View.VISIBLE);
        }
        if(v.getId()==R.id.meddownId){
            medup.setVisibility(View.VISIBLE);
            medicine.setVisibility(View.VISIBLE);
            meddown.setVisibility(View.INVISIBLE);
        }
        if(v.getId()==R.id.medupId){
            medup.setVisibility(View.INVISIBLE);
            medicine.setVisibility(View.GONE);
            meddown.setVisibility(View.VISIBLE);
        }
        if(v.getId()==R.id.lifedownId){
            lifeup.setVisibility(View.VISIBLE);
            lifeStyleText.setVisibility(View.VISIBLE);
            lifedown.setVisibility(View.INVISIBLE);
        }
        if(v.getId()==R.id.lifeupId){
            lifeup.setVisibility(View.INVISIBLE);
            lifeStyleText.setVisibility(View.GONE);
            lifedown.setVisibility(View.VISIBLE);
        }
    }
}