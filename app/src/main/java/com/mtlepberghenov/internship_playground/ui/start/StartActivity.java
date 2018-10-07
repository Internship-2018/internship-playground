package com.mtlepberghenov.internship_playground.ui.start;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.ui.start.impl.DefaultStartPresenter;
import com.mtlepberghenov.internship_playground.ui.start.impl.DefaultStartView;
import com.mtlepberghenov.internship_playground.ui.start.impl.DefaultStartWireFrame;

public class StartActivity extends AppCompatActivity {

  private StartNativeView startNativeView;
  private StartPresenter startPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
    final DefaultStartView view = new DefaultStartView();
    startNativeView = view;
    startPresenter = new DefaultStartPresenter(new DefaultStartWireFrame(this));

    setContentView(startNativeView.getLayout());
  }

  @Override public void onContentChanged() {
    super.onContentChanged();
    startPresenter.onViewInitialised();
  }
}