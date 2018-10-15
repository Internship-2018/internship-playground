package com.mtlepberghenov.internship_playground.storage.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDaoVehicle implements DaoVehicle {

  private Dao<Vehicle, Integer> dao;

  public DefaultDaoVehicle(DbHelper dbHelper) {
    try {
      this.dao = dbHelper.getVehicleDao();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override public void insert(Vehicle v) {
    try {
      dao.create(v);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override public void delete(Vehicle v) {
    try {
      dao.delete(v);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override public List<Vehicle> selectAll() {
    try {
      return dao.queryForAll();
    } catch (SQLException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  @Override public Vehicle findById(Integer i) {
    try {
      return dao.queryForId(i);
    } catch (SQLException e) {
      e.printStackTrace();
      return new Vehicle();
    }
  }
}
