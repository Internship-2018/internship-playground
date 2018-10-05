package com.mghelas.internship_playground.start_screen;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.start_screen.impl.StartPresenterImpl;
import com.mghelas.internship_playground.start_screen.impl.StartViewImpl;
import com.mghelas.internship_playground.start_screen.impl.StartWireframeImpl;

import androidx.navigation.Navigation;

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
