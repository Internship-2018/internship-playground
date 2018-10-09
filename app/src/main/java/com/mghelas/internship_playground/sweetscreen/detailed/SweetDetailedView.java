package com.mghelas.internship_playground.sweetscreen.detailed;

public interface SweetDetailedView {
    void setOnMixClickHandler(MixClickHandler mixClickHandler);

    void setOnRemoveClickHandler(RemoveClickHandler removeClickHandler);

    void mixShow(String message);
}
