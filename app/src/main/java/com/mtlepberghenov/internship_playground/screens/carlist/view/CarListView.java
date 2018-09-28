package com.mtlepberghenov.internship_playground.screens.carlist.view;

import com.mtlepberghenov.internship_playground.base.BaseView;
import com.mtlepberghenov.internship_playground.model.entity.Car;

import java.util.ArrayList;

public interface CarListView extends BaseView {

    void setCarListToAdapter(ArrayList<Car> carList);
}
