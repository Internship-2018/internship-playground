package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardAdapter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardNativeView;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;
import com.mtlepberghenov.internship_playground.ui.dashboard.DefaultDashboardAdapter;

public class DefaultDashboardView implements DashboardNativeView, DashboardView {

  private DashboardAdapter adapter;

  @BindView(R.id.dashboard_recycler_view) RecyclerView recyclerView;

  @Override public int getLayout() {
    return R.layout.faragment_dashboard;
  }

  @Override public void initView(FragmentActivity activity) {
    ButterKnife.bind(this, activity);
  }

  @Override public void setAdapter(DashboardAdapter adapter) {
    this.adapter = adapter;
    recyclerView.setAdapter((DefaultDashboardAdapter)adapter);
  }
}
