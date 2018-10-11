package com.mtlepberghenov.internship_playground.ui.start;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.mtlepberghenov.internship_playground.R;

public class StartActivity extends AppCompatActivity {

  private NavController navController;

  @Override protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_start);

    navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    navController.setGraph(R.navigation.main_graph);
  }
}