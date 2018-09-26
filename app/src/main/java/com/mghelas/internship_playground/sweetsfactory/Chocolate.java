package com.mghelas.internship_playground.sweetsfactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Chocolate extends Sweet {

    private Integer percentage;

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Override
    void manufacture() {
        System.out.println("mix " + this.getIngredients().toString());
    }

    @Override
    void manufacture(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("mix " + this.getIngredients().toString() + " on " + sdf.format(date));
    }
}
