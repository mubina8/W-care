package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class beforeActivity extends AppCompatActivity {
    TextView foodText,medicine,lifeStyleText;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("name");
        this.setTitle(title);
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
}