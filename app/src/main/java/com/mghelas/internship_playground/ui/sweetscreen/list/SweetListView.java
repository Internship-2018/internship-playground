package com.mghelas.internship_playground.ui.sweetscreen.list;

import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

public interface SweetListView {
    void setOnItemClickHandler(ItemClickHandler itemClickHandler);

    void bindData(List<Sweet> sweets);

    void showError(Throwable throwable);
}
