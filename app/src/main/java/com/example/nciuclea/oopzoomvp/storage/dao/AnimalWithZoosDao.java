package com.example.nciuclea.oopzoomvp.storage.dao;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public interface AnimalWithZoosDao extends Dao<Animal, Integer> {
    void setRequiredDaos(Dao<Zoopark, Integer> zooparkDao, Dao<AnimalZoopark, Integer> animalZooparkDao);

    Animal queryByIdWithZooparks(Integer id) throws SQLException;

    List<Animal> queryForAllWithZooparks() throws SQLException;
}
