package com.example.nciuclea.oopzoomvp.ui.allanimals;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.App;
import com.example.nciuclea.oopzoomvp.StateUpdaterService;
import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.*;
import com.example.nciuclea.oopzoomvp.ui.allanimals.loaders.DBDataLoader;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllAnimalsFragment extends Fragment {

    private static final int LOADER_ID = 13337;
    private AllAnimalsNativeView allAnimalsNativeView;
    private AllAnimalsPresenter allAnimalsPresenter;
    private BroadcastReceiver broadcastReceiver;
    private Loader<List<DBAnimal>> listLoader;
    protected LoaderManager.LoaderCallbacks<List<DBAnimal>> listLoaderCallbacks;

    public AllAnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //creating View
        DefaultAllAnimalsView view = new DefaultAllAnimalsView(getContext());
        allAnimalsNativeView = view;
        //
        DBDataLoader dbDataLoader = new DBDataLoader(getContext());
        listLoader = dbDataLoader;
        DefaultAllAnimalsModel defaultAllAnimalsModel = new DefaultAllAnimalsModel(dbDataLoader);
        listLoaderCallbacks = new DefaultDBLoaderCallback(dbDataLoader, defaultAllAnimalsModel);
        LoaderManager.getInstance(this).initLoader(LOADER_ID, null, listLoaderCallbacks);
        //creating Presenter (with Model and WireFrame inside)
        DefaultAllAnimalsPresenter defaultAllAnimalsPresenter = new DefaultAllAnimalsPresenter(
                view, defaultAllAnimalsModel, new DefaultAllAnimalsWireFrame(this));
        allAnimalsPresenter = defaultAllAnimalsPresenter;
        defaultAllAnimalsModel.setModelUpdatedCallback(defaultAllAnimalsPresenter);
        //Starting Service and registering Broadcast Receiver
        Intent intent = new Intent(getContext(), StateUpdaterService.class).putExtra(StateUpdaterService.UPDATE_INTERVAL, 1000L);
        getActivity().startService(intent);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(allAnimalsNativeView.getLayout(), container, false);
        allAnimalsNativeView.initView(view);
        allAnimalsNativeView.setOnClickHandler(allAnimalsPresenter);
        allAnimalsPresenter.onViewInitialized();
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                allAnimalsPresenter.onDBUpdateReceive();
            }
        };
        IntentFilter intentFilter = new IntentFilter(StateUpdaterService.BROADCAST_ACTION);
        getActivity().registerReceiver(broadcastReceiver, intentFilter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        
        getActivity().unregisterReceiver(broadcastReceiver);
        getActivity().stopService(new Intent(getContext(), StateUpdaterService.class));
    }

}
