package com.mtlepberghenov.internship_playground.ui.start;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.dialog.DefaultDialogFragment;
import timber.log.Timber;

public class StartActivity extends AppCompatActivity {

  public static final String TAG = "DefaultDialogFragment";

  @Override protected void onCreate(@Nullable Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_start);
    ButterKnife.bind(this);

    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    navController.setGraph(R.navigation.main_graph);
  }

  @OnClick(R.id.fab)
  public void onClick() {
    Timber.d("fab onClick");
    new DefaultDialogFragment().show(getSupportFragmentManager(), TAG);
  }
}
