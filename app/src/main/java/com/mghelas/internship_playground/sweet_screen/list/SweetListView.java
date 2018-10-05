package com.mghelas.internship_playground.sweet_screen.list;

public interface SweetListView {
    void setOnItemClickHandler(ItemClickHandler itemClickHandler);
    void populateView();
    void add();
}
