package com.mghelas.internship_playground.sweetscreen.detailed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.sweetscreen.detailed.impl.SweetDetailedModelImpl;
import com.mghelas.internship_playground.sweetscreen.detailed.impl.SweetDetailedPresenterImpl;
import com.mghelas.internship_playground.sweetscreen.detailed.impl.SweetDetailedViewImpl;
import com.mghelas.internship_playground.sweetscreen.detailed.impl.SweetDetailedWireframeImpl;

public class SweetDetailedFragment extends Fragment {

    SweetDetailedPresenter sweetDetailedPresenter;
    SweetDetailedNativeView sweetDetailedNativeView;
    SweetDetailedModel sweetDetailedModel;
    SweetDetailedWireframe sweetDetailedWireframe;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SweetDetailedViewImpl sweetDetailedView = new SweetDetailedViewImpl();
        sweetDetailedModel = new SweetDetailedModelImpl();
        sweetDetailedWireframe = new SweetDetailedWireframeImpl(this);
        sweetDetailedNativeView = sweetDetailedView;
        sweetDetailedPresenter = new SweetDetailedPresenterImpl(sweetDetailedView, sweetDetailedWireframe, sweetDetailedModel);
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
