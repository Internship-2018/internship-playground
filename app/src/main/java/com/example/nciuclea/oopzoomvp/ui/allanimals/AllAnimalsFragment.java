package com.example.nciuclea.oopzoomvp.ui.allanimals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.DefaultAllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.DefaultAllAnimalsPresenter;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.DefaultAllAnimalsView;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.DefaultAllAnimalsWireFrame;
import com.example.nciuclea.oopzoomvp.ui.allanimals.impl.DefaultDBLoaderCallback;
import com.example.nciuclea.oopzoomvp.ui.allanimals.loaders.DBDataLoader;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
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
        DefaultAllAnimalsModel defaultAllAnimalsModel = new DefaultAllAnimalsModel(dbDataLoader);
        listLoaderCallbacks = new DefaultDBLoaderCallback(dbDataLoader, defaultAllAnimalsModel);
        LoaderManager.getInstance(this).initLoader(LOADER_ID, null, listLoaderCallbacks);

        //creating Presenter (with Model and WireFrame inside)
        DefaultAllAnimalsPresenter defaultAllAnimalsPresenter = new DefaultAllAnimalsPresenter(
                view, defaultAllAnimalsModel, new DefaultAllAnimalsWireFrame(this));
        allAnimalsPresenter = defaultAllAnimalsPresenter;
        defaultAllAnimalsModel.setModelUpdatedCallback(defaultAllAnimalsPresenter);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("FRAGMENT_LIFECYCLE", "onCreateView()");

        // Inflate the layout for this fragment
        View view = inflater.inflate(allAnimalsNativeView.getLayout(), container, false);
        allAnimalsNativeView.initView(view);
        allAnimalsNativeView.setOnClickHandler(allAnimalsPresenter);
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
