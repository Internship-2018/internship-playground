package com.mghelas.internship_playground.sweet_screen.detailed;

import com.mghelas.internship_playground.Entity.Sweet;

public interface SweetDetailedPresenterIntf {
    void findById(int id);

    void onRemove(int id);

    void onMix(Sweet sweet);
}
