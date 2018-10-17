package com.mtlepberghenov.internship_playground.networking.state;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;

public interface NetworkState {

  void offlineState();

  void onlineState();
}
