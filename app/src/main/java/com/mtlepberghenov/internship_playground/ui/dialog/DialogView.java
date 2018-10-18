package com.mtlepberghenov.internship_playground.ui.dialog;

import android.support.annotation.StringRes;

public interface DialogView {

  void setOnAddDialogHandler(DialogClickHandler handler);

  void clear();

  void showMessage(@StringRes int stringRes);
}
