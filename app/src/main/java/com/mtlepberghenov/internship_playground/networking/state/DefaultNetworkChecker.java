package com.mtlepberghenov.internship_playground.networking.state;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class DefaultNetworkChecker implements NetworkChecker {

  private NetworkInfo netInfo;

  public DefaultNetworkChecker(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    netInfo = cm.getActiveNetworkInfo();
  }

  @Override public void check(NetworkState netState) {
    if (netInfo != null && netInfo.isConnected()) {
      netState.onlineState();
    } else {
      netState.offlineState();
    }
  }
}
