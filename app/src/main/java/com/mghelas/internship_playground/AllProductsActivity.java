package com.mghelas.internship_playground;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.mghelas.internship_playground.adapters.SweetsAdapter;
import com.mghelas.internship_playground.sweetsfactory.Chocolate;
import com.mghelas.internship_playground.sweetsfactory.Lollipop;
import com.mghelas.internship_playground.sweetsfactory.Sweet;

import java.util.ArrayList;
import java.util.List;

public class AllProductsActivity extends Activity {

    private List<Sweet> sweetsList = new ArrayList<>();
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


        Answers.getInstance().logContentView(new ContentViewEvent());
        Answers.getInstance().logContentView(new ContentViewEvent()
                .putContentName("Answers setup process super easy!")
                .putContentType("Technical documentation")
                .putContentId("article-350"));
    }

    private void prepareChocolateData() {
        List<String> meteoritIngredients = new ArrayList<>();
        meteoritIngredients.add("Milk");
        meteoritIngredients.add("Cocoa beans");
        meteoritIngredients.add("Sugar");
        List<String> alunelIngredients = new ArrayList<>(meteoritIngredients);
        List<String> fistiIngredients = new ArrayList<>(meteoritIngredients);
        Chocolate chocolate = new Chocolate("Meteorit", 50.0, 10.0, true, 50);
        meteoritIngredients.add("Hazelnut");
        chocolate.setIngredients(meteoritIngredients);
        sweetsList.add(chocolate);
        chocolate = new Chocolate("Alunel", 30.0, 15.0, true, 75);
        alunelIngredients.add("Walnut");
        chocolate.setIngredients(alunelIngredients);
        sweetsList.add(chocolate);
        chocolate = new Chocolate("Fisti", 20.0, 12.0, true, 25);
        fistiIngredients.add("Pistachio");
        chocolate.setIngredients(fistiIngredients);
        sweetsList.add(chocolate);

    }

    private void prepareLollipopData() {
        List<String> curcubeuIngredients = new ArrayList<>();
        curcubeuIngredients.add("Sugar");
        List<String> jellyIngredients = new ArrayList<>(curcubeuIngredients);
        List<String> faniIngredients = new ArrayList<>(curcubeuIngredients);

        List<String> ingredients = new ArrayList<>();
        Lollipop lollipop = new Lollipop("Curcubeu", 5.0, 10.0, false, "Apple");
        curcubeuIngredients.add(lollipop.getFlavour() + " concentrate");
        lollipop.setIngredients(curcubeuIngredients);
        sweetsList.add(lollipop);
        lollipop = new Lollipop("Jelly", 7.0, 5.0, false, "Banana");
        jellyIngredients.add(lollipop.getFlavour() + " concentrate");
        lollipop.setIngredients(jellyIngredients);
        sweetsList.add(lollipop);
        lollipop = new Lollipop("Fani", 8.0, 11.0, false, "Strawberry");
        faniIngredients.add(lollipop.getFlavour() + " concentrate");
        lollipop.setIngredients(faniIngredients);
        sweetsList.add(lollipop);
    }

}
