package com.mghelas.internship_playground.storage.dao;

import java.util.List;

public interface GenericDao<E> {

    public int save(E entity);

    public E findById(int key);

    public void update(E entity);

    public int delete(E entity);

    public List<E> getAll();
}
