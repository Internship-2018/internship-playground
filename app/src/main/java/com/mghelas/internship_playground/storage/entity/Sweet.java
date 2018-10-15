package com.mghelas.internship_playground.storage.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@DatabaseTable(tableName = "sweets")
public class Sweet {
    @DatabaseField
    private Integer id;
    @DatabaseField
    private String type;
    @DatabaseField
    private String name;
    @DatabaseField
    private Date expiryDate;
    @DatabaseField
    private String confectionerName;

    private List<Ingredient> ingredients;

    public Sweet() {
    }

    public Sweet(String type, String name, Date expiryDate, String confectionerName) {
        this.type = type;
        this.name = name;
        this.expiryDate = expiryDate;
        this.confectionerName = confectionerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getConfectionerName() {
        return confectionerName;
    }

    public void setConfectionerName(String confectionerName) {
        this.confectionerName = confectionerName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String manufacture() {
        return "mix " + this.getIngredients().toString();
    }

    public void manufacture(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("mix " + this.getIngredients().toString() + " on " + sdf.format(date));
    }

}
