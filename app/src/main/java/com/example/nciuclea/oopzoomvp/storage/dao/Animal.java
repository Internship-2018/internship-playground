package com.example.nciuclea.oopzoomvp.storage.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "animal")
public class Animal {
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "image_url")
    private String imageUrl;

    private List<Zoopark> zoos;

    @DatabaseField(columnName = "habitat")
    private String habitat;

    @DatabaseField(columnName = "geo_location")
    private String geo_location;

    @DatabaseField(columnName = "description")
    private String description;

    public Animal () {

    }

    public Animal(String name, String imageUrl, String habitat, String geo_location, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
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
