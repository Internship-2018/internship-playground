package com.mtlepberghenov.internship_playground.storage.dao;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;

public interface DaoVehicle extends BaseDao<Vehicle, Integer> {

  @Override void insert(Vehicle v);

  @Override void insert(List<Vehicle> list);

  @Override void delete(Vehicle v);

  @Override void deleteAll();

  @Override List<Vehicle> selectAll();

  @Override Vehicle findById(Integer i);
}