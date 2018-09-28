package com.mtlepberghenov.internship_playground.mvp.view;

import com.mtlepberghenov.internship_playground.base.BaseView;
import com.mtlepberghenov.internship_playground.mvp.model.entity.Car;

import java.util.ArrayList;

public interface CarListView extends BaseView {

    void setCarListToAdapter(ArrayList<Car> carList);
}
