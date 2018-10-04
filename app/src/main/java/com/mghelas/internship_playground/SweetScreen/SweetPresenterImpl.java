package com.mghelas.internship_playground.SweetScreen;

import android.support.v7.widget.RecyclerView;

import com.mghelas.internship_playground.Model.Chocolate;
import com.mghelas.internship_playground.Model.Lollipop;

import java.util.ArrayList;
import java.util.List;

public class SweetPresenterImpl implements SweetPresenterIntf {
    private SweetFragment sweetFragment;

    public SweetPresenterImpl(SweetFragment sweetFragment) {
        this.sweetFragment = sweetFragment;
    }

    @Override
    public void getChocolateItems() {
        List<String> meteoritIngredients = new ArrayList<>();
        meteoritIngredients.add("Milk");
        meteoritIngredients.add("Cocoa beans");
        meteoritIngredients.add("Sugar");
        List<String> alunelIngredients = new ArrayList<>(meteoritIngredients);
        List<String> fistiIngredients = new ArrayList<>(meteoritIngredients);
        Chocolate chocolate = new Chocolate("Meteorit", 50.0, 10.0, true, 50);
        meteoritIngredients.add("Hazelnut");
        chocolate.setIngredients(meteoritIngredients);
        sweetFragment.getSweetsList().add(chocolate);
        chocolate = new Chocolate("Alunel", 30.0, 15.0, true, 75);
        alunelIngredients.add("Walnut");
        chocolate.setIngredients(alunelIngredients);
        sweetFragment.getSweetsList().add(chocolate);
        chocolate = new Chocolate("Fisti", 20.0, 12.0, true, 25);
        fistiIngredients.add("Pistachio");
        chocolate.setIngredients(fistiIngredients);
        sweetFragment.getSweetsList().add(chocolate);

        sweetFragment.populateView();
    }

    @Override
    public void getLollipopItems() {
        List<String> curcubeuIngredients = new ArrayList<>();
        curcubeuIngredients.add("Sugar");
        List<String> jellyIngredients = new ArrayList<>(curcubeuIngredients);
        List<String> faniIngredients = new ArrayList<>(curcubeuIngredients);

        List<String> ingredients = new ArrayList<>();
        Lollipop lollipop = new Lollipop("Curcubeu", 5.0, 10.0, false, "Apple");
        curcubeuIngredients.add(lollipop.getFlavour() + " concentrate");
        lollipop.setIngredients(curcubeuIngredients);
        sweetFragment.getSweetsList().add(lollipop);
        lollipop = new Lollipop("Jelly", 7.0, 5.0, false, "Banana");
        jellyIngredients.add(lollipop.getFlavour() + " concentrate");
        lollipop.setIngredients(jellyIngredients);
        sweetFragment.getSweetsList().add(lollipop);
        lollipop = new Lollipop("Fani", 8.0, 11.0, false, "Strawberry");
        faniIngredients.add(lollipop.getFlavour() + " concentrate");
        lollipop.setIngredients(faniIngredients);
        sweetFragment.getSweetsList().add(lollipop);

        sweetFragment.populateView();
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        adapter.notifyDataSetChanged();
        this.sweetFragment.getRecyclerView().setAdapter(adapter);
    }
}
