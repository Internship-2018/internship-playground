package com.mghelas.internship_playground;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mghelas.internship_playground.adapters.SweetsAdapter;
import com.mghelas.internship_playground.sweetsfactory.Chocolate;
import com.mghelas.internship_playground.sweetsfactory.Lollipop;

import java.util.ArrayList;
import java.util.List;

public class AllProductsActivity extends Activity {

    private List<Object> sweetsList = new ArrayList<>();
    private SweetsAdapter sweetsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

        RecyclerView recyclerView = findViewById(R.id.allProducts);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareChocolateData();
        prepareLollipopData();
        sweetsAdapter = new SweetsAdapter(sweetsList);
        sweetsAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(sweetsAdapter);

    }

    private void prepareChocolateData() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Milk");
        ingredients.add("Cocoa beans");
        ingredients.add("Sugar");
        Chocolate chocolate = new Chocolate("Meteorit", 50.0, 10.0, true, 50);
        chocolate.setIngredients(ingredients);
        sweetsList.add(chocolate);
        chocolate = new Chocolate("chocolate 1", 30.0, 15.0, true, 75);
        chocolate.setIngredients(ingredients);
        sweetsList.add(chocolate);
        chocolate = new Chocolate("chocolate 2", 20.0, 12.0, true, 25);
        chocolate.setIngredients(ingredients);
        sweetsList.add(chocolate);

    }

    private void prepareLollipopData() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Sugar");
        Lollipop lollipop = new Lollipop("Lollipop 1", 5.0, 10.0, false, "Apple");
        ingredients.add(lollipop.getFlavour() + " concentrate");
        lollipop.setIngredients(ingredients);
        sweetsList.add(lollipop);
        ingredients.remove(lollipop.getFlavour());
        lollipop = new Lollipop("Lollipop 2", 7.0, 5.0, false, "Banana");
        ingredients.add(lollipop.getFlavour() + " concentrate");
        lollipop.setIngredients(ingredients);
        sweetsList.add(lollipop);
        ingredients.remove(lollipop.getFlavour());
        lollipop = new Lollipop("Lollipop 3", 8.0, 11.0, false, "Strawberry");
        ingredients.add(lollipop.getFlavour() + " concentrate");
        lollipop.setIngredients(ingredients);
        sweetsList.add(lollipop);

    }

}
