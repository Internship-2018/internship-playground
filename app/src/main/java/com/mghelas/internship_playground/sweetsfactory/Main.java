package com.mghelas.internship_playground.sweetsfactory;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Chocolate chocolate = new Chocolate();
        chocolate.setWeight(10.0);
        chocolate.setTitle("Meteorit");
        chocolate.setPricePerKg(true);
        chocolate.setPrice(50.0);
        chocolate.setPercentage(50);

        String[] ingredients = {"sugar", "milk", "cocoa"};
        chocolate.setIngredients(Arrays.asList(ingredients));

        chocolate.manufacture();
        chocolate.manufacture(new Date());

    }
}
