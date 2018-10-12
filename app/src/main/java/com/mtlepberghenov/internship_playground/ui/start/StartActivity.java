package com.mtlepberghenov.internship_playground.ui.start;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mtlepberghenov.internship_playground.R;

public class StartActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_start);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.fab)
  public void onClick() {
    // TODO: 10/12/2018 Add some data
  }
}
