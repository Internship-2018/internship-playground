package com.mtlepberghenov.internship_playground.ui.dashboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboardView;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboatdModel;

public class DashboardFragment extends Fragment {

  private DashboardNativeView nativeView;
  private DashboardAdapter adapter;
  private DashboardPresenter presenter;
  private DashboardModel model;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final DefaultDashboardView view = new DefaultDashboardView();
    nativeView = view;
    model = new DefaultDashboatdModel();
    presenter = new DefaultDashboardPresenter(view, model);
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(nativeView.getLayout(), container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    nativeView.initView(getActivity());
    presenter.onViewInitialised();
  }
}
