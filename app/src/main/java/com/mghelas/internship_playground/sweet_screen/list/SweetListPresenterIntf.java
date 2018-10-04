package com.mghelas.internship_playground.sweet_screen.list;

import android.support.v7.widget.RecyclerView;

import com.mghelas.internship_playground.Entity.Sweet;

import java.util.List;

public interface SweetListPresenterIntf {
    List<Sweet> getAllSweets();

    Sweet findById(int id);

    void remove(int id);

    void add(Sweet sweet);

    void setAdapter(RecyclerView.Adapter adapter);
}
