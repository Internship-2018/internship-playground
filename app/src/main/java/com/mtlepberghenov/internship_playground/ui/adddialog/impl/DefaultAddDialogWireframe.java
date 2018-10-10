package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogWireframe;
import com.mtlepberghenov.internship_playground.ui.welcome.impl.DefaultWelcomeWireFrame;

public class DefaultAddDialogWireframe implements AddDialogWireframe {

  private final FragmentActivity activity;

  public DefaultAddDialogWireframe(FragmentActivity activity) {
    this.activity = activity;
  }

  @Override public void onClose() {
    DialogFragment fragment = (DialogFragment) activity
        .getSupportFragmentManager()
        .findFragmentByTag(DefaultWelcomeWireFrame.TAG);

    if (fragment != null) {
      fragment.dismiss();
    }
  }
}
