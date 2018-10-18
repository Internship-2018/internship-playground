package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.nciuclea.oopzoomvp.R;
import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsClickHandler;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsNativeView;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsRefreshHandler;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsView;

import java.util.ArrayList;
import java.util.List;

public class DefaultAllAnimalsView implements AllAnimalsView, AllAnimalsNativeView {

    private Context context;
    private RecyclerView recyclerView;
    private AllAnimalsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AllAnimalsClickHandler clickHandler;
    private AllAnimalsRefreshHandler refreshHandler;

    public DefaultAllAnimalsView(Context context) {
        this.context = context;
    }

    @Override
    public int getLayout() { return R.layout.fragment_all_animals; }

    @Override
    public void initView(View view) {
        recyclerView = view.findViewById(R.id.all_animals_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AllAnimalsAdapter(context, new ArrayList<Animal>());
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = view.findViewById(R.id.swiperefresh_allanimals);
    }

    @Override
    public void setOnClickHandler(AllAnimalsClickHandler allAnimalsClickHandler) {
        //Should I store clickhandler in View?
        this.clickHandler = allAnimalsClickHandler;
        adapter.setClickHandler(clickHandler);
    }

    @Override
    public void setOnRefreshHandler(AllAnimalsRefreshHandler allAnimalsRefreshHandler) {
        this.refreshHandler = allAnimalsRefreshHandler;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshHandler.onRefresh();
            }
        });
    }

    @Override
    public void updateData(List<Animal> animalList) {
        adapter.updateData(animalList);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showNetworkError(String message) {
        Toast networkErrorToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        networkErrorToast.show();
    }
}
