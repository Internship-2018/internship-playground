package com.mghelas.internship_playground.ui.sweetscreen.detailed;

import com.mghelas.internship_playground.storage.entity.Sweet;

public interface SweetDetailedCallback {
    void onDetailedLoaded(Sweet sweet);
    void onSweetRemoved(int id);
}
