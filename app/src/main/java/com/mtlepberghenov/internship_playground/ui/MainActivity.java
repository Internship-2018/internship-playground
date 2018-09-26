package com.mtlepberghenov.internship_playground.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.mvp.view.View;

public class MainActivity extends AppCompatActivity implements View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
