package com.mghelas.internship_playground.sweet_screen.detailed.presenter;

import com.mghelas.internship_playground.Entity.Sweet;

public interface SweetDetailedPresenter {
    void findById(int id);

    void onRemove(int id);

    void onMix(Sweet sweet);
}
