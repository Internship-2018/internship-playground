package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardNativeView;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;

public class DefaultDashboardView implements DashboardNativeView, DashboardView {

  @BindView(R.id.dashboard_recycler_view) RecyclerView recyclerView;

  @Override public int getLayout() {
    return R.layout.faragment_dashboard;
  }

  @Override public void initView(FragmentActivity activity) {
    ButterKnife.bind(this, activity);
  }
}
