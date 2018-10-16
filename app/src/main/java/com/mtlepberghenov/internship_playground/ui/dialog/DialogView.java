package com.mtlepberghenov.internship_playground.ui.dialog;

public interface DialogView {
  void setOnAddDialogHandler(DialogClickHandler handler);

  void clear();

  void showMessage();
}
