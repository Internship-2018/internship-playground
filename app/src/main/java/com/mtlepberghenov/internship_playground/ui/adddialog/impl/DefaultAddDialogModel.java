package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import com.mtlepberghenov.internship_playground.storage.loader.DataFetcher;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;

public class DefaultAddDialogModel implements AddDialogModel {

  private final DataFetcher dataFetcher;

  public DefaultAddDialogModel(DataFetcher dataFetcher) {
    this.dataFetcher = dataFetcher;
  }
}