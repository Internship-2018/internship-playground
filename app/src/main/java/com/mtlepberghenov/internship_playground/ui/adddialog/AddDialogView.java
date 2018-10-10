package com.mtlepberghenov.internship_playground.ui.adddialog;

import android.support.annotation.StringRes;

public interface AddDialogView {

  void setOnAddDialogHandler(AddDialogClickHandler clickHandler);

  void showMessage(@StringRes int stringRes);

  void clear();
}
