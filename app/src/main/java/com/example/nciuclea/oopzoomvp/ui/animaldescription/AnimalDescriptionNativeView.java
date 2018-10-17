package com.example.nciuclea.oopzoomvp.ui.animaldescription;

import android.view.View;

public interface AnimalDescriptionNativeView {
    int getLayout();

    void initView(View view);

    void setOnClickHandler(AnimalDescriptionClickHandler animalDescriptionClickHandler);
}
