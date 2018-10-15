package com.mtlepberghenov.internship_playground.storage.datasource;

import com.j256.ormlite.dao.Dao;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.sql.SQLException;

public interface DbHelper {

  Dao<Vehicle, Integer> getVehicleDao() throws SQLException;
}
