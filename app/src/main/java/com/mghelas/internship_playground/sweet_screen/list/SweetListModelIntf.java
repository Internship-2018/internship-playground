package com.mghelas.internship_playground.sweet_screen.list;

import com.mghelas.internship_playground.Entity.Sweet;

import java.util.List;

public interface SweetListModelIntf {
    List<Sweet> getAll();
    Sweet findById(int id);
    void remove(int id);
    void add(Sweet sweet);
}
