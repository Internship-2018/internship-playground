package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jakewharton.rxbinding2.view.RxView;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogClickHandler;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogNativeView;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogView;
import com.mtlepberghenov.internship_playground.ui.list.entity.Car;
import com.mtlepberghenov.internship_playground.ui.list.entity.Vehicle;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import org.reactivestreams.Subscription;

public class DefaultAddDialogView implements AddDialogNativeView, AddDialogView {

  @BindView(R.id.dialog_edit_text_type) TextInputEditText typeEditText;
  @BindView(R.id.dialog_edit_text_model) TextInputEditText modelEditText;
  @BindView(R.id.dialog_edit_text_color) TextInputEditText colorEditText;
  @BindView(R.id.dialog_edit_text_year) TextInputEditText yearEditText;
  @BindView(R.id.dialog_btn_ok) Button buttonOk;
  private AddDialogClickHandler clickHandler;

  // TODO: 10/8/2018 init views using butterKnife

  @Override public int getLayout() {
    return R.layout.fragment_add_dialog;
  }

  @Override public void initView(FragmentActivity activity) {
    ButterKnife.bind(this, activity);
  }

  @Override public void setOnAddDialogHandler(AddDialogClickHandler clickHandler) {
    this.clickHandler = clickHandler;
  }

  @OnClick(R.id.dialog_btn_ok) void onOkBtnClick(){
    SqlVehicle sqlVehicle = new SqlVehicle(typeEditText.getText(),
                                            modelEditText.getText(),
                                            colorEditText.getText(),
                                            yearEditText.getText());
    onOkBtnClicked(sqlVehicle);
  }

  @OnClick(R.id.dialog_btn_cancel) void onCancelBtnClick() {
    onCancelBtnClicked();
  }

  private void onOkBtnClicked(SqlVehicle sqlVehicle) {
    if (clickHandler != null) {
      clickHandler.onOkBtnClicked(sqlVehicle);
    }
  }

  private void onCancelBtnClicked() {
    if (clickHandler != null) {
      clickHandler.onCancelBtnClicked();
    }
  }
}
