package com.example.nciuclea.oopzoomvp.storage.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.storage.dao.Zoopark;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "animals_db";
    private static final int DATABASE_VERSION = 9;

    private Dao<Animal, Integer> animalDao = null;
    private RuntimeExceptionDao<Animal, Integer> animalRuntimeDao = null;
    private Dao<Zoopark, Integer> zooparkDao = null;
    private RuntimeExceptionDao<Zoopark, Integer> zooparkRuntimeDao = null;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Animal.class);
            TableUtils.createTableIfNotExists(connectionSource, Zoopark.class);
            getAnimalRuntimeDao();
            animalDao.create(new Animal("Red Panda",
                    "https://www.stlzoo.org/files/9213/0798/4242/redpanda01.jpg",
                    null, null, null, null));
            animalDao.create(new Animal("Kinkajou",
                    "https://www.stlzoo.org/files/3713/0798/4175/kinkajou.jpg",
                    null, null, null, null));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Animal.class, true);
            TableUtils.dropTable(connectionSource, Zoopark.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<Animal, Integer> getAnimalDao() throws SQLException {
        if (animalDao == null) {
            animalDao = getDao(Animal.class);
        }
        return animalDao;
    }

    public RuntimeExceptionDao<Animal, Integer> getAnimalRuntimeDao() {
        if (animalRuntimeDao == null) {
            animalRuntimeDao = getRuntimeExceptionDao(Animal.class);
        }
        return animalRuntimeDao;
    }

    public Dao<Zoopark, Integer> getZooparkDao() throws SQLException {
        if (zooparkDao == null) {
            zooparkDao = getDao(Zoopark.class);
        }
        return zooparkDao;
    }

    public RuntimeExceptionDao<Zoopark, Integer> getZooparkRuntimeDao() {
        if(zooparkRuntimeDao == null) {
            zooparkRuntimeDao = getRuntimeExceptionDao(Zoopark.class);
        }
        return zooparkRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
        animalDao = null;
        animalRuntimeDao = null;
    }
}
