package com.mghelas.internship_playground.ui.sweetscreen.list;

import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

public interface SweetListCallback {
    void onListLoaded(List<Sweet> sweets);
}
