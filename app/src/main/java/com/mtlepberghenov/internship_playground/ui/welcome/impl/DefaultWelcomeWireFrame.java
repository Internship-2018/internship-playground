package com.mtlepberghenov.internship_playground.ui.welcome.impl;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeFragment;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeWireFrame;

public class DefaultWelcomeWireFrame implements WelcomeWireFrame {

  private final FragmentActivity welcomeFragment;
  private NavController navController;

  public DefaultWelcomeWireFrame(FragmentActivity welcomeFragment) {
    this.welcomeFragment = welcomeFragment;
    navController = Navigation.findNavController(welcomeFragment, R.id.nav_host_fragment);
  }

  @Override public void showMainContent() {
    navController.navigate(R.id.vehicleListFragment);
  }

  @Override public void showAddContent() {
    navController.navigate(R.id.addDialogFragment);
  }
}
