package com.mghelas.internship_playground.sweet_screen.detailed;

import com.mghelas.internship_playground.entity.Sweet;

public interface SweetDetailedView {
    void setOnMixClickHandler(MixClickHandler mixClickHandler);

    void setOnRemoveClickHandler(RemoveClickHandler removeClickHandler);

    void mixShow(String message);
}
