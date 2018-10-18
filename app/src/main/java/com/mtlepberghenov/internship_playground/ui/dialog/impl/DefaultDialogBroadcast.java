package com.mtlepberghenov.internship_playground.ui.dialog.impl;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.mtlepberghenov.internship_playground.ui.dialog.DefaultDialogFragment;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogBroadcast;

public class DefaultDialogBroadcast implements DialogBroadcast {

  public static final String ACTION = "com.mtlepberghenov.internship_playground.data-changed";

  private LocalBroadcastManager bm;

  public DefaultDialogBroadcast(DefaultDialogFragment fragment) {
    if (fragment.getContext() != null) {
      bm = LocalBroadcastManager.getInstance(fragment.getContext());
    }
  }

  @Override public void send() {
    Intent i = new Intent();
    i.setAction(ACTION);
    bm.sendBroadcast(i);
  }
}
