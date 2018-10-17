package com.example.nciuclea.oopzoomvp.storage.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class AnimalWithZoosDaoImpl extends BaseDaoImpl<Animal, Integer> implements AnimalWithZoosDao {

    private Dao<Zoopark, Integer> zooparkDao = null;
    private Dao<AnimalZoopark, Integer> animalZooparkDao = null;
    private PreparedQuery<Zoopark> zooparksForAnimalQuery = null;

    public AnimalWithZoosDaoImpl(ConnectionSource connectionSource, Class<Animal> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    @Override
    public void setRequiredDaos(Dao<Zoopark, Integer> zooparkDao, Dao<AnimalZoopark, Integer> animalZooparkDao){
        this.zooparkDao = zooparkDao;
        this.animalZooparkDao = animalZooparkDao;
    }

    @Override
    public Animal queryByIdWithZooparks(Integer integer) throws SQLException {
        Animal animal = super.queryForId(integer);
        if (zooparkDao == null || animalZooparkDao == null) { return animal; }
        if (zooparksForAnimalQuery == null) {
            zooparksForAnimalQuery = makeZoosForAnimalQuery();
        }
        zooparksForAnimalQuery.setArgumentHolderValue(0, animal);
        animal.addZooPark(zooparkDao.query(zooparksForAnimalQuery));
        return animal;
    }

    @Override
    public List<Animal> queryForAllWithZooparks() throws SQLException {
        List<Animal> animalList = super.queryForAll();
        if (zooparkDao == null || animalZooparkDao == null) { return animalList; }
        if (zooparksForAnimalQuery == null) {
            zooparksForAnimalQuery = makeZoosForAnimalQuery();
        }

        for(int i = 0; i < animalList.size(); i++) {
            zooparksForAnimalQuery.setArgumentHolderValue(0, animalList.get(i));
            animalList.get(i).addZooPark(zooparkDao.query(zooparksForAnimalQuery));
        }
        return animalList;
    }

    private PreparedQuery<Zoopark> makeZoosForAnimalQuery() throws SQLException {
        //building inner query for objects
        QueryBuilder<AnimalZoopark, Integer> animalZooparkQb = animalZooparkDao.queryBuilder();
        //selecting post_id_fieldnames
        animalZooparkQb.selectColumns(AnimalZoopark.ZOOPARK_ID_FIELD_NAME);
        SelectArg animalSelectArg = new SelectArg();
        //
        animalZooparkQb.where().eq(AnimalZoopark.ANIMAL_ID_FIELD_NAME, animalSelectArg);

        //building outer query for Zoopark objects
        QueryBuilder<Zoopark, Integer> zooparkQb = zooparkDao.queryBuilder();
        //where id matches the zoopark-id from the inner query
        zooparkQb.where().in(Zoopark.ID_FIELD_NAME, animalZooparkQb);
        return zooparkQb.prepare();

    }
}
