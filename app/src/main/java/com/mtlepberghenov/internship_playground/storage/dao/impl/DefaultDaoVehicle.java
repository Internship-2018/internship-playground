package com.mtlepberghenov.internship_playground.storage.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.TableUtils;
import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDaoVehicle implements DaoVehicle {

  private Dao<Vehicle, Integer> dao;
  private static DefaultDaoVehicle defaultDaoVehicle;

  public static DefaultDaoVehicle getInstance(DbHelper dbHelper) {
    if (defaultDaoVehicle == null) {
      defaultDaoVehicle = new DefaultDaoVehicle(dbHelper);
      return defaultDaoVehicle;
    }
    return defaultDaoVehicle;
  }

  private DefaultDaoVehicle(DbHelper dbHelper) {
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

  @Override public void insert(List<Vehicle> list) {
    try {
      dao.create(list);
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

  @Override public void deleteAll() {
    try {
      TableUtils.dropTable(dao.getConnectionSource(), Vehicle.class, false);
      TableUtils.createTable(dao.getConnectionSource(), Vehicle.class);
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
