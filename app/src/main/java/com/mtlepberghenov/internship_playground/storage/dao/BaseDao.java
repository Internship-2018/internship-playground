package com.mtlepberghenov.internship_playground.storage.dao;

import java.util.List;

interface BaseDao<O, I> {

  void insert(O o);

  void delete(O o);

  List<O> selectAll();

  O findById(I i);
}
