package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogClickHandler;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogNativeView;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogView;
import io.reactivex.annotations.NonNull;

public class DefaultAddDialogView implements AddDialogNativeView, AddDialogView {

  @BindView(R.id.dialog_edit_text_type) TextInputEditText typeEditText;
  @BindView(R.id.dialog_edit_text_maker) TextInputEditText makerEditText;
  @BindView(R.id.dialog_edit_text_model) TextInputEditText modelEditText;
  @BindView(R.id.dialog_edit_text_color) TextInputEditText colorEditText;
  @BindView(R.id.dialog_edit_text_year) TextInputEditText yearEditText;

  private AddDialogClickHandler clickHandler;
  private FragmentActivity activity;

  public DefaultAddDialogView(FragmentActivity activity) {
    this.activity = activity;
  }

  @Override public int getLayout() {
    return R.layout.fragment_add_dialog;
  }

  @Override public int getDialogTitle() {
    return R.string.dialog_title;
  }

  @Override public void initView(View v) {
    ButterKnife.bind(this, v);
  }

  @Override public void setOnAddDialogHandler(AddDialogClickHandler clickHandler) {
    this.clickHandler = clickHandler;
  }

  @Override public void showMessage(int stringRes) {
    Toast.makeText(activity.getApplicationContext(), stringRes, Toast.LENGTH_LONG).show();
  }

  @Override public void close() {
    // TODO: 10.10.2018 close dialog fragment
  }

  @OnClick(R.id.dialog_btn_add) void onClickAddBtn() {
    SqlVehicle sqlVehicle = new SqlVehicle(
        typeEditText.getText(),
        makerEditText.getText(),
        modelEditText.getText(),
        colorEditText.getText(),
        yearEditText.getText());
    onAddBtnClicked(sqlVehicle);
  }

  @OnClick(R.id.dialog_btn_cancel) void onClickCancelBtn() {
    onCancelBtnClicked();
  }

  private void onAddBtnClicked(@NonNull SqlVehicle sqlVehicle) {
    if (clickHandler != null) {
      clickHandler.onAddBtnClicked(sqlVehicle);
    }
  }

  private void onCancelBtnClicked() {
    if (clickHandler != null) {
      clickHandler.onCancelBtnClicked();
    }
  }
}
