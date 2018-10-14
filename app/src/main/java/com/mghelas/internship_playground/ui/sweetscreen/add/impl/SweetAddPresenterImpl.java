package com.mghelas.internship_playground.ui.sweetscreen.add.impl;

import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddModel;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddView;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddWireframe;

import java.util.List;

public class SweetAddPresenterImpl implements SweetAddPresenter {

    SweetAddView sweetAddView;
    SweetAddModel sweetAddModel;
    SweetAddWireframe sweetAddWireframe;

    public SweetAddPresenterImpl(SweetAddView sweetAddView, SweetAddModel sweetAddModel, SweetAddWireframe sweetAddWireframe) {
        this.sweetAddView = sweetAddView;
        this.sweetAddModel = sweetAddModel;
        this.sweetAddWireframe = sweetAddWireframe;
    }

    @Override
    public void viewInitialized() {
        sweetAddView.setOnAddClickHandler(this);
    }

    @Override
    public void add(Sweet sweet) {
        sweetAddModel.add(sweet);
    }

    @Override
    public void getAllIngredients() {
        sweetAddModel.getAllIngredients();
    }

    @Override
    public void onAddClicked(Sweet sweet) {
        sweetAddModel.add(sweet);
    }

    @Override
    public void goToList() {
        sweetAddWireframe.showListContent();
    }

    @Override
    public void onIngredientsLoaded(List<Ingredient> ingredients) {
        sweetAddView.bindData(ingredients);
    }
}
