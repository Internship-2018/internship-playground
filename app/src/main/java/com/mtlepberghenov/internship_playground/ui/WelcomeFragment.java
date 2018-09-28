package com.mtlepberghenov.internship_playground.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.mvp.presenter.MainPresenter;
import com.mtlepberghenov.internship_playground.mvp.presenter.MainPresenterIml;
import com.mtlepberghenov.internship_playground.mvp.view.MainView;

public class WelcomeFragment extends Fragment implements MainView {

    private MainPresenter mainPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = new MainPresenterIml();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welocme, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initUI(view);
        mainPresenter.attach(this);
    }

    @Override
    public void onStartCarListFragment() {
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.main_container);
        if (fragment != null) {
            fragment = new CarListFragment();
            fm.beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
        }
    }

    private void initUI(View view) {
        view.findViewById(R.id.show_store_btn).setOnClickListener(v -> {
            mainPresenter.onShowStoreBtnClicked();
        });
    }


}
