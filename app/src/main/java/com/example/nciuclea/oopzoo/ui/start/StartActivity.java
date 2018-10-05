package com.example.nciuclea.oopzoo.ui.start;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nciuclea.oopzoo.ui.start.impl.DefaultStartModel;
import com.example.nciuclea.oopzoo.ui.start.impl.DefaultStartPresenter;
import com.example.nciuclea.oopzoo.ui.start.impl.DefaultStartView;
import com.example.nciuclea.oopzoo.ui.start.impl.DefaultStartWireframe;


public class StartActivity extends AppCompatActivity {

    private StartNativeView startNativeView;
    private StartPresenter startPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DefaultStartView view = new DefaultStartView();
        startNativeView = view;
        startPresenter = new DefaultStartPresenter(view, new DefaultStartModel(), new DefaultStartWireframe(this));
        setContentView(startNativeView.getLayout());
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        startNativeView.initView(this);
        startPresenter.onViewInitialised();
    }

}
