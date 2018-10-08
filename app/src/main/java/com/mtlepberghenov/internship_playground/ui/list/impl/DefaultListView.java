package com.mtlepberghenov.internship_playground.ui.list.impl;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.list.VehicleListAdapter;
import com.mtlepberghenov.internship_playground.ui.list.ListNativeView;
import com.mtlepberghenov.internship_playground.ui.list.ListView;
import com.mtlepberghenov.internship_playground.ui.list.entity.Vehicle;
import java.util.List;

public class DefaultListView implements ListNativeView, ListView {

  private VehicleListAdapter adapter;
  @BindView(R.id.recycler_view) RecyclerView recyclerView;

  @Override public int getLayout() {
    return R.layout.fragment_vehicle_list;
  }

  @Override public void initView(FragmentActivity activity) {
    ButterKnife.bind(this, activity);
    recyclerView.setHasFixedSize(true);
    LinearLayoutManager manager = new LinearLayoutManager(activity);
    recyclerView.setLayoutManager(manager);

    DividerItemDecoration decoration =
        new DividerItemDecoration(recyclerView.getContext(), manager.getOrientation());
    recyclerView.addItemDecoration(decoration);

    adapter = new VehicleListAdapter();
    recyclerView.setAdapter(adapter);
  }

  @Override public void setData(List<Vehicle> vehicles) {
    adapter.setData(vehicles);
  }
}
