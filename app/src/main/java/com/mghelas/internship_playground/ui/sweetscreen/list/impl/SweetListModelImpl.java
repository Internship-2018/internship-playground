package com.mghelas.internship_playground.ui.sweetscreen.list.impl;

import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.list.ListFetcher;
import com.mghelas.internship_playground.ui.sweetscreen.list.ListLoadCallback;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListCallback;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListModel;

import java.util.List;

public class SweetListModelImpl implements SweetListModel, ListLoadCallback<List<Sweet>> {
    private final ListFetcher dataFetcher;
    private SweetListCallback sweetListCallback;
    private SweetServiceCall sweetServiceCall;
    private SweetDao sweetDao;

    public SweetListModelImpl(ListFetcher dataFetcher, SweetDao sweetDao) {
        this.dataFetcher = dataFetcher;
        this.sweetDao = sweetDao;
    }

    @Override
    public void getAll() {
        dataFetcher.fetchData();
    }

    @Override
    public void deleteByConfectionerName(String name) {
        sweetServiceCall.deleteByConfectionerName(name);
    }

    @Override
    public void onDeleteCalled(String name) {
        sweetDao.deleteByConfectionerName(name);
        getAll();
    }

    @Override
    public void setSweetServiceCall(SweetServiceCall sweetServiceCall) {
        this.sweetServiceCall = sweetServiceCall;
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
