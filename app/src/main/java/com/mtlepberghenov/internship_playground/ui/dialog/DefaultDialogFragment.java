package com.mtlepberghenov.internship_playground.ui.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    final DialogModel model = new DefaultDialogModel();
    final DialogWireframe wireframe = new DefaultDialogWireframe();
    presenter = new DefaultDialogPresenter(view, model, wireframe);
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
