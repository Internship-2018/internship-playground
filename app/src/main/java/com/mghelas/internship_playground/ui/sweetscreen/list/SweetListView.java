package com.mghelas.internship_playground.ui.sweetscreen.list;

import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

public interface SweetListView {
    void setOnItemClickHandler(ItemClickHandler itemClickHandler);

    void setOnDeleteClickHandler(DeleteClickHandler deleteClickHandler);

    void setOnSwipeHandler(SwipeHandler swipeHandler);

    void bindData(List<Sweet> sweets);

    void showError(String error);
}
