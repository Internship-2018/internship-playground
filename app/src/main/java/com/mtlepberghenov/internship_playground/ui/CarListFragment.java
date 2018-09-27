package com.mtlepberghenov.internship_playground.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.mvp.model.CarMainModelImpl;
import com.mtlepberghenov.internship_playground.mvp.model.entity.Car;
import com.mtlepberghenov.internship_playground.mvp.presenter.CarListPresenter;
import com.mtlepberghenov.internship_playground.mvp.presenter.CarListPresenterImpl;
import com.mtlepberghenov.internship_playground.mvp.view.CarListView;

import java.util.ArrayList;

public class CarListFragment extends Fragment implements CarListView {

    private CarListPresenter presenter;

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CarListPresenterImpl(new CarMainModelImpl());
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
        recyclerView = new RecyclerView(getContext());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        DividerItemDecoration decoration =
                new DividerItemDecoration(recyclerView.getContext(), manager.getOrientation());

        recyclerView.addItemDecoration(decoration);

        presenter.onRecyclerViewIsReady();
    }

    @Override
    public void onSetRecyclerViewAdapter(ArrayList<Car> carList) {

    }
}
