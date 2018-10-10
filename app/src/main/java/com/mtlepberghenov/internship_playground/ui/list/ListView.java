package com.mtlepberghenov.internship_playground.ui.list;

import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import java.util.List;

public interface ListView {

  void setData(List<SqlVehicle> vehicleList);
}
