package com.mtlepberghenov.internship_playground.ui.welcome.impl;

import android.util.Log;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeFragment;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeWireFrame;

public class DefaultWelcomeWireFrame implements WelcomeWireFrame {

  private final WelcomeFragment welcomeFragment;
  private NavController navController;

  public DefaultWelcomeWireFrame(WelcomeFragment welcomeFragment) {

    this.welcomeFragment = welcomeFragment;
  }

  @Override public void showMainContent() {
    Log.d(DefaultWelcomeWireFrame.class.getSimpleName(), "showMainContent: ");
    navController = Navigation.findNavController(welcomeFragment.getActivity(), R.id.nav_host_fragment);
    navController.navigate(R.id.vehicleListFragment);
  }
}
