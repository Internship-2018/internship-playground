package com.mghelas.internship_playground.entity;

public class Ingredient {
    private Integer id;
    private String title;

    public Ingredient() {
    }

    public Ingredient(String title) {
        this.title = title;
    }

    public Ingredient(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

