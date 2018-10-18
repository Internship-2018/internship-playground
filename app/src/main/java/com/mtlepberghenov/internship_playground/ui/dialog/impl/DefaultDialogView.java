package com.mtlepberghenov.internship_playground.ui.dialog.impl;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogClickHandler;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogNativeView;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogView;

public class DefaultDialogView implements DialogNativeView, DialogView {

  private DialogClickHandler clickHandler;

  @BindView(R.id.dialog_edit_text_type) TextInputEditText editTextType;
  @BindView(R.id.dialog_edit_text_manufacturer) TextInputEditText editTextManufacturer;
  @BindView(R.id.dialog_edit_text_model) TextInputEditText editTextModel;
  @BindView(R.id.dialog_edit_text_color) TextInputEditText editTextColor;
  @BindView(R.id.dialog_edit_text_year) TextInputEditText editTextYear;
  @BindView(R.id.dialog_edit_text_im_url) TextInputEditText editTextUrl;

  @Override public int getLayout() {
    return R.layout.fragment_dialog;
  }

  @Override public void initView(View view) {
    ButterKnife.bind(this, view);
  }

  @Override public void setOnAddDialogHandler(DialogClickHandler clickHandler) {
    this.clickHandler = clickHandler;
  }

  @OnClick(R.id.dialog_btn_save) void onClickSave() {
    Vehicle v = new Vehicle();
    v.setType(editTextType.getText().toString());
    v.setManufacturer(editTextManufacturer.getText().toString());
    v.setModel(editTextModel.getText().toString());
    v.setColor(editTextColor.getText().toString());
    v.setYear(editTextYear.getText().toString());
    v.setYear(editTextUrl.getText().toString());
    onClickedSave(v);
  }

  @OnClick(R.id.dialog_btn_cancel) void onClickCancel() {
    onClickedCancel();
  }

  @Override public void clear() {
    editTextType.setText("");
    editTextManufacturer.setText("");
    editTextModel.setText("");
    editTextColor.setText("");
    editTextYear.setText("");
    editTextUrl.setText("");
  }

  @Override public void showMessage(int stringRes) {
    Snackbar.make(editTextColor.getRootView(), stringRes, Snackbar.LENGTH_SHORT).show();
  }

  private void onClickedSave(Vehicle v) {
    if (clickHandler != null) {
      clickHandler.onClickedSave(v);
    }
  }

  private void onClickedCancel() {
    if (clickHandler !=null) {
      clickHandler.onClickedCancel();
    }
  }
}
