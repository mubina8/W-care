package com.example.wcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity implements View.OnClickListener  {

    TextView signup,wcare;
    Button login;
    EditText userEmail,userPass;
    ProgressBar progressBar;


    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_in );


        mAuth = FirebaseAuth.getInstance();

        userEmail = findViewById( R.id.userNameEditTxt );
        userPass = findViewById( R.id.userpasseditText );
        progressBar = findViewById( R.id.progressBarin );
        wcare = (TextView) findViewById(R.id.wcare);
        wcare.setOnClickListener(this);
        signup = (TextView) findViewById( R.id.regtxt );
        signup.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( SignIn.this,RegistrationPage.class );
                startActivity( intent );
                finish();

                Toast.makeText(SignIn.this,"Login Successful",Toast.LENGTH_SHORT).show();
            }
        } );

        login = findViewById( R.id.loginButton );
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userSignIN();


            }
        } );
    }

    private void userSignIN(){

        String Useremail = userEmail.getText().toString();
        String Userpass = userPass.getText().toString();


        if (Useremail.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(Useremail).matches()) {
            userEmail.setError("Enter Valid Email");
            userEmail.requestFocus();
            return;
        }
        if (userPass.length() < 6) {
            userPass.setError("Password length should be more than 6");
            userPass.requestFocus();
            return;

        }

        progressBar.setVisibility( View.VISIBLE );
        login.setVisibility( View.INVISIBLE );

        mAuth.signInWithEmailAndPassword( Useremail,Userpass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Intent intent = new Intent( SignIn.this,NavigationPage.class );
                    startActivity( intent );
                    finish();

                }
                else {
                    Toast.makeText(SignIn.this,"Check your email id or password!",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility( View.INVISIBLE);
                    login.setVisibility( View.VISIBLE );
                }
            }
        } );

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.wcare){
            Intent intent = new Intent(getApplicationContext(),hygiene.class);
            startActivity(intent);
        }
    }
}
