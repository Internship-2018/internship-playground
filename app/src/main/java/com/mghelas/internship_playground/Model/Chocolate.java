package com.mghelas.internship_playground.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Chocolate extends Sweet {

    private Integer percentage;

    public Chocolate() {
    }

    public Chocolate(String title, Double price, Double weight, Boolean pricePerKg, Integer percentage) {
        super(title, price, weight, pricePerKg);
        this.percentage = percentage;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Override
    public String manufacture() {
        return "mix " + this.getIngredients().toString();
    }

    @Override
    public void manufacture(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("mix " + this.getIngredients().toString() + " on " + sdf.format(date));
    }
}
