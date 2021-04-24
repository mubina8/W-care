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
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    ImageView back;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("name");
        this.setTitle(title);
        back = (ImageView) findViewById(R.id.backId) ;
        back.setOnClickListener(this);
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
    }
}