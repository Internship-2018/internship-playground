package com.mtlepberghenov.internship_playground.ui.welcome.impl;

import android.support.v4.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogFragment;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeWireFrame;

public class DefaultWelcomeWireFrame implements WelcomeWireFrame {

  private final FragmentActivity activity;
  private NavController navController;

  public DefaultWelcomeWireFrame(FragmentActivity activity) {
    this.activity = activity;
    navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
  }

  @Override public void showMainContent() {
    navController.navigate(R.id.vehicleListFragment);
  }

  @Override public void showAddContent() {
    new AddDialogFragment().show(activity.getSupportFragmentManager(), "add");
  }
}
