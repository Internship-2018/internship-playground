package com.mghelas.internship_playground.sweet_screen.list;

import android.support.v7.widget.RecyclerView;

import com.mghelas.internship_playground.Entity.Sweet;

import java.util.List;

public class SweetListPresenterImpl implements SweetListPresenterIntf {
    private SweetListFragment sweetListFragment;
    private SweetListModelIntf sweetModel;

    SweetListPresenterImpl(SweetListFragment sweetListFragment) {
        this.sweetListFragment = sweetListFragment;
        this.sweetModel = new SweetListModelImpl();
    }


    @Override
    public List<Sweet> getAllSweets() {
        return sweetModel.getAll();
    }

    @Override
    public Sweet findById(int id) {
        return sweetModel.findById(id);
    }

    @Override
    public void remove(int id) {
        sweetModel.remove(id);
    }

    @Override
    public void add(Sweet sweet) {
        sweetModel.add(sweet);
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        adapter.notifyDataSetChanged();
        this.sweetListFragment.getRecyclerView().setAdapter(adapter);
    }
}
