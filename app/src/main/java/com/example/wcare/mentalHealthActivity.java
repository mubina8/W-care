package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class mentalHealthActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mental;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("name");
        this.setTitle(title);
        back = (ImageView)findViewById(R.id.backId);
        back.setOnClickListener(this);
        mental = (TextView)findViewById(R.id.mentalTextViewId);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        DocumentReference documentReference = fStore.collection("healthCare").document("mental");
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mental.setText(documentSnapshot.getString("Mentalhealth"));

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