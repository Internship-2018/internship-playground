package com.mghelas.internship_playground.sweet_screen.detailed;

import com.mghelas.internship_playground.Entity.Sweet;

public interface SweetDetailedModelIntf {
    Sweet findById(int id);

    void remove(int id);
}
