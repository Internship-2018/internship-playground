package com.mtlepberghenov.internship_playground.ui.dialog.impl;

import android.view.View;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogClickHandler;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogNativeView;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogView;

public class DefaultDialogView implements DialogNativeView, DialogView {

  private DialogClickHandler clickHandler;

  @Override public int getLayout() {
    return R.layout.fragment_dialog;
  }

  @Override public void initView(View view) {
    ButterKnife.bind(this, view);
  }

  @Override public void setOnAddDialogHandler(DialogClickHandler clickHandler) {
    this.clickHandler = clickHandler;
  }
}
