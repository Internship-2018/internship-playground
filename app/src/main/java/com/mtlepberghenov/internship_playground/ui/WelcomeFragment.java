package com.mtlepberghenov.internship_playground.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.mvp.presenter.MainPresenterIml;
import com.mtlepberghenov.internship_playground.mvp.presenter.MainPresenter;
import com.mtlepberghenov.internship_playground.mvp.view.MainView;

public class WelcomeFragment extends Fragment implements MainView {

    private MainPresenter mainPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = new MainPresenterIml();
        mainPresenter.attach(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welocme, container, false);
        initUI(view);
        return view;
    }

    @Override
    public void onStartCarListFragment() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new CarListFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

    private void initUI(View view) {
        view.findViewById(R.id.show_store_btn).setOnClickListener(v -> {
            mainPresenter.onShowStoreBtnClicked();
        });
    }


}
