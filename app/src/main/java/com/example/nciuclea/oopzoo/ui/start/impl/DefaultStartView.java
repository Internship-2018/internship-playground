package com.example.nciuclea.oopzoo.ui.start.impl;

import android.view.View;
import android.widget.Button;

import com.example.nciuclea.oopzoo.R;
import com.example.nciuclea.oopzoo.ui.start.StartActivity;
import com.example.nciuclea.oopzoo.ui.start.StartClickHandler;
import com.example.nciuclea.oopzoo.ui.start.StartNativeView;
import com.example.nciuclea.oopzoo.ui.start.StartView;


public class DefaultStartView implements StartView, StartNativeView {

    private StartClickHandler startClickHandler;

    @Override
    public int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    public void initView(StartActivity startActivity) {
        Button button = startActivity.findViewById(R.id.start_btn);
        if (button == null) {
            button = startActivity.findViewById(R.id.main_btn);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartClicked();
            }
        });
    }

    @Override
    public void setOnStarClickHandler(StartClickHandler startClickHandler) {
        this.startClickHandler = startClickHandler;
    }

    @Override
    public void changeContent() {

    }

    private void onStartClicked() {
        if (startClickHandler != null) {
            startClickHandler.onStartClicked();
        }
    }

}
