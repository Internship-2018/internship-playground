package com.mtlepberghenov.internship_playground.ui.list.impl;

import com.mtlepberghenov.internship_playground.ui.list.ListModel;
import com.mtlepberghenov.internship_playground.ui.list.ListPresenter;
import com.mtlepberghenov.internship_playground.ui.list.ListView;

public class DefaultListPresenter implements ListPresenter {

  private final ListView view;
  private final ListModel model;

  public DefaultListPresenter(ListView view, ListModel model) {
    this.view = view;
    this.model = model;
  }

  @Override public void onViewInitialised() {
    model.getData();
  }
}
