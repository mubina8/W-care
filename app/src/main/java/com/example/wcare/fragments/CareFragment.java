package com.example.wcare.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wcare.R;
import com.example.wcare.hygiene;
import com.example.wcare.pregnancy;

/**
 * A simple {@link Fragment} subclass.
 */
public class CareFragment extends Fragment {

    Button hyginebutton,pregnancyButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate( R.layout.fragment_care, container, false );

        //mubina code here

        hyginebutton = v.findViewById( R.id.hygieneId );
        hyginebutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent hygineIntent = new Intent( getContext(), hygiene.class );
                startActivity( hygineIntent );
                getActivity().finish();
            }
        } );

        pregnancyButton = v.findViewById( R.id.pregnancyId );
        pregnancyButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pregnencyIntent = new Intent( getContext(), pregnancy.class );
                startActivity( pregnencyIntent );
                getActivity().finish();

            }
        } );

        return v;
    }

}
