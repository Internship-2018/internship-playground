package com.example.nciuclea.oopzoomvp.ui.allanimals;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.App;
import com.example.nciuclea.oopzoomvp.StateUpdaterService;
import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.*;
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
    private BroadcastReceiver broadcastReceiver;



    public AllAnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = App.getInstance().getDatabaseHelper();
        DefaultAllAnimalsView view = new DefaultAllAnimalsView(getContext());
        allAnimalsNativeView = view;
        allAnimalsPresenter = new DefaultAllAnimalsPresenter(view, new DefaultAllAnimalsModel(db), new DefaultAllAnimalsWireFrame(this));

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                allAnimalsPresenter.onDBUpdateReceive();
            }
        };

        IntentFilter intentFilter = new IntentFilter(StateUpdaterService.BROADCAST_ACTION);
        getActivity().registerReceiver(broadcastReceiver, intentFilter);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(allAnimalsNativeView.getLayout(), container, false);
        allAnimalsNativeView.initView(view);
        allAnimalsNativeView.setOnClickHandler(allAnimalsPresenter);
        allAnimalsPresenter.onViewInitialized();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        getActivity().unregisterReceiver(broadcastReceiver);
    }

}
