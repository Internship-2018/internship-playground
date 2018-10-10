package com.mtlepberghenov.internship_playground.ui.list.impl;

import com.mtlepberghenov.internship_playground.storage.loader.DataFetcher;
import com.mtlepberghenov.internship_playground.storage.loader.DataLoadCallBack;
import com.mtlepberghenov.internship_playground.storage.loader.impl.DefaultDbLoaderCallback;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.list.ListModel;

public class DefaultListModel implements ListModel, DataLoadCallBack<SqlVehicle> {

  private final DataFetcher dataFetcher;
  private DefaultDbLoaderCallback dbLoaderCallback;

  public DefaultListModel(DataFetcher dataFetcher) {
    this.dataFetcher = dataFetcher;
  }

  @Override public void getData() {
    dataFetcher.fetchData();
    dbLoaderCallback = new DefaultDbLoaderCallback()
  }

  @Override public void onDataLoaded(SqlVehicle data) {

  }
}
