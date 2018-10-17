package com.mghelas.internship_playground.ui.sweetscreen.add;

import com.mghelas.internship_playground.storage.entity.Ingredient;

import java.util.List;

public interface SweetAddView {
    void setOnAddClickHandler(AddClickHandler addClickHandler);
    void bindData(List<Ingredient> ingredients);
    void showError(String error);
}
