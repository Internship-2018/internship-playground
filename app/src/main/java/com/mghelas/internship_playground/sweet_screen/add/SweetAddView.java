package com.mghelas.internship_playground.sweet_screen.add;

public interface SweetAddView {
    void setOnAddClickHandler(AddClickHandler addClickHandler);
    void setOnTypeChangeHandler(SweetTypeRadioHandler sweetTypeRadioHandler);
    void changeSweetType(String type);
}
