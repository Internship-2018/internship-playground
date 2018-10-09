package com.mghelas.internship_playground.sweetscreen.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.sweetscreen.add.impl.SweetAddModelImpl;
import com.mghelas.internship_playground.sweetscreen.add.impl.SweetAddPresenterImpl;
import com.mghelas.internship_playground.sweetscreen.add.impl.SweetAddViewImpl;
import com.mghelas.internship_playground.sweetscreen.add.impl.SweetAddWireframeImpl;

public class SweetAddFragment extends Fragment {

    SweetAddModel sweetAddModel;
    SweetAddNativeView sweetAddNativeView;
    SweetAddPresenter sweetAddPresenter;
    SweetAddWireframe sweetAddWireframe;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sweetAddModel = new SweetAddModelImpl();
        SweetAddViewImpl sweetAddView = new SweetAddViewImpl();
        sweetAddNativeView = sweetAddView;
        sweetAddWireframe = new SweetAddWireframeImpl(this);

        sweetAddPresenter = new SweetAddPresenterImpl(sweetAddView, sweetAddModel, sweetAddWireframe);
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
