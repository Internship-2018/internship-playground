package com.mghelas.internship_playground.sweet_screen.list;

import android.support.v7.widget.RecyclerView;

import com.mghelas.internship_playground.entity.Sweet;

import java.util.List;

public interface SweetListPresenter extends ItemClickHandler {
    void onViewInitialised();

    List<Sweet> getAllSweets();
}
