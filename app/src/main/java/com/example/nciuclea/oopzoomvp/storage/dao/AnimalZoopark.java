package com.example.nciuclea.oopzoomvp.storage.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "animal_zoopark")
public class AnimalZoopark {

    public final static String ANIMAL_ID_FIELD_NAME = "animal_id";
    public final static String ZOOPARK_ID_FIELD_NAME = "zoopark_id";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, columnName = ANIMAL_ID_FIELD_NAME)
    private Animal animal;

    @DatabaseField(foreign = true, columnName = ZOOPARK_ID_FIELD_NAME)
    private Zoopark zoopark;

    AnimalZoopark () {

    }

    public AnimalZoopark(Animal animal, Zoopark zoopark) {
        this.animal = animal;
        this.zoopark = zoopark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Zoopark getZoopark() {
        return zoopark;
    }

    public void setZoopark(Zoopark zoopark) {
        this.zoopark = zoopark;
    }
}
