package com.mghelas.internship_playground.sweetscreen.add;

public interface SweetAddView {
    void setOnAddClickHandler(AddClickHandler addClickHandler);
    void setOnTypeChangeHandler(SweetTypeRadioHandler sweetTypeRadioHandler);
    void changeSweetType(String type);
}
