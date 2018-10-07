package com.mghelas.internship_playground.sweet_screen.add;

import com.mghelas.internship_playground.entity.Sweet;

public interface SweetAddPresenter extends AddClickHandler, SweetTypeRadioHandler {
    void viewInitialized();

    void add(Sweet sweet);
}
