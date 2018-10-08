package com.example.nciuclea.oopzoomvp.ui.allAnimals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllAnimalsFragment extends Fragment {

    private AllAnimalsNativeView allAnimalsView;
    private AllAnimalsPresenter allAnimalsPresenter;


    public AllAnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_animals, container, false);
    }

}
