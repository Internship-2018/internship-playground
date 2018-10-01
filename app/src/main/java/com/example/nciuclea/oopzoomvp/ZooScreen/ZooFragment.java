package com.example.nciuclea.oopzoomvp.ZooScreen;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.Animal.Animal;
import com.example.nciuclea.oopzoomvp.Animal.Owl;
import com.example.nciuclea.oopzoomvp.Animal.Tiger;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZooFragment extends Fragment implements ZooView {

    private RecyclerView zooRecyclerView;
    private RecyclerView.Adapter zooAdapter;
    private RecyclerView.LayoutManager zooLayoutManager;

    public ZooFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zoo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);
    }

    private void initUI(@NonNull View view) {
        zooRecyclerView = view.findViewById(R.id.zoo_recyclerview);
        zooRecyclerView.setHasFixedSize(true);
        zooLayoutManager = new LinearLayoutManager(view.getContext());
        zooRecyclerView.setLayoutManager(zooLayoutManager);
        //will go to model
        List<Animal> animalList = new ArrayList<Animal>();
        animalList.add(new Tiger());
        animalList.add(new Owl());
        zooAdapter = new ZooAdapter(null);
        ((ZooAdapter) zooAdapter).updateAnimalList(animalList);
        zooRecyclerView.setAdapter(zooAdapter);
    }
}
