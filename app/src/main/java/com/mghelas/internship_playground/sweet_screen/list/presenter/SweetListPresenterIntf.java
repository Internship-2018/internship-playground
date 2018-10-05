package com.mghelas.internship_playground.sweet_screen.list.presenter;

import android.support.v7.widget.RecyclerView;

import com.mghelas.internship_playground.Entity.Sweet;

import java.util.List;

public interface SweetListPresenterIntf {
    List<Sweet> getAllSweets();

    void onAdd();

    void setAdapter(RecyclerView.Adapter adapter);
}
