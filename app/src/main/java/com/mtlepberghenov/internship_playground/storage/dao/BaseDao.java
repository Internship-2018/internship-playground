package com.mtlepberghenov.internship_playground.storage.dao;

import java.util.List;

interface BaseDao<O, I> {

  void insert(O o);

  void insert(List<O> list);

  void delete(O o);

  void deleteAll();

  List<O> selectAll();

  O findById(I i);
}