package com.mghelas.internship_playground.sweetscreen.list.impl;

import android.util.Log;

import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.list.ListFetcher;
import com.mghelas.internship_playground.sweetscreen.list.ListLoadCallback;
import com.mghelas.internship_playground.sweetscreen.list.SweetListCallback;
import com.mghelas.internship_playground.sweetscreen.list.SweetListModel;

import java.util.List;

public class SweetListModelImpl implements SweetListModel, ListLoadCallback<List<Sweet>> {
    private final ListFetcher dataFetcher;
    private SweetListCallback sweetListCallback;

    public SweetListModelImpl(ListFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;

    }

    @Override
    public void getAll() {
        dataFetcher.fetchData();

    }

    @Override
    public void setSweetListCallback(SweetListCallback sweetListCallback) {
        this.sweetListCallback = sweetListCallback;
    }

    @Override
    public void onDataLoaded(List<Sweet> data) {
        sweetListCallback.onListLoaded(data);
    }
}
