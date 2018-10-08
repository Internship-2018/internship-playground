package com.mtlepberghenov.internship_playground.ui.welcome.impl;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeClickHandler;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeNativeView;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeView;

public class DefaultWelcomeView implements WelcomeNativeView, WelcomeView {

  private WelcomeClickHandler clickHandler;

  @Override public int getLayout() {
    return R.layout.fragment_welocme;
  }

  @Override public void initView(FragmentActivity fragmentActivity) {
    ButterKnife.bind(this, fragmentActivity);
  }

  @Override public void setOnWelcomeHandler(WelcomeClickHandler clickHandler) {
    this.clickHandler = clickHandler;
  }

  @OnClick(R.id.show_store_btn)
  public void onClick() {
    Log.d(DefaultWelcomeView.class.getSimpleName(), "onClick: ");
    onWelcomeClicked();
  }

  private void onWelcomeClicked() {
    Log.d(DefaultWelcomeView.class.getSimpleName(), "onWelcomeClicked: " + clickHandler);
    if (clickHandler != null) {
      clickHandler.onWelcomeClicked();
    }
  }
}
