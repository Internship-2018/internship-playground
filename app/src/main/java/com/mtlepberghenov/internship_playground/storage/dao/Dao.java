package com.mtlepberghenov.internship_playground.storage.dao;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;

public interface Dao {

  void insert(Vehicle vehicle);

  List<Vehicle> selectAll();
}
