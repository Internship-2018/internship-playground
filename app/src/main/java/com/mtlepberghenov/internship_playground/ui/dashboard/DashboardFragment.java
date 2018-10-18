package com.mtlepberghenov.internship_playground.ui.dashboard;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mtlepberghenov.internship_playground.api.ApiUtils;
import com.mtlepberghenov.internship_playground.api.NetworkClient;
import com.mtlepberghenov.internship_playground.api.impl.DefaultNetworkClient;
import com.mtlepberghenov.internship_playground.networking.state.DefaultNetworkChecker;
import com.mtlepberghenov.internship_playground.networking.state.NetworkChecker;
import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.dao.impl.DefaultDaoVehicle;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.storage.datasource.impl.DefaultDbHelper;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboardBroadcastReceiver;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.impl.DefaultDashboardView;
import com.mtlepberghenov.internship_playground.ui.dialog.impl.DefaultDialogBroadcast;

public class DashboardFragment extends Fragment {

  private DashboardNativeView nativeView;
  private DashboardPresenter presenter;
  private DefaultDashboardBroadcastReceiver broadcastReceiver;
  private IntentFilter intentFilter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final DefaultDashboardView view = new DefaultDashboardView();
    nativeView = view;
    final DashboardAdapter adapter = new DefaultDashboardAdapter();
    final DbHelper dbHelper = DefaultDbHelper.getInstance(getContext());
    final NetworkClient networkClient = DefaultNetworkClient.getInstance(ApiUtils.BASE_URL);
    final DaoVehicle daoVehicle = DefaultDaoVehicle.getInstance(dbHelper);
    final DashboardModel model = new DefaultDashboardModel(networkClient, daoVehicle);
    final NetworkChecker networkChecker = new DefaultNetworkChecker(getContext());
    broadcastReceiver = new DefaultDashboardBroadcastReceiver();
    intentFilter = new IntentFilter(DefaultDialogBroadcast.ACTION);
    presenter = new DefaultDashboardPresenter(view, model, adapter, networkChecker, broadcastReceiver);
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(nativeView.getLayout(), container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    nativeView.initView(getActivity());
    presenter.onViewInitialised();
    super.onViewCreated(view, savedInstanceState);
  }

  @Override public void onResume() {
    LocalBroadcastManager
        .getInstance(getContext())
        .registerReceiver(broadcastReceiver, intentFilter);
    super.onResume();
  }

  @Override public void onPause() {
    LocalBroadcastManager
        .getInstance(getContext())
        .unregisterReceiver(broadcastReceiver);
    super.onPause();
  }
}
