package com.example.wcare.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wcare.R;
import com.example.wcare.SignIn;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    Button UserLogout;

    FirebaseAuth mAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate( R.layout.fragment_profile, container, false );

        mAuth = FirebaseAuth.getInstance();

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

        return v;
    }

}
