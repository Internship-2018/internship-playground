package com.example.nciuclea.oopzoomvp.ui.allAnimals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.impl.*;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllAnimalsFragment extends Fragment {

    private AllAnimalsNativeView allAnimalsNativeView;
    private AllAnimalsPresenter allAnimalsPresenter;
    private DatabaseHelper db;
    private List<DBAnimal> animalList;
    private RecyclerView animalsRecyclerView;


    public AllAnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this.getContext());
        DefaultAllAnimalsView view = new DefaultAllAnimalsView(getContext());
        allAnimalsNativeView = view;
        allAnimalsPresenter = new DefaultAllAnimalsPresenter(view, new DefaultAllAnimalsModel(db), new DefaultAllAnimalsWireFrame(this));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(allAnimalsNativeView.getLayout(), container, false);
        allAnimalsNativeView.initView(view);
        allAnimalsPresenter.onViewInitialized();
        return view;
    }

}
