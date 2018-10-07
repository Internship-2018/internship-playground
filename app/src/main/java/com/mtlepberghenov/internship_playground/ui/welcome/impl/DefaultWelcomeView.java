package com.mtlepberghenov.internship_playground.ui.welcome.impl;

import android.util.Log;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeClickHandler;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeFragment;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeNativeView;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeView;

public class DefaultWelcomeView implements WelcomeNativeView, WelcomeView {

  private WelcomeClickHandler clickHandler;

  @Override public int getLayout() {
    return R.layout.fragment_welocme;
  }

  @Override public void initView(WelcomeFragment welcomeFragment) {
    ButterKnife.bind(this, welcomeFragment.getActivity());
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
