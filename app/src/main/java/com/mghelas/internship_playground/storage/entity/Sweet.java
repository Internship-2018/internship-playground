package com.mghelas.internship_playground.storage.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@DatabaseTable(tableName = "sweets")
public class Sweet {
    @DatabaseField(id = true)
    private Integer id;
    @DatabaseField
    private String title;
    @DatabaseField
    private Double price;
    @DatabaseField
    private Double weight;
    @DatabaseField
    private Boolean pricePerKg;

    private List<Ingredient> ingredients;

    public Sweet() {
    }

    public Sweet(String title, Double price, Double weight, Boolean pricePerKg) {
        this.title = title;
        this.price = price;
        this.weight = weight;
        this.pricePerKg = pricePerKg;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Boolean pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    public String manufacture() {
        return "mix " + this.getIngredients().toString();
    }

    public void manufacture(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("mix " + this.getIngredients().toString() + " on " + sdf.format(date));
    }
}
