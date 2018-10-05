package com.mghelas.internship_playground.sweet_screen.detailed.model;

import com.mghelas.internship_playground.Entity.Sweet;

public interface SweetDetailedModel {
    Sweet findById(int id);

    void remove(int id);
}
