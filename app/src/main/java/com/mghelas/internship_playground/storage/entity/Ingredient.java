package com.mghelas.internship_playground.storage.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ingredients")
public class Ingredient {

    public final static String ID_FIELD_NAME = "id";

    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private Integer id;
    @DatabaseField
    private String name;

    private Double quantity;

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ingredient(Integer id, String name, Double quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name;
    }
}

