package com.mghelas.internship_playground.ui.sweetscreen.detailed;

import com.mghelas.internship_playground.storage.entity.Sweet;

public interface SweetDetailedView {
    void setOnMixClickHandler(MixClickHandler mixClickHandler);

    void setOnRemoveClickHandler(RemoveClickHandler removeClickHandler);

    void mixShow(String message);

    void bindData(Sweet sweet);
}
