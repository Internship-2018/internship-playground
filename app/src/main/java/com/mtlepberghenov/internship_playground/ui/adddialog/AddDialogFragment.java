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
import com.mtlepberghenov.internship_playground.ui.adddialog.work.WorkRequest;
import com.mtlepberghenov.internship_playground.ui.adddialog.work.impl.DefaultWorkRequest;

public class AddDialogFragment extends DialogFragment {

  private AddDialogNativeView nativeView;
  private AddDialogPresenter presenter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final DefaultAddDialogView view = new DefaultAddDialogView(getActivity());
    final WorkRequest workRequest = new DefaultWorkRequest();
    final AddDialogModel model = new DefaultAddDialogModel(workRequest);
    nativeView = view;
    presenter =
        new DefaultAddDialogPresenter(view, model, new DefaultAddDialogWireframe(getActivity()));
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
