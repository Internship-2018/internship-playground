package com.mghelas.internship_playground.ui.sweetscreen.list.impl;

import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListModel;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListView;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListWireframe;

import java.util.List;

public class SweetListPresenterImpl implements SweetListPresenter {
    private SweetListView sweetListView;
    private SweetListWireframe sweetListWireframe;
    private SweetListModel sweetModel;

    public SweetListPresenterImpl(SweetListView sweetListView, SweetListWireframe sweetListWireframe, SweetListModel sweetListModel) {
        this.sweetListView = sweetListView;
        this.sweetListWireframe = sweetListWireframe;
        this.sweetModel = sweetListModel;
    }


    @Override
    public void onViewInitialised() {
        sweetListView.setOnItemClickHandler(this);
        sweetModel.getAll();
    }

    @Override
    public void onItemClicked(int id) {
        sweetListWireframe.showDetailedContent(id);
    }

    @Override
    public void getAllSweets() {
        sweetModel.getAll();
    }


    @Override
    public void onListLoaded(List<Sweet> sweets) {
        sweetListView.bindData(sweets);
    }
}
