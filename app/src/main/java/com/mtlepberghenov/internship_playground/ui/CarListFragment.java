package com.mtlepberghenov.internship_playground.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.mvp.presenter.CarListPresenter;
import com.mtlepberghenov.internship_playground.mvp.presenter.CarListPresenterImpl;
import com.mtlepberghenov.internship_playground.mvp.view.CarListView;

public class CarListFragment extends Fragment implements CarListView {

    private CarListPresenter presenter;

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CarListPresenterImpl();
        presenter.attach(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_car_list, container, false);

        initUI(view);

        return view;
    }

    private void initUI(View view) {
        // TODO: 9/26/2018 Recycler view init
    }
}
