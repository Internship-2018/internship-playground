package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.nciuclea.oopzoomvp.R;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultAllAnimalsView implements AllAnimalsView, AllAnimalsNativeView {

    private Context context;
    RecyclerView recyclerView;
    private AllAnimalsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private AllAnimalsClickHandler clickHandler;

    public DefaultAllAnimalsView(Context context) {
        this.context = context;
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
        adapter = new AllAnimalsAdapter(context, new ArrayList<DBAnimal>());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setOnClickHandler(AllAnimalsClickHandler allAnimalsClickHandler) {
        //Should I store clickhandler in View?
        this.clickHandler = allAnimalsClickHandler;
        adapter.setClickHandler(clickHandler);
    }

    @Override
    public void updateData(List<DBAnimal> animalList) {
        adapter.updateData(animalList);
    }
}
