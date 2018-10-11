package com.mghelas.internship_playground.sweetscreen.list;

import com.mghelas.internship_playground.entity.Sweet;

import java.util.List;

public interface SweetListCallback {
    void onListLoaded(List<Sweet> sweets);
}
