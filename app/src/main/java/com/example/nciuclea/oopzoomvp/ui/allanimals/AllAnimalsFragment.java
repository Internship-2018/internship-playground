package com.example.nciuclea.oopzoomvp.ui.allanimals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.storage.datasource.DBHelper;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.DefaultAllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.DefaultAllAnimalsPresenter;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.DefaultAllAnimalsView;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.DefaultAllAnimalsWireFrame;
import com.example.nciuclea.oopzoomvp.util.loaders.DBDataLoader;
import com.example.nciuclea.oopzoomvp.util.loaders.DefaultDBLoaderCallback;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.util.List;

public class AllAnimalsFragment extends Fragment {

    private static final int LOADER_ID = 13337;
    private AllAnimalsNativeView allAnimalsNativeView;
    private AllAnimalsPresenter allAnimalsPresenter;
    protected LoaderManager.LoaderCallbacks<List<Animal>> listLoaderCallbacks;

    public AllAnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FRAGMENT_LIFECYCLE", "onCreate()");

        //creating View
        DefaultAllAnimalsView view = new DefaultAllAnimalsView(getContext());
        allAnimalsNativeView = view;

        //Creating Loader and initing it in LoaderManager
        DBDataLoader dbDataLoader = new DBDataLoader(getContext()); //TODO After screen rotation model looses loader callback
        DBHelper dbHelper = OpenHelperManager.getHelper(getContext(), DBHelper.class);
        DefaultAllAnimalsModel defaultAllAnimalsModel = new DefaultAllAnimalsModel(dbHelper, dbDataLoader);
        listLoaderCallbacks = new DefaultDBLoaderCallback(dbDataLoader, defaultAllAnimalsModel);
        LoaderManager.getInstance(this).initLoader(LOADER_ID, null, listLoaderCallbacks);

        //creating Presenter (WireFrame inside)
        allAnimalsPresenter = new DefaultAllAnimalsPresenter(
                view, defaultAllAnimalsModel, new DefaultAllAnimalsWireFrame(this));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("FRAGMENT_LIFECYCLE", "onCreateView()");

        // Inflate the layout for this fragment
        View view = inflater.inflate(allAnimalsNativeView.getLayout(), container, false);
        allAnimalsNativeView.initView(view);
        allAnimalsNativeView.setOnClickHandler(allAnimalsPresenter);
        allAnimalsNativeView.setOnRefreshHandler(allAnimalsPresenter);
        allAnimalsPresenter.onViewInitialized();
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("FRAGMENT_LIFECYCLE", "onSaveInstanceState()");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FRAGMENT_LIFECYCLE", "onDestroyView()");

    }

}
