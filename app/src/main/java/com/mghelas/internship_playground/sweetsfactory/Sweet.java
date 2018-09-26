package com.mghelas.internship_playground.sweetsfactory;

import java.util.Date;
import java.util.List;

public abstract class Sweet {
    private String title;
    private Double price;
    private Double weight;
    private Boolean pricePerKg;
    private List<String> ingredients;

    public Boolean getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Boolean pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
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

    abstract void manufacture();
    abstract void manufacture(Date date);
}
