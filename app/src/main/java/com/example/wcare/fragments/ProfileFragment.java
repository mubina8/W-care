package com.example.wcare.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wcare.Adding_post;
import com.example.wcare.Classes.newUser;
import com.example.wcare.R;
import com.example.wcare.SignIn;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    Button UserLogout;
    TextView nameofUser,phnOfUser,emailOfUser;


    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference userdatabase;
    String userId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate( R.layout.fragment_profile, container, false );

        //name_user = v.findViewById( R.id.uname );
        //final newUser details = mdata
        //name_user.setText(v.getNa);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        nameofUser = v.findViewById( R.id.nametextView );
        emailOfUser = v.findViewById( R.id.emailtextView );
        phnOfUser = v.findViewById( R.id.phntextView );

        UserLogout = v.findViewById( R.id.logoutButton );
        UserLogout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();
                Intent intent = new Intent(getContext(), SignIn.class);
                startActivity(intent);
                getActivity().finish();
            }
        } );


        userdatabase = FirebaseDatabase.getInstance().getReference("Users");
        userId = user.getUid();

        userdatabase.child( userId ).addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                newUser userdetails = snapshot.getValue(newUser.class);

                    String fullName = userdetails.nameUser;
                    String phn = userdetails.phnUser;
                    String email = userdetails.emailUser;

                    nameofUser.setText( fullName );
                    phnOfUser.setText( phn );
                    emailOfUser.setText( email );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText( getContext(),"Please accept for required permission",Toast.LENGTH_SHORT).show();

            }
        } );

        return v;
    }

}
