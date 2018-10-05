package com.example.nciuclea.oopzoo.ui.start.impl;

import android.content.Intent;

import com.example.nciuclea.oopzoo.R;
import com.example.nciuclea.oopzoo.ui.dashboard.DashboardActivity;
import com.example.nciuclea.oopzoo.ui.start.StartActivity;
import com.example.nciuclea.oopzoo.ui.start.StartWireframe;


public class DefaultStartWireframe implements StartWireframe {

    private int counter;
    private final StartActivity startActivity;

    public DefaultStartWireframe(StartActivity startActivity) {
        this.startActivity = startActivity;
        counter = 0;
    }

    @Override
    public void showMainContent() {
        startActivity.startActivity(new Intent(startActivity, DashboardActivity.class));
    }

    @Override
    public void showStartContent() {
        startActivity.setContentView(R.layout.activity_start);
    }
}
