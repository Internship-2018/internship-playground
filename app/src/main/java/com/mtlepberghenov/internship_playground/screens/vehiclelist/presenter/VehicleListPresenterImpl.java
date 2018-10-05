package com.mtlepberghenov.internship_playground.screens.vehiclelist.presenter;

import com.mtlepberghenov.internship_playground.base.BasePresenter;
import com.mtlepberghenov.internship_playground.screens.vehiclelist.model.VehicleListModel;
import com.mtlepberghenov.internship_playground.screens.vehiclelist.model.entity.Vehicle;
import com.mtlepberghenov.internship_playground.screens.vehiclelist.view.VehicleListView;
import com.mtlepberghenov.internship_playground.utils.TextWrapper;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.List;

public class VehicleListPresenterImpl extends BasePresenter<VehicleListView>
    implements VehicleListPresenter {

  private VehicleListModel model;

  private static final String ERROR = TextWrapper.newInstance().getErrorMessage();
  public static final String DONE = TextWrapper.newInstance().getDoneMessage();

  @Override public void onScreenIsReady() {

    model.getData()
        .subscribe(new SingleObserver<List<Vehicle>>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onSuccess(List<Vehicle> vehicles) {
            getView().onSetData(vehicles);
            getView().onShowMessage(DONE);
          }

          @Override public void onError(Throwable e) {
            e.printStackTrace();
            getView().onShowMessage(ERROR);
          }
        });
  }
}