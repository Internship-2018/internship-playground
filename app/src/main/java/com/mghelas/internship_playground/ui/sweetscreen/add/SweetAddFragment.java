package com.mghelas.internship_playground.ui.sweetscreen.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.network.NetworkConectivity;
import com.mghelas.internship_playground.network.NetworkConnectivityImpl;
import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.network.sweet.SweetServiceCallImpl;
import com.mghelas.internship_playground.storage.dao.impl.IngredientDaoImpl;
import com.mghelas.internship_playground.storage.dao.impl.SweetDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.IngredientDao;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.SweetAddReturnCallback;
import com.mghelas.internship_playground.ui.sweetscreen.add.impl.SweetAddModelImpl;
import com.mghelas.internship_playground.ui.sweetscreen.add.impl.SweetAddPresenterImpl;
import com.mghelas.internship_playground.ui.sweetscreen.add.impl.SweetAddViewImpl;
import com.mghelas.internship_playground.ui.sweetscreen.add.impl.SweetAddWireframeImpl;
import com.mghelas.internship_playground.ui.sweetscreen.add.loader.DbIngredientsLoader;
import com.mghelas.internship_playground.ui.sweetscreen.add.loader.IngredientsListCallback;
import com.mghelas.internship_playground.ui.sweetscreen.add.loader.impl.IngredientsLoadCallbackImpl;

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
    DbHelper dbHelper;
    SweetDao sweetDao;
    IngredientDao ingredientDao;
    SweetServiceCall sweetServiceCall;
    NetworkConectivity networkConectivity;

    protected LoaderManager.LoaderCallbacks<List<Ingredient>> ingredientsLoaderCallbacks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = DbHelper.getInstance(getContext());
        sweetDao = new SweetDaoImpl(dbHelper);
        ingredientDao = new IngredientDaoImpl(dbHelper);
        SweetAddViewImpl sweetAddView = new SweetAddViewImpl();
        sweetAddNativeView = sweetAddView;
        sweetAddWireframe = new SweetAddWireframeImpl(this);
        dbIngredientsLoader = new DbIngredientsLoader(getContext(), ingredientDao);
        sweetAddModel = new SweetAddModelImpl(dbIngredientsLoader, sweetDao);
        sweetServiceCall = new SweetServiceCallImpl(sweetAddModel);
        sweetAddModel.setSweetServiceCall(sweetServiceCall);
        networkConectivity = new NetworkConnectivityImpl();
        sweetAddPresenter = new SweetAddPresenterImpl(sweetAddView, sweetAddModel, sweetAddWireframe, networkConectivity);
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
