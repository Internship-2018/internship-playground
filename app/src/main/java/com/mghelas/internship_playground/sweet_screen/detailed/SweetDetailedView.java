package com.mghelas.internship_playground.sweet_screen.detailed;

import com.mghelas.internship_playground.Entity.Sweet;

public interface SweetDetailedView {
    void setData(Sweet sweet);

    void mix(String manufactureProcess);

    void remove();
}
