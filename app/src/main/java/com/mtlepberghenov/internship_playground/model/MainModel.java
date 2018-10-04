package com.mtlepberghenov.internship_playground.model;

import com.mtlepberghenov.internship_playground.model.entity.Vehicle;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;

public interface MainModel {

  ArrayList<Vehicle> getVehicleList();

  Single<List<Vehicle>> getData();
}
