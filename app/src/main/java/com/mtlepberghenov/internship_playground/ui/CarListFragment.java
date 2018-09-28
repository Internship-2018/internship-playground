package com.mtlepberghenov.internship_playground.ui;

import android.content.Context;
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
import com.mtlepberghenov.internship_playground.ui.adapter.CarListAdapter;

import java.util.ArrayList;

public class CarListFragment extends Fragment implements CarListView {

    private CarListPresenter presenter;

    private RecyclerView recyclerView;

    private CarListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CarListPresenterImpl(new CarMainModelImpl());
        presenter.attach(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initUI(view);
    }

    private void initUI(View v) {
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        DividerItemDecoration decoration =
                new DividerItemDecoration(recyclerView.getContext(), manager.getOrientation());

        recyclerView.addItemDecoration(decoration);

        adapter = new CarListAdapter();
        recyclerView.setAdapter(adapter);
        presenter.onRecyclerViewIsReady();
    }

    @Override
    public void setCarListToAdapter(ArrayList<Car> carList) {
        adapter.setData(carList);
    }
}
