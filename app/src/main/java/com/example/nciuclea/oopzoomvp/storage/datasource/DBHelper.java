package com.example.nciuclea.oopzoomvp.storage.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.storage.dao.AnimalZoopark;
import com.example.nciuclea.oopzoomvp.storage.dao.Zoopark;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "animals_db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Animal, Integer> animalDao = null;
    private Dao<Zoopark, Integer> zooparkDao = null;
    private Dao<AnimalZoopark, Integer> animalZooparkDao = null;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Animal.class);
            TableUtils.createTable(connectionSource, Zoopark.class);
            TableUtils.createTable(connectionSource, AnimalZoopark.class);
            getAnimalDao();
            getZooparkDao();
            getAnimalZooparkDao();
            Animal animal1 = new Animal("Red Pand",
                    "https://www.stlzoo.org/files/9213/0798/4242/redpanda01.jpg",
                    null, null, null);
            Animal animal2 = new Animal("Kinkajou",
                    "https://www.stlzoo.org/files/3713/0798/4175/kinkajou.jpg",
                    null, null, null);
            animalDao.create(animal1);
            animalDao.create(animal2);
            Zoopark zoo1 = new Zoopark("Chisinau", "National zoo", "Bulevardul Dacia 50/7");
            Zoopark zoo2 = new Zoopark("Balti", "Balti zoo", "str. Stefan cel Mare 5/6");
            Zoopark zoo3 = new Zoopark("Orhei", "Orhei zoo", "str. Sf. Gheorghe 1/2");
            zooparkDao.create(zoo1);
            zooparkDao.create(zoo2);
            zooparkDao.create(zoo3);
            AnimalZoopark animal1Zoopark1 = new AnimalZoopark(animal1, zoo1);
            AnimalZoopark animal1Zoopark2 = new AnimalZoopark(animal1, zoo2);
            AnimalZoopark animal2Zoopark2 = new AnimalZoopark(animal2, zoo2);
            AnimalZoopark animal2Zoopark3 = new AnimalZoopark(animal2, zoo3);
            animalZooparkDao.create(animal1Zoopark1);
            animalZooparkDao.create(animal1Zoopark2);
            animalZooparkDao.create(animal2Zoopark2);
            animalZooparkDao.create(animal2Zoopark3);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Animal.class, true);
            TableUtils.dropTable(connectionSource, Zoopark.class, true);
            TableUtils.dropTable(connectionSource, AnimalZoopark.class, true);
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

    public Dao<Zoopark, Integer> getZooparkDao() throws SQLException {
        if (zooparkDao == null) {
            zooparkDao = getDao(Zoopark.class);
        }
        return zooparkDao;
    }

    public Dao<AnimalZoopark, Integer> getAnimalZooparkDao() throws SQLException {
        if (animalZooparkDao == null) {
            animalZooparkDao = getDao(AnimalZoopark.class);
        }
        return animalZooparkDao;
    }

    @Override
    public void close() {
        super.close();
        animalDao = null;
        zooparkDao = null;
        animalZooparkDao = null;
    }
}
