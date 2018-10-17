package com.example.nciuclea.oopzoomvp.storage.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

@DatabaseTable(tableName = "animal", daoClass = AnimalWithZoosDaoImpl.class)
public class Animal {
    @SerializedName("id")
    @Expose
    @DatabaseField(id = true, columnName = "id")
    private int id;

    @SerializedName("name")
    @Expose
    @DatabaseField(columnName = "name")
    private String name;

    @SerializedName("url")
    @Expose
    @DatabaseField(columnName = "image_url")
    private String imageUrl;

    @SerializedName("zooParkId")
    @Expose
    private List<Integer> zooIds;

    private List<Zoopark> zooparkList;

    @SerializedName("habitat")
    @Expose
    @DatabaseField(columnName = "habitat")
    private String habitat;

    @SerializedName("geo_location")
    @Expose
    @DatabaseField(columnName = "geo_location")
    private String geo_location;

    @SerializedName("description")
    @Expose
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

    public String getLocation() {
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

    public List<Integer> getZooIds() {
        return zooIds;
    }

    public void setZooIds(List<Integer> zooIds) {
        this.zooIds = zooIds;
    }

    public void addZooPark(Zoopark zoo) {
        if (zooparkList == null) { zooparkList = new ArrayList<>(); }
        zooparkList.add(zoo);
    }

    public void addZooPark(List<Zoopark> zooList) {
        zooparkList = new ArrayList<>(zooList);
    }

    public List<Zoopark> getZooList() {
        return zooparkList;
    }
}
