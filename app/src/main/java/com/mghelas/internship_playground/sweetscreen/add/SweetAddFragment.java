package com.mghelas.internship_playground.sweetscreen.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.entity.Ingredient;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.SweetAddReturnCallback;
import com.mghelas.internship_playground.sweetscreen.add.impl.SweetAddModelImpl;
import com.mghelas.internship_playground.sweetscreen.add.impl.SweetAddPresenterImpl;
import com.mghelas.internship_playground.sweetscreen.add.impl.SweetAddViewImpl;
import com.mghelas.internship_playground.sweetscreen.add.impl.SweetAddWireframeImpl;
import com.mghelas.internship_playground.sweetscreen.add.loader.DbIngredientsLoader;
import com.mghelas.internship_playground.sweetscreen.add.loader.IngredientsListCallback;
import com.mghelas.internship_playground.sweetscreen.add.loader.impl.IngredientsLoadCallbackImpl;

import java.util.List;

public class SweetAddFragment extends Fragment {

    private static final int LOADER_ID = 1003;
    SweetAddModelImpl sweetAddModel;
    SweetAddNativeView sweetAddNativeView;
    SweetAddPresenter sweetAddPresenter;
    SweetAddWireframe sweetAddWireframe;
    SweetAddReturnCallback sweetAddReturnCallback;
    DbIngredientsLoader dbIngredientsLoader;
    IngredientsListCallback ingredientsListCallback;

    protected LoaderManager.LoaderCallbacks<List<Ingredient>> ingredientsLoaderCallbacks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SweetAddViewImpl sweetAddView = new SweetAddViewImpl();
        sweetAddNativeView = sweetAddView;
        sweetAddWireframe = new SweetAddWireframeImpl(this);
        dbIngredientsLoader = new DbIngredientsLoader(getContext());
        sweetAddModel = new SweetAddModelImpl(dbIngredientsLoader);

        sweetAddPresenter = new SweetAddPresenterImpl(sweetAddView, sweetAddModel, sweetAddWireframe);
        sweetAddReturnCallback = sweetAddPresenter;
        ingredientsListCallback = sweetAddPresenter;
        sweetAddModel.setOnSweetAddReturnCallback(sweetAddReturnCallback);
        sweetAddModel.setIngredientsListCallback(ingredientsListCallback);
        ingredientsLoaderCallbacks = new IngredientsLoadCallbackImpl(dbIngredientsLoader, sweetAddModel);

        LoaderManager.getInstance(this).initLoader(LOADER_ID, null, ingredientsLoaderCallbacks);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(sweetAddNativeView.getLayout(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sweetAddNativeView.initView(this, sweetAddPresenter);
        sweetAddPresenter.viewInitialized();
    }
}
