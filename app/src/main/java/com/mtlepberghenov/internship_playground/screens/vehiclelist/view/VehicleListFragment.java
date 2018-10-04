package com.mtlepberghenov.internship_playground.screens.vehiclelist.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.model.CarMainModelImpl;
import com.mtlepberghenov.internship_playground.model.entity.Vehicle;
import com.mtlepberghenov.internship_playground.screens.vehiclelist.presenter.VehicleListPresenter;
import com.mtlepberghenov.internship_playground.screens.vehiclelist.presenter.VehicleListPresenterImpl;
import java.util.ArrayList;
import java.util.List;

public class VehicleListFragment extends Fragment implements VehicleListView {

  private VehicleListPresenter presenter;
  private VehicleListAdapter adapter;

  @BindView(R.id.recycler_view) RecyclerView recyclerView;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new VehicleListPresenterImpl(new CarMainModelImpl());
    presenter.attach(this);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_car_list, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    initUI();
  }

  private void initUI() {
    recyclerView.setHasFixedSize(true);
    LinearLayoutManager manager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(manager);

    DividerItemDecoration decoration =
        new DividerItemDecoration(recyclerView.getContext(), manager.getOrientation());
    recyclerView.addItemDecoration(decoration);

    adapter = new VehicleListAdapter();
    recyclerView.setAdapter(adapter);
    presenter.onScreenIsReady();
  }

  @Override public void onSetData(List<Vehicle> carList) {
    adapter.setData(carList);
  }

  @Override public void onShowMessage(String text) {
    if (getView() != null) {
      Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
    }
  }
}