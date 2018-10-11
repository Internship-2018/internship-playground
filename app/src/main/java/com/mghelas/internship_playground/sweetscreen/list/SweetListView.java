package com.mghelas.internship_playground.sweetscreen.list;

import com.mghelas.internship_playground.entity.Sweet;

import java.util.List;

public interface SweetListView {
    void setOnItemClickHandler(ItemClickHandler itemClickHandler);
    void bindData(List<Sweet> sweets);
}
