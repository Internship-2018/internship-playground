package com.mghelas.internship_playground.ui.startscreen;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.ui.startscreen.impl.StartPresenterImpl;
import com.mghelas.internship_playground.ui.startscreen.impl.StartViewImpl;
import com.mghelas.internship_playground.ui.startscreen.impl.StartWireframeImpl;

public class StartFragment extends Fragment {

    StartNativeView startNativeView;
    StartPresenter startPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final StartViewImpl view = new StartViewImpl();
        startNativeView = view;
        startPresenter = new StartPresenterImpl(view, new StartWireframeImpl(this));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(startNativeView.getLayout(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startNativeView.initView(this);
        startPresenter.onViewInitialised();
    }


}
