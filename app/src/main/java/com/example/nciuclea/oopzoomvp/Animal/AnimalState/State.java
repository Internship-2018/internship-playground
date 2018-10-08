package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

import com.example.nciuclea.oopzoomvp.R;

public enum State{
    GREEN("GOOD", R.color.green),
    YELLOW("OK", R.color.yellow),
    RED("BAD", R.color.red),
    BLACK("DEAD", R.color.black); //dead
    State(String text, int color){
        this.text = text;
        this.color = color;
    }

    private final String text;
    private final int color;

    public String getText() {
        return text;
    }

    public int getColor() {
        return color;
    }
}
