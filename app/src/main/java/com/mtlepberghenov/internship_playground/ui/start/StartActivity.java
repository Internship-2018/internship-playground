package com.mtlepberghenov.internship_playground.ui.start;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.dialog.DefaultDialogFragment;
import javax.inject.Inject;

public class StartActivity extends AppCompatActivity {

  @Inject DefaultDialogFragment fragment;

  @Override protected void onCreate(@Nullable Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_start);
    ButterKnife.bind(this);


    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    navController.setGraph(R.navigation.main_graph);
  }

  @OnClick(R.id.fab)
  public void onClick() {
    //new DefaultDialogFragment().show(getSupportFragmentManager(), TAG);
  }
}
