package com.mtlepberghenov.internship_playground.ui.list;

import com.mtlepberghenov.internship_playground.data.entites.sql.Vehicle;
import io.reactivex.Single;
import java.util.List;

public interface ListModel {
  Single<List<Vehicle>> getData();
}
