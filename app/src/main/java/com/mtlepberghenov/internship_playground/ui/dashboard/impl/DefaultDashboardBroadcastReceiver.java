package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardBroadcastReceiver;
import com.mtlepberghenov.internship_playground.ui.dashboard.DataChangeHandler;
import timber.log.Timber;

public class DefaultDashboardBroadcastReceiver extends BroadcastReceiver
    implements DashboardBroadcastReceiver {

  private DataChangeHandler handler;

  @Override public void setDataChangeHandler(DataChangeHandler handler) {
    this.handler = handler;
  }

  @Override public void onReceive(Context context, Intent intent) {
    Timber.d("onReceive");
    handler.onDataChanged();
  }
}