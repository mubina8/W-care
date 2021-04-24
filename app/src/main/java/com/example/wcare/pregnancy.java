package com.example.wcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wcare.fragments.CareFragment;
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
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy);
        this.setTitle("Pregnancy");
        back = (ImageView)findViewById(R.id.backId);
        after = (Button)findViewById(R.id.AfterId);
        before = (Button)findViewById(R.id.beforeId);
        special = (Button)findViewById(R.id.specialTipsId);
        mental = (Button)findViewById(R.id.mentalHeailthId);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        mental.setOnClickListener(this);
        after.setOnClickListener(this);
        before.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.AfterId){
            Intent intent = new Intent(getApplicationContext(), AfterActivity.class);
            intent.putExtra("name","Pregnancy");
            foodText = "One or two cloves garlic everyday in the morning with water. Bananas contain plenty of potassium.potassium reduces the effects of sodium and alleviates tension in the walls of the blood vessels. One glass of coconut water should be taken. One cup celery juice with apple juice. two or three table spoons of apple cider vinegar for a month.";
            medicine = "If you're planning to have a baby, it's important that you take folic acid tablets for two to three months before you conceive. This allows it to build up in your body to a level that gives the most protection to your future baby against neural tube defects, such as spina bifida";
            lifeStyle = "Lose extra pounds and watch your waistline. Exercise regularly. Eat a healthy diet. Reduce sodium in your diet.Limit the amount of alcohol you drink. Quit smoking. Cut back on caffeine. Reduce your stress.";
            DocumentReference documentReference = fStore.collection("healthCare").document("afterBirth");
            Map <String,Object> before = new HashMap<>();
            before.put("food",foodText);
            before.put("medicine",medicine);
            before.put("lifeStyle",lifeStyle);
            documentReference.set(before).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"After Birth Pregnancy Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }
        if(v.getId()==R.id.beforeId){
            Intent intent = new Intent(getApplicationContext(), beforeActivity.class);
            intent.putExtra("name","Pregnancy");
            foodText = "One or two cloves garlic everyday in the morning with water. Bananas contain plenty of potassium.potassium reduces the effects of sodium and alleviates tension in the walls of the blood vessels. One glass of coconut water should be taken. One cup celery juice with apple juice. two or three table spoons of apple cider vinegar for a month.";
            medicine = "If you're planning to have a baby, it's important that you take folic acid tablets for two to three months before you conceive. This allows it to build up in your body to a level that gives the most protection to your future baby against neural tube defects, such as spina bifida";
            lifeStyle = "Lose extra pounds and watch your waistline. Exercise regularly. Eat a healthy diet. Reduce sodium in your diet.Limit the amount of alcohol you drink. Quit smoking. Cut back on caffeine. Reduce your stress.";
            DocumentReference documentReference = fStore.collection("healthCare").document("beforeBirth");
            Map <String,Object> before = new HashMap<>();
            before.put("food",foodText);
            before.put("medicine",medicine);
            before.put("lifeStyle",lifeStyle);
            documentReference.set(before).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Before Birth Pregnancy Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }
        if(v.getId()==R.id.specialTipsId){
            Intent intent = new Intent(getApplicationContext(), AfterActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.mentalHeailthId){
            Intent intent = new Intent(getApplicationContext(), mentalHealthActivity.class);
            intent.putExtra("name","Mental Health");
           /* mentalhealth = "As many as 1 in 5 women have mental health problems in pregnancy or after birth.1-3 It can happen to anyone. Depression and anxiety are the most common mental health problems in pregnancy";

            DocumentReference documentReference = fStore.collection("healthCare").document("mental");
            Map<String,Object> mental = new HashMap<>();
            mental.put("Mentalhealth",mentalhealth);

            intent.putExtra("disease","bloodPressure");
            documentReference.set(mental).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Mental Health Details",Toast.LENGTH_SHORT).show();
                }
            });*/

            startActivity(intent);
        }
        if(v.getId()==R.id.backId){
            Fragment selectedFragment = new CareFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
           /* Intent intent = new Intent(getApplicationContext(), CareFragment.selectedFragment);
            startActivity(intent);
            finish();*/


        }
    }


}