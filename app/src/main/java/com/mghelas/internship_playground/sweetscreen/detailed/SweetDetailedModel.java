package com.mghelas.internship_playground.sweetscreen.detailed;

import com.mghelas.internship_playground.entity.Sweet;

public interface SweetDetailedModel {
    Sweet findById(int id);

    void remove(int id);
}
