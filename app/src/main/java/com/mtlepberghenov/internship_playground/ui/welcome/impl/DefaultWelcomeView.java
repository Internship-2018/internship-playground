package com.mtlepberghenov.internship_playground.ui.welcome.impl;

import android.support.v4.app.FragmentActivity;
import android.view.View;
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

  @Override public void initView(View v) {
    ButterKnife.bind(this, v);
  }

  @Override public void setOnWelcomeHandler(WelcomeClickHandler clickHandler) {
    this.clickHandler = clickHandler;
  }

  @OnClick(R.id.show_store_btn)
  public void onClick() {
    onShowBtnClicked();
  }

  @OnClick(R.id.add_btn)
  public void onAddBtnClick() {
    onAddBtnClicked();
  }

  private void onAddBtnClicked() {
    if (clickHandler !=null) {
      clickHandler.onAddBtnClicked();
    }
  }

  private void onShowBtnClicked() {
    if (clickHandler != null) {
      clickHandler.onShowBtnClicked();
    }
  }
}