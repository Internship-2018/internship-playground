package com.example.nciuclea.oopzoo;

abstract class Animal {
    String name;
    int imageId;
    protected float hungerLevel, hungerMaxLevel, cageCleanLevel, cageCleanMaxLevel;
    protected boolean isFed, isCageCleaned;
}

interface Feedable {
    void updateHunger();
    float getHungerLevel();
    void startFeeding();
    void stopFeeding();
}

interface CageCleanable {
    void cleanCage();
    void decrementCleanCage();
}
