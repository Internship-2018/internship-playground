package com.example.nciuclea.oopzoomvp.storage.dao;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "animals")
public class Animal {
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "image_url")
    private String imageUrl;

    @ForeignCollectionField(columnName = "zoo_list", eager = true)
    private ForeignCollection<Zoopark> zoos;

    @DatabaseField(columnName = "habitat")
    private String habitat;

    @DatabaseField(columnName = "geo_location")
    private String geo_location;

    @DatabaseField(columnName = "description")
    private String description;

    public Animal () {

    }

    public Animal(String name, String imageUrl, ForeignCollection<Zoopark> zoos, String habitat, String geo_location, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.zoos = zoos;
        this.habitat = habitat;
        this.geo_location = geo_location;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ForeignCollection<Zoopark> getZoos() {
        return zoos;
    }

    public void setZoos(ForeignCollection<Zoopark> zoos) {
        this.zoos = zoos;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getGeo_location() {
        return geo_location;
    }

    public void setGeo_location(String geo_location) {
        this.geo_location = geo_location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
