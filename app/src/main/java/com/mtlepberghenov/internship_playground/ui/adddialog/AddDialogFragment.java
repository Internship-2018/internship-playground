package com.mtlepberghenov.internship_playground.ui.adddialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mtlepberghenov.internship_playground.ui.adddialog.impl.DefaultAddDialogModel;
import com.mtlepberghenov.internship_playground.ui.adddialog.impl.DefaultAddDialogPresenter;
import com.mtlepberghenov.internship_playground.ui.adddialog.impl.DefaultAddDialogView;
import com.mtlepberghenov.internship_playground.ui.adddialog.impl.DefaultAddDialogWireframe;

public class AddDialogFragment extends DialogFragment {

  AddDialogNativeView nativeView;
  AddDialogPresenter presenter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DefaultAddDialogView view = new DefaultAddDialogView(getActivity());
    nativeView = view;
    presenter = new DefaultAddDialogPresenter(view, new DefaultAddDialogModel(dataFetcher),
        new DefaultAddDialogWireframe(getActivity()));
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(nativeView.getLayout(), container, false);
    getDialog().setTitle(nativeView.getDialogTitle());
    return v;
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    nativeView.initView(view);
    presenter.onViewInitialised();
  }
}
