package com.mtlepberghenov.internship_playground.ui.adddialog;

import android.support.v4.app.FragmentActivity;

public interface AddDialogNativeView {

  int getLayout();

  void initView(FragmentActivity activity);

  int getDialogTitle();
}
