package com.mghelas.internship_playground.network.sweet;

import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

public interface SweetServiceCall {
    void getAll();

    void create(Sweet sweet);

    void deleteById(int id);

    void deleteByConfectionerName(String confectionerName);


}
