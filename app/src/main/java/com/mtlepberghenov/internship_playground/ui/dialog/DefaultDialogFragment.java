package com.mtlepberghenov.internship_playground.ui.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
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
import com.mtlepberghenov.internship_playground.ui.dialog.impl.DefaultDialogBroadcast;
import com.mtlepberghenov.internship_playground.ui.dialog.impl.DefaultDialogModel;
import com.mtlepberghenov.internship_playground.ui.dialog.impl.DefaultDialogPresenter;
import com.mtlepberghenov.internship_playground.ui.dialog.impl.DefaultDialogView;
import com.mtlepberghenov.internship_playground.ui.dialog.impl.DefaultDialogWireframe;

public class DefaultDialogFragment extends DialogFragment {

  private DialogNativeView nativeView;
  private DialogPresenter presenter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final DefaultDialogView view = new DefaultDialogView();
    nativeView = view;
    NetworkClient nc = DefaultNetworkClient.getInstance(ApiUtils.BASE_URL);
    final DbHelper dbHelper = DefaultDbHelper.getInstance(getContext());
    final DaoVehicle dao = DefaultDaoVehicle.getInstance(dbHelper);
    final DialogModel model = new DefaultDialogModel(nc,dao);
    final DialogWireframe wireframe = new DefaultDialogWireframe(getActivity());
    final NetworkChecker networkChecker = new DefaultNetworkChecker(getContext());
    final DialogBroadcast broadcast= new DefaultDialogBroadcast(this);
    presenter = new DefaultDialogPresenter(view, model, wireframe, networkChecker, broadcast);
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(nativeView.getLayout(), container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    nativeView.initView(view);
    presenter.onViewInitialised();
  }
}
