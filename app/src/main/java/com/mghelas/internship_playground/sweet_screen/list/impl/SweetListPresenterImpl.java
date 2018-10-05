package com.mghelas.internship_playground.sweet_screen.list.impl;

import android.support.v7.widget.RecyclerView;

import com.mghelas.internship_playground.Entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.list.SweetListFragment;
import com.mghelas.internship_playground.sweet_screen.list.SweetListModel;
import com.mghelas.internship_playground.sweet_screen.list.SweetListPresenter;
import com.mghelas.internship_playground.sweet_screen.list.SweetListView;
import com.mghelas.internship_playground.sweet_screen.list.SweetListWireframe;

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
    }

    @Override
    public void onItemClicked() {
        sweetListWireframe.showDetailedContent();
    }

    @Override
    public List<Sweet> getAllSweets() {
        return sweetModel.getAll();
    }

    @Override
    public void onAdd() {
//        sweetListFragment.
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        adapter.notifyDataSetChanged();
        this.sweetListFragment.getRecyclerView().setAdapter(adapter);
    }

}
