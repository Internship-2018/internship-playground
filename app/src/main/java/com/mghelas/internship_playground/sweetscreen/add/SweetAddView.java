package com.mghelas.internship_playground.sweetscreen.add;

import com.mghelas.internship_playground.entity.Ingredient;

import java.util.List;

public interface SweetAddView {
    void setOnAddClickHandler(AddClickHandler addClickHandler);
    void setOnTypeChangeHandler(SweetTypeRadioHandler sweetTypeRadioHandler);
    void changeSweetType(String type);
    void bindData(List<Ingredient> ingredients);
}
