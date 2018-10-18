package com.mtlepberghenov.internship_playground.ui.dialog.impl;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogWireframe;
import com.mtlepberghenov.internship_playground.ui.start.StartActivity;

public class DefaultDialogWireframe implements DialogWireframe {

  private FragmentActivity activity;

  public DefaultDialogWireframe(FragmentActivity activity) {
    this.activity = activity;
  }

  @Override public void close() {
    DialogFragment fragment =
        (DialogFragment) activity.getSupportFragmentManager().findFragmentByTag(StartActivity.TAG);

    if (fragment != null) {
      fragment.dismiss();
    }
  }
}
