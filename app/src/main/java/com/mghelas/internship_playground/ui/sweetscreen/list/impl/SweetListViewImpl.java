package com.mghelas.internship_playground.ui.sweetscreen.list.impl;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.list.ItemClickHandler;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetAdapter;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListFragment;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListNativeView;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListView;

import java.util.ArrayList;
import java.util.List;

public class SweetListViewImpl implements SweetListView, SweetListNativeView {

    private ItemClickHandler itemClickHandler;

    private TextView emptyText;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    SweetListFragment sweetListFragment;

    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_list;
    }

    @Override
    public void initView(SweetListFragment sweetListFragment, SweetListPresenter sweetListPresenter) {
        this.sweetListFragment = sweetListFragment;
        recyclerView = sweetListFragment.getView().findViewById(R.id.fragment_sweet_list);
        emptyText = sweetListFragment.getView().findViewById(R.id.empty_view);
        bindData(new ArrayList<Sweet>());
        populateView(sweetListFragment, sweetListPresenter);
    }

    private void populateView(SweetListFragment sweetListFragment, SweetListPresenter sweetListPresenter) {
        recyclerView.setVisibility(View.VISIBLE);
        emptyText.setVisibility(View.GONE);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(sweetListFragment.getView().getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SweetAdapter(new ArrayList<Sweet>(), null));
    }


    public void bindData(List<Sweet> sweets) {
        if (sweets.isEmpty()) {
            showEmpty();
        } else {
            recyclerView.setAdapter(new SweetAdapter(sweets, new ItemClickHandler() {
                @Override
                public void onItemClicked(int id) {
                    onItemClick(id);
                }
            }));
        }
    }

    @Override
    public void showError(Throwable throwable) {
        Toast toast = Toast.makeText(sweetListFragment.getContext(),
                throwable.toString(),
                Toast.LENGTH_SHORT);
        toast.show();
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
