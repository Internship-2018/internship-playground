package com.mtlepberghenov.internship_playground.ui.list.impl;

import com.mtlepberghenov.internship_playground.ui.list.ListModel;
import com.mtlepberghenov.internship_playground.ui.list.ListPresenter;
import com.mtlepberghenov.internship_playground.ui.list.ListView;

public class DefaultListPresenter implements ListPresenter {

  private final ListView listView;
  private final ListModel listModel;

  public DefaultListPresenter(ListView listView, ListModel listModel) {
    this.listView = listView;
    this.listModel = listModel;
  }

  @Override public void onViewInitialised() {
    getData();
  }

  private void getData() {

  }
}
