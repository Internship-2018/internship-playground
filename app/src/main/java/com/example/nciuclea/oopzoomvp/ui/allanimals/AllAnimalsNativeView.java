package com.example.nciuclea.oopzoomvp.ui.allanimals;

import android.view.View;

public interface AllAnimalsNativeView {
    int getLayout();

    void initView(View view);

    void setOnClickHandler(AllAnimalsClickHandler allAnimalsClickHandler);

    void setOnLongClickHandler(AllAnimalsLongClickHandler longClickHandler);

    void setOnRefreshHandler(AllAnimalsRefreshHandler allAnimalsRefreshHandler);

    void setOnFabClickHandler(AllAnimalsFabClickHandler allAnimalsFabClickHandler);
}
