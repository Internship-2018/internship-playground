package com.mtlepberghenov.internship_playground.storage.dao;

import com.mtlepberghenov.internship_playground.storage.model.Data;
import java.util.List;

public interface Dao {

  void insert(Data data);

  List<Data> selectAll();
}
