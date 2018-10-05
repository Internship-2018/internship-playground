package com.mghelas.internship_playground.start_screen.impl;

import android.view.View;
import android.widget.Button;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.start_screen.AddClickHandler;
import com.mghelas.internship_playground.start_screen.StartFragment;
import com.mghelas.internship_playground.start_screen.StartNativeView;
import com.mghelas.internship_playground.start_screen.StartView;
import com.mghelas.internship_playground.start_screen.StockClickHandler;

public class StartViewImpl implements StartView, StartNativeView {
    private StockClickHandler stockClickHandler;
    private AddClickHandler addClickHandler;

    @Override
    public int getLayout() {
        return R.layout.fragment_start;
    }

    @Override
    public void initView(StartFragment startFragment) {
        Button stockBtn = startFragment.getView().findViewById(R.id.stock_btn);
        Button addBtn = startFragment.getView().findViewById(R.id.add_btn);

        stockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStockClicked();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddClicked();
            }
        });
    }

    private void onAddClicked() {
        if (addClickHandler != null) {
            addClickHandler.onAddClicked();
        }
    }

    private void onStockClicked() {
        if (stockClickHandler != null) {
            stockClickHandler.onStockClicked();
        }
    }

    @Override
    public void setOnStockClickHandler(StockClickHandler stockClickHandler) {
        this.stockClickHandler = stockClickHandler;
    }

    @Override
    public void setOnAddClickHandler(AddClickHandler addClickHandler) {
        this.addClickHandler = addClickHandler;

    }
}
