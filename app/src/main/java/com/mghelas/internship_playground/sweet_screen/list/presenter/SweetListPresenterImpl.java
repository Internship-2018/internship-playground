package com.mghelas.internship_playground.sweet_screen.list.presenter;

import android.support.v7.widget.RecyclerView;

import com.mghelas.internship_playground.Entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.list.model.SweetListModelImpl;
import com.mghelas.internship_playground.sweet_screen.list.model.SweetListModelIntf;
import com.mghelas.internship_playground.sweet_screen.list.view.SweetListFragment;

import java.util.List;

public class SweetListPresenterImpl implements SweetListPresenterIntf {
    private SweetListFragment sweetListFragment;
    private SweetListModelIntf sweetModel;

    public SweetListPresenterImpl(SweetListFragment sweetListFragment) {
        this.sweetListFragment = sweetListFragment;
        this.sweetModel = new SweetListModelImpl();
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
