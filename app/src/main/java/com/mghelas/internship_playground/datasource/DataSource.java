package com.mghelas.internship_playground.datasource;

import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static DataSource single_instance = null;

    public List<Sweet> sweetList;

    private DataSource() {
        sweetList = new ArrayList<>(prepareItems());
    }

    public static DataSource getInstance()
    {
        if (single_instance == null)
            single_instance = new DataSource();

        return single_instance;
    }

    private List<Sweet> prepareItems() {
        List<Sweet> items = new ArrayList<>();
        List<String> meteoritIngredients = new ArrayList<>();
        meteoritIngredients.add("Milk");
        meteoritIngredients.add("Cocoa beans");
        meteoritIngredients.add("Sugar");
        List<String> alunelIngredients = new ArrayList<>(meteoritIngredients);
        List<String> fistiIngredients = new ArrayList<>(meteoritIngredients);
        Chocolate chocolate = new Chocolate("Meteorit", 50.0, 10.0, true, 50);
        meteoritIngredients.add("Hazelnut");
//        chocolate.setIngredients(meteoritIngredients);
        items.add(chocolate);
        chocolate = new Chocolate("Alunel", 30.0, 15.0, true, 75);
        alunelIngredients.add("Walnut");
//        chocolate.setIngredients(alunelIngredients);
        items.add(chocolate);
        chocolate = new Chocolate("Fisti", 20.0, 12.0, true, 25);
        fistiIngredients.add("Pistachio");
//        chocolate.setIngredients(fistiIngredients);
        items.add(chocolate);


        List<String> curcubeuIngredients = new ArrayList<>();
        curcubeuIngredients.add("Sugar");
        List<String> jellyIngredients = new ArrayList<>(curcubeuIngredients);
        List<String> faniIngredients = new ArrayList<>(curcubeuIngredients);

        List<String> ingredients = new ArrayList<>();
        Lollipop lollipop = new Lollipop("Curcubeu", 5.0, 10.0, false, "Apple");
        curcubeuIngredients.add(lollipop.getFlavour() + " concentrate");
//        lollipop.setIngredients(curcubeuIngredients);
        items.add(lollipop);
        lollipop = new Lollipop("Jelly", 7.0, 5.0, false, "Banana");
        jellyIngredients.add(lollipop.getFlavour() + " concentrate");
//        lollipop.setIngredients(jellyIngredients);
        items.add(lollipop);
        lollipop = new Lollipop("Fani", 8.0, 11.0, false, "Strawberry");
        faniIngredients.add(lollipop.getFlavour() + " concentrate");
//        lollipop.setIngredients(faniIngredients);
        items.add(lollipop);

        return items;
    }
}
