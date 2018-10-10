package com.mtlepberghenov.internship_playground.ui.list.impl;

import com.mtlepberghenov.internship_playground.ui.list.loader.DataFetcher;
import com.mtlepberghenov.internship_playground.ui.list.loader.DataDbLoadCallBack;
import com.mtlepberghenov.internship_playground.ui.list.loader.impl.DefaultDbLoaderCallback;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.list.ListModel;
import java.util.List;

public class DefaultListModel implements ListModel, DataDbLoadCallBack<List<SqlVehicle>> {

  private final DataFetcher dataFetcher;

  public DefaultListModel(DataFetcher dataFetcher) {
    this.dataFetcher = dataFetcher;
  }

  @Override public void getData() {
    dataFetcher.fetchData();
  }

  @Override public void onDataLoaded(List<SqlVehicle> data) {

  }
}
