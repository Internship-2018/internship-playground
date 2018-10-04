package com.mtlepberghenov.internship_playground.screens.vehiclelist.view;

import com.mtlepberghenov.internship_playground.base.BaseView;
import com.mtlepberghenov.internship_playground.model.entity.Vehicle;
import java.util.ArrayList;

public interface VehicleListView extends BaseView {

  void onSetData(ArrayList<Vehicle> carList);
}
