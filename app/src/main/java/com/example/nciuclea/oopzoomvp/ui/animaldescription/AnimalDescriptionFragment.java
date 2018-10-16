package com.example.nciuclea.oopzoomvp.ui.animaldescription;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nciuclea.oopzoomvp.R;


public class AnimalDescriptionFragment extends Fragment {

    private static final String ARG_ANIMANLID = "animalId";

    // TODO: Rename and change types of parameters
    private int animalId;

    public AnimalDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animalId = getArguments().getInt(ARG_ANIMANLID);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animal_description, container, false);
        TextView tv = view.findViewById(R.id.animalTextView);
        tv.setText(String.valueOf(animalId));
        return view;
    }
}
