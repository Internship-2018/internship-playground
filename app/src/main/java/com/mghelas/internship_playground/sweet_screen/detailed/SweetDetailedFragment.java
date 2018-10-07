package com.mghelas.internship_playground.sweet_screen.detailed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.sweet_screen.detailed.impl.SweetDetailedModelImpl;
import com.mghelas.internship_playground.sweet_screen.detailed.impl.SweetDetailedPresenterImpl;
import com.mghelas.internship_playground.sweet_screen.detailed.impl.SweetDetailedViewImpl;
import com.mghelas.internship_playground.sweet_screen.detailed.impl.SweetDetailedWireframeImpl;

import androidx.navigation.Navigation;

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
