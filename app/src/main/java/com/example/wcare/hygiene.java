package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wcare.fragments.CareFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class hygiene extends AppCompatActivity implements View.OnClickListener{
    Button vb,sb,cb,sab,mb;
    ImageView back;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hygiene);
        vb = (Button)findViewById(R.id.vaginalHealthId);
        sb = (Button)findViewById(R.id.sanitaryNapkinId);
        cb = (Button)findViewById(R.id.clothsId);
        sab = (Button)findViewById(R.id.safeIntercourseId);
        mb = (Button)findViewById(R.id.medicationId);
        back = (ImageView)findViewById(R.id.backId);
        vb.setOnClickListener(this);
        sb.setOnClickListener(this);
        cb.setOnClickListener(this);
        sab.setOnClickListener(this);
        mb.setOnClickListener(this);
        back.setOnClickListener(this);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.vaginalHealthId)
        {
            Intent intent = new Intent(getApplicationContext(), hygieneDetailed.class);
            intent.putExtra("name","Vaginal Health");
            intent.putExtra("disease","vaginalhealth");
            startActivity(intent);

        }
        if(v.getId()==R.id.sanitaryNapkinId)
        {
            Intent intent = new Intent(getApplicationContext(), hygieneDetailed.class);
            intent.putExtra("name","Sanitary Napkin");
            intent.putExtra("disease","sanitarynapkin");
            startActivity(intent);

        }
        if(v.getId()==R.id.clothsId)
        {
            Intent intent = new Intent(getApplicationContext(), hygieneDetailed.class);
            intent.putExtra("name","Cloths");
            intent.putExtra("disease","Cloths");
            startActivity(intent);

        }
        if(v.getId()==R.id.safeIntercourseId)
        {
            Intent intent = new Intent(getApplicationContext(), hygieneDetailed.class);
            intent.putExtra("name","Safe Intercourse");
            intent.putExtra("disease","safeintercourse");
            startActivity(intent);

        }
        if(v.getId()==R.id.medicationId)
        {
            Intent intent = new Intent(getApplicationContext(), hygieneDetailed.class);
            intent.putExtra("name","Self Medication");
            intent.putExtra("disease","medication");
            startActivity(intent);

        }
        if(v.getId()==R.id.backId){
            Intent intent = new Intent(getApplicationContext(),NavigationPage.class);
            startActivity(intent);
            finish();
            //Fragment selectedFragment = new CareFragment();
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
        }

    }
}