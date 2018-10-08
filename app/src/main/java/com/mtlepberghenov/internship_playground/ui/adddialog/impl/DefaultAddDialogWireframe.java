package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.support.v4.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogWireframe;

public class DefaultAddDialogWireframe implements AddDialogWireframe {

  private final FragmentActivity activity;
  private NavController navController;

  public DefaultAddDialogWireframe(FragmentActivity activity) {
    this.activity = activity;
    navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
  }

  @Override public void onClose() {
    navController.navigate(R.id.welcomeFragment);
  }
}
