package com.mghelas.internship_playground.sweetscreen.list.impl;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.sweetscreen.list.ItemClickHandler;
import com.mghelas.internship_playground.sweetscreen.list.SweetAdapter;
import com.mghelas.internship_playground.sweetscreen.list.SweetListFragment;
import com.mghelas.internship_playground.sweetscreen.list.SweetListNativeView;
import com.mghelas.internship_playground.sweetscreen.list.SweetListPresenter;
import com.mghelas.internship_playground.sweetscreen.list.SweetListView;

public class SweetListViewImpl implements SweetListView, SweetListNativeView {

    private ItemClickHandler itemClickHandler;

    private TextView emptyText;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_list;
    }

    @Override
    public void initView(SweetListFragment sweetListFragment, SweetListPresenter sweetListPresenter) {
        recyclerView = sweetListFragment.getView().findViewById(R.id.fragment_sweet_list);
        emptyText = sweetListFragment.getView().findViewById(R.id.empty_view);
        if (sweetListPresenter.getAllSweets().isEmpty()) {
            showEmpty();
        } else {
            populateView(sweetListFragment, sweetListPresenter);
        }
    }

    private void populateView(SweetListFragment sweetListFragment, SweetListPresenter sweetListPresenter) {
        recyclerView.setVisibility(View.VISIBLE);
        emptyText.setVisibility(View.GONE);
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

    private void showEmpty() {
        recyclerView.setVisibility(View.GONE);
        emptyText.setVisibility(View.VISIBLE);
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
