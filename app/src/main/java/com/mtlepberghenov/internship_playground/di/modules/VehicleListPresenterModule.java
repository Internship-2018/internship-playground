package com.mtlepberghenov.internship_playground.di.modules;

import com.mtlepberghenov.internship_playground.screens.vehiclelist.presenter.VehicleListPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class VehicleListPresenterModule {

  @Provides
  public VehicleListPresenterImpl vehicleListPresenter() {
    return new VehicleListPresenterImpl();
  }
}
