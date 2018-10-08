package com.example.nciuclea.oopzoomvp.ui.allAnimals.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;

import com.example.nciuclea.oopzoomvp.R;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultAllAnimalsView implements AllAnimalsView, AllAnimalsNativeView {

    RecyclerView recyclerView;
    private AnimalsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;

    public DefaultAllAnimalsView(Context context) {
        this.context = context;
    }

    void setOnClickHandler(AllAnimalsClickHandler allAnimalsClickHandler) {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_all_animals;
    }

    @Override
    public void initView(View view) {
        recyclerView = view.findViewById(R.id.all_animals_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AnimalsAdapter(context, new ArrayList<DBAnimal>());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateData(List<DBAnimal> animalList) {
        adapter.updateData(animalList);
    }
}
