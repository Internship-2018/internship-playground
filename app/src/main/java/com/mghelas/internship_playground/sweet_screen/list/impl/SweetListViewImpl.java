package com.mghelas.internship_playground.sweet_screen.list.impl;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.list.ItemClickHandler;
import com.mghelas.internship_playground.sweet_screen.list.SweetAdapter;
import com.mghelas.internship_playground.sweet_screen.list.SweetListFragment;
import com.mghelas.internship_playground.sweet_screen.list.SweetListNativeView;
import com.mghelas.internship_playground.sweet_screen.list.SweetListPresenter;
import com.mghelas.internship_playground.sweet_screen.list.SweetListView;

import java.util.List;

public class SweetListViewImpl implements SweetListView, SweetListNativeView {

    private ItemClickHandler itemClickHandler;
    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_list;
    }

    @Override
    public void initView(SweetListFragment sweetListFragment, SweetListPresenter sweetListPresenter) {
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;

        recyclerView = sweetListFragment.getView().findViewById(R.id.fragment_sweet_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(sweetListFragment.getView().getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SweetAdapter(sweetListPresenter.getAllSweets(), new ItemClickHandler() {
            @Override
            public void onItemClicked(int id) {
                onItemClick(id);
            }
        }));
    }

    private void onItemClick(int id) {
        if (itemClickHandler != null) {
            itemClickHandler.onItemClicked(id);
        }
    }

    @Override
    public void setOnItemClickHandler(ItemClickHandler itemClickHandler) {
        this.itemClickHandler = itemClickHandler;
    }
}
