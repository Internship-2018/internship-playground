package com.mghelas.internship_playground.sweetscreen.detailed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.detailed.impl.DbDetailedLoaderCallbackImpl;
import com.mghelas.internship_playground.sweetscreen.detailed.impl.DbSweetRemoveLoaderCallbackImpl;
import com.mghelas.internship_playground.sweetscreen.detailed.impl.SweetDetailedModelImpl;
import com.mghelas.internship_playground.sweetscreen.detailed.impl.SweetDetailedPresenterImpl;
import com.mghelas.internship_playground.sweetscreen.detailed.impl.SweetDetailedViewImpl;
import com.mghelas.internship_playground.sweetscreen.detailed.impl.SweetDetailedWireframeImpl;
import com.mghelas.internship_playground.sweetscreen.detailed.loader.DbDetailedLoader;
import com.mghelas.internship_playground.sweetscreen.detailed.loader.RemoveSweetLoader;

public class SweetDetailedFragment extends Fragment {

    private static final int DETAILED_LOADER_ID = 1001;
    private static final int REMOVE_LOADER_ID = 1002;

    SweetDetailedPresenter sweetDetailedPresenter;
    SweetDetailedNativeView sweetDetailedNativeView;
    SweetDetailedModelImpl sweetDetailedModel;
    SweetDetailedWireframe sweetDetailedWireframe;
    SweetDetailedCallback sweetDetailedCallback;
    LoaderManager.LoaderCallbacks<Sweet> detailedLoaderCallback;
    LoaderManager.LoaderCallbacks<Integer> sweetRemoverCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SweetDetailedViewImpl sweetDetailedView = new SweetDetailedViewImpl();

        final DbDetailedLoader dbDetailedLoader = new DbDetailedLoader(getContext());
        final RemoveSweetLoader removeSweetLoader = new RemoveSweetLoader(getContext());

        sweetDetailedModel = new SweetDetailedModelImpl(dbDetailedLoader, removeSweetLoader);

        sweetDetailedWireframe = new SweetDetailedWireframeImpl(this);

        sweetDetailedPresenter = new SweetDetailedPresenterImpl(sweetDetailedView, sweetDetailedWireframe, sweetDetailedModel);

        sweetDetailedNativeView = sweetDetailedView;

        sweetDetailedCallback = sweetDetailedPresenter;
        sweetDetailedModel.setSweetDetailedCallback(sweetDetailedCallback);

        detailedLoaderCallback = new DbDetailedLoaderCallbackImpl(dbDetailedLoader, sweetDetailedModel);
        sweetRemoverCallback = new DbSweetRemoveLoaderCallbackImpl(removeSweetLoader, sweetDetailedModel);

        LoaderManager.getInstance(this).initLoader(DETAILED_LOADER_ID, null, detailedLoaderCallback);
        LoaderManager.getInstance(this).initLoader(REMOVE_LOADER_ID, null, sweetRemoverCallback);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(sweetDetailedNativeView.getLayout(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sweetDetailedNativeView.initView(this, sweetDetailedPresenter);
        sweetDetailedPresenter.onViewInitialised();
    }
}
