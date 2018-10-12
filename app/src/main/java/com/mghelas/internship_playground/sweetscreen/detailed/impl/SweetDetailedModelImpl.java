package com.mghelas.internship_playground.sweetscreen.detailed.impl;

import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.SweetAddCallback;
import com.mghelas.internship_playground.sweetscreen.detailed.DetailedFetcher;
import com.mghelas.internship_playground.sweetscreen.detailed.DetailedLoadCallback;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedCallback;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedModel;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetRemovedCallback;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetRemover;

public class SweetDetailedModelImpl implements SweetDetailedModel, DetailedLoadCallback<Sweet>, SweetRemovedCallback<Integer> {

    private DetailedFetcher detailedFetcher;
    private SweetRemover sweetRemover;
    private SweetDetailedCallback sweetDetailedCallback;
    private SweetAddCallback addSweetCallback;

    public SweetDetailedModelImpl(DetailedFetcher detailedFetcher, SweetRemover sweetRemover) {
        this.detailedFetcher = detailedFetcher;
        this.sweetRemover = sweetRemover;
    }

    @Override
    public void findById(int id) {
        detailedFetcher.fetchData(id);

    }

    @Override
    public void remove(int id) {
        sweetRemover.removeSweet(id);
    }

    @Override
    public void setSweetDetailedCallback(SweetDetailedCallback sweetDetailedCallback) {
        this.sweetDetailedCallback = sweetDetailedCallback;
    }

    @Override
    public void onDataLoaded(Sweet sweet) {
        sweetDetailedCallback.onDetailedLoaded(sweet);
    }

    @Override
    public void onDataRemoved(Integer id) {
        sweetDetailedCallback.onSweetRemoved(id);
    }
}
