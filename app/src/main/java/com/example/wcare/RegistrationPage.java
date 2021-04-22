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

import com.example.wcare.Classes.newUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationPage extends AppCompatActivity {

    TextView loPage;
    EditText userName,userEmail,userPhn,userPass,userConPass;
    Button signupButton;
    ProgressBar progressBar;

    FirebaseAuth mAuth;
    DatabaseReference veriiedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registration_page );

        mAuth = FirebaseAuth.getInstance();
        veriiedUser = FirebaseDatabase.getInstance().getReference();

        loPage = (TextView) findViewById( R.id.backtologinpage );
        loPage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( RegistrationPage.this,SignIn.class );
                startActivity( intent );
                finish();

            }
        } );

        userName = findViewById( R.id.nameText );
        userPhn = findViewById( R.id.phnTxt );
        userEmail = findViewById( R.id.emailText );
        userPass = findViewById( R.id.passTxt );
        userConPass = findViewById( R.id.confpassTxt );
        progressBar = findViewById( R.id.progressBarReg );
        signupButton = findViewById( R.id.regButton );
        signupButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();

            }
        } );


    }

    private void registerUser(){

        final String name = userName.getText().toString();
        final String phone = userPhn.getText().toString();
        final String email = userEmail.getText().toString();
        String password = userPass.getText().toString();
        String confPassword = userConPass.getText().toString();

        if(name.isEmpty())
        {
            userName.setError("Enter your name");
            userName.requestFocus();
            return;
        }
        if(phone.isEmpty())
        {
            userPhn.setError("Enter your Phone Number");
            userPhn.requestFocus();
            return;
        }

        if (email.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            userEmail.setError("Enter Valid Email");
            userEmail.requestFocus();
            return;
        }
        if (password.length() < 6) {
            userPass.setError("Password length should be more than 6");
            userPass.requestFocus();
            return;

        }
        if(confPassword.isEmpty()||!confPassword.equals(password))
        {
            userConPass.setError("Password does not match");
            userConPass.requestFocus();
            return;

        }
        progressBar.setVisibility( View.VISIBLE );
        signupButton.setVisibility( View.INVISIBLE );
        mAuth.createUserWithEmailAndPassword( email,password ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    final FirebaseUser crntuser =  mAuth.getCurrentUser();
                    crntuser.sendEmailVerification().addOnSuccessListener( new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                            final String userID = mAuth.getCurrentUser().getUid();
                            newUser user = new newUser(name,phone,email,userID );

                            veriiedUser = FirebaseDatabase.getInstance().getReference("Users").child( FirebaseAuth.getInstance().
                                    getCurrentUser().getUid() );

                            FirebaseDatabase.getInstance().getReference("Users").child( FirebaseAuth.getInstance().
                                    getCurrentUser().getUid() ).setValue(user ).addOnCompleteListener( new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){

                                        Toast.makeText(RegistrationPage.this,"Sign up Successful!",Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.INVISIBLE );
                                        signupButton.setVisibility( View.VISIBLE );

                                        //email authentication
                                        Toast.makeText(RegistrationPage.this, "Verification has sent", Toast.LENGTH_SHORT).show();
                                        mAuth.signOut();
                                        Intent intent = new Intent(RegistrationPage.this, SignIn.class);
                                        startActivity(intent);
                                        finish();

                                    }
                                    else {
                                        Toast.makeText(RegistrationPage.this,"Sign up Failed!",Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.INVISIBLE );
                                        signupButton.setVisibility( View.VISIBLE );
                                    }
                                }
                            } );


                        }
                    } ).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(RegistrationPage.this, "Enter a correct email", Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                else {
                    Toast.makeText(RegistrationPage.this,"Sign up Failed!",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE );
                    signupButton.setVisibility( View.VISIBLE );
                }
            }
        } );


    }

}
