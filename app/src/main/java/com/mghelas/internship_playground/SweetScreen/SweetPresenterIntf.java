package com.mghelas.internship_playground.SweetScreen;

import android.support.v7.widget.RecyclerView;

public interface SweetPresenterIntf {
    void getChocolateItems();

    void getLollipopItems();

    void setAdapter(RecyclerView.Adapter adapter);
}
