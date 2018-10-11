package com.mtlepberghenov.internship_playground.ui.adddialog.work;

import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;

public interface WorkRequest {
  void doRequest(SqlVehicle sqlVehicle);
}
