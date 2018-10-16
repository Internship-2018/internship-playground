package com.example.nciuclea.oopzoomvp.storage.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "animal_zoopark")
public class AnimalZoopark {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, columnName = "animal_id")
    private Animal animal;

    @DatabaseField(foreign = true, columnName = "zoopark_id")
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
