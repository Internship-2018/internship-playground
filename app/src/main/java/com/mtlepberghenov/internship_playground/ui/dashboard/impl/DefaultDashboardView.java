package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardAdapter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardNativeView;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardRefreshHandler;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;
import com.mtlepberghenov.internship_playground.ui.dashboard.DefaultDashboardAdapter;
import java.util.List;

public class DefaultDashboardView implements DashboardNativeView, DashboardView {

  private DashboardAdapter adapter;
  private DashboardRefreshHandler refreshHandler;

  @BindView(R.id.dashboard_recycler_view) RecyclerView recyclerView;
  @BindView(R.id.dashboard_swipe_refresh_container) SwipeRefreshLayout swipeContainer;

  @Override public int getLayout() {
    return R.layout.faragment_dashboard;
  }

  @Override public void initView(FragmentActivity activity) {
    ButterKnife.bind(this, activity);
    LinearLayoutManager manager = new LinearLayoutManager(activity);
    DividerItemDecoration decoration =
        new DividerItemDecoration(recyclerView.getContext(), manager.getOrientation());
    recyclerView.addItemDecoration(decoration);
    recyclerView.setLayoutManager(manager);
    recyclerView.setHasFixedSize(true);

    setOnRefreshListener();
  }

  @Override public void setRefreshHandler(DashboardRefreshHandler refreshHandler) {
    this.refreshHandler = refreshHandler;
  }

  @Override public void setAdapter(DashboardAdapter adapter) {
    this.adapter = adapter;
    recyclerView.setAdapter((DefaultDashboardAdapter)adapter);
  }

  @Override public void updateData(List<Vehicle> list) {
    adapter.updateData(list);
  }

  @Override public void showMessage(int stringRes) {
    Snackbar.make(recyclerView, stringRes, Snackbar.LENGTH_LONG).show();
  }

  @Override public void setRefreshingFalse() {
    swipeContainer.setRefreshing(false);
  }

  private void setOnRefreshListener() {
    swipeContainer.setOnRefreshListener(() -> {
      onRefreshed();
    });
  }

  private void onRefreshed() {
    if(refreshHandler != null) {
      refreshHandler.onRefresh();

    }
  }
}
