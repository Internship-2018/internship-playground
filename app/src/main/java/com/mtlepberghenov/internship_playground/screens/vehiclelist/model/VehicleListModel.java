package com.mtlepberghenov.internship_playground.screens.vehiclelist.model;

import com.mtlepberghenov.internship_playground.screens.vehiclelist.model.entity.Vehicle;
import io.reactivex.Single;
import java.util.List;

public interface VehicleListModel {

  Single<List<Vehicle>> getData();
}
