package com.mtlepberghenov.internship_playground.ui.dashboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mtlepberghenov.internship_playground.networking.state.DefaultNetworkChecker;
import com.mtlepberghenov.internship_playground.networking.state.NetworkChecker;
import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.dao.impl.DefaultDaoVehicle;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.storage.datasource.impl.DefaultDbHelper;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboardView;

public class DashboardFragment extends Fragment {

  private DashboardNativeView nativeView;
  private DashboardPresenter presenter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final DefaultDashboardView view = new DefaultDashboardView();
    nativeView = view;
    final DashboardAdapter adapter = new DefaultDashboardAdapter();

    final DbHelper dbHelper = DefaultDbHelper.getInstance(getContext());
    final DaoVehicle daoVehicle = new DefaultDaoVehicle(dbHelper);

    final DashboardModel model = new DefaultDashboardModel(daoVehicle);
    final NetworkChecker networkChecker = new DefaultNetworkChecker(getContext());
    presenter = new DefaultDashboardPresenter(view, model, adapter, networkChecker);
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
