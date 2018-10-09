package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.support.v4.app.FragmentActivity;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogWireframe;

public class DefaultAddDialogWireframe implements AddDialogWireframe {

  private final FragmentActivity activity;

  public DefaultAddDialogWireframe(FragmentActivity activity) {
    this.activity = activity;
  }

  @Override public void onClose() {

  }
}
