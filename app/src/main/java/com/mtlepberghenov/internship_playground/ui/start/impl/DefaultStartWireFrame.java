package com.mtlepberghenov.internship_playground.ui.start.impl;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.start.StartActivity;
import com.mtlepberghenov.internship_playground.ui.start.StartWireFrame;

public class DefaultStartWireFrame implements StartWireFrame {

  private final StartActivity startActivity;
  private NavController navController;

  public DefaultStartWireFrame(StartActivity startActivity) {
    this.startActivity = startActivity;
  }

  @Override public void showStartContent() {
    navController = Navigation.findNavController(startActivity, R.id.nav_host_fragment);
    navController.setGraph(R.navigation.main_graph);
  }
}
