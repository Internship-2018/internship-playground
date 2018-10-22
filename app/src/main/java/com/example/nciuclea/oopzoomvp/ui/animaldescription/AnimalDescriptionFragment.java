package com.example.nciuclea.oopzoomvp.ui.animaldescription;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.R;
import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.impl.DefaultAnimalDescriptionModel;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.impl.DefaultAnimalDescriptionPresenter;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.impl.DefaultAnimalDescriptionView;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.impl.DefaultAnimalDescriptionWireframe;
import com.example.nciuclea.oopzoomvp.util.loaders.DBDataLoader;
import com.example.nciuclea.oopzoomvp.util.loaders.DefaultDBLoaderCallback;

import java.util.List;


public class AnimalDescriptionFragment extends Fragment {

    private static final int LOADER_ID = 13338;
    private AnimalDescriptionNativeView animalDescriptionNativeView;
    private AnimalDescriptionPresenter animalDescriptionPresenter;
    protected LoaderManager.LoaderCallbacks<List<Animal>> listLoaderCallbacks;

    private static final String ARG_ANIMALID = "animalId";

    private int animalId;

    public AnimalDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animalId = getArguments().getInt(ARG_ANIMALID);
        }
        //creating View
        DefaultAnimalDescriptionView view = new DefaultAnimalDescriptionView(getContext());
        animalDescriptionNativeView = view;

        //Creating and initing loader
        DBDataLoader dbDataLoader = new DBDataLoader(getContext());
        DefaultAnimalDescriptionModel defaultAnimalDescriptionModel = new DefaultAnimalDescriptionModel(dbDataLoader);
        listLoaderCallbacks = new DefaultDBLoaderCallback(dbDataLoader, defaultAnimalDescriptionModel);
        LoaderManager.getInstance(this).initLoader(LOADER_ID, null, listLoaderCallbacks);

        //Creating Presenter (WireFrame inside)
        DefaultAnimalDescriptionPresenter defaultAnimalDescriptionPresenter = new DefaultAnimalDescriptionPresenter(
                view, defaultAnimalDescriptionModel, new DefaultAnimalDescriptionWireframe(this), animalId);
        animalDescriptionPresenter = defaultAnimalDescriptionPresenter;
        defaultAnimalDescriptionModel.setDataUpdatedCallback(defaultAnimalDescriptionPresenter);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(animalDescriptionNativeView.getLayout(), container, false);
        animalDescriptionNativeView.initView(view);
        animalDescriptionPresenter.onViewInitialized();
        return view;
    }
}
