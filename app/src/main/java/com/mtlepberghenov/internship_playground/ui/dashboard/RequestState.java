package com.mtlepberghenov.internship_playground.ui.dashboard;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;

public interface RequestState {

  void onResponse(List<Vehicle> list);

  void onFailure();
}
