package com.mghelas.internship_playground.sweetsfactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lollipop extends Sweet {
    private String flavour;

    public Lollipop(String title, Double price, Double weight, Boolean pricePerKg, String flavour) {
        super(title, price, weight, pricePerKg);
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    void manufacture() {
        System.out.println("Mix ingredients, put in freezez...");
    }

    @Override
    void manufacture(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Mix ingredients, put in freezez... on " + sdf.format(date));
    }
}
