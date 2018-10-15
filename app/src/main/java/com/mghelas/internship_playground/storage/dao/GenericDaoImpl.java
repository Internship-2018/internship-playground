package com.mghelas.internship_playground.storage.dao;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.storage.datasource.DbHelper;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericDaoImpl<E> implements GenericDao<E> {

    private RuntimeExceptionDao<E, Integer> dao;

    public GenericDaoImpl(DbHelper dbHelper) {
        dao = dbHelper.getRuntimeExceptionDao(((Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]));


    }

    @Override
    public int save(E entity) {
        return dao.create(entity);
    }

    @Override
    public E findById(int key) {
        return dao.queryForId(key);
    }

    @Override
    public void update(E entity) {
        dao.update(entity);
    }

    @Override
    public int delete(E entity) {
        return dao.delete(entity);
    }

    @Override
    public List<E> getAll() {
        return dao.queryForAll();
    }

    @Override
    public void deleteAll() {
        DeleteBuilder<E, Integer> db = dao.deleteBuilder();
        try {
            db.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
