package com.mghelas.internship_playground.sweetscreen.detailed;

import com.mghelas.internship_playground.entity.Sweet;

public interface SweetDetailedCallback {
    void onDetailedLoaded(Sweet sweet);
    void onSweetRemoved(int id);
}
