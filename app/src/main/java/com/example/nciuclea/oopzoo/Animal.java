package com.example.nciuclea.oopzoo;

abstract class Animal {

    final static public float maxLevel = 10;
    String name;
    int imageId;


    public float getHungerLevel() {
        return hungerLevel;
    }

    protected float hungerLevel;

    public float getCageCleanLevel() {
        return cageCleanLevel;
    }

    protected float cageCleanLevel;

    public void setFed(boolean fed) {
        isFed = fed;
    }

    protected boolean isFed;

    public void setCageCleaned(boolean cageCleaned) {
        isCageCleaned = cageCleaned;
    }

    protected boolean isCageCleaned;
    abstract void updateStats();
}

interface Feedable {
    void updateHunger();
    /* float getHungerLevel();
    void startFeeding();
    void stopFeeding(); */
}

interface CageCleanable {
    void updateCage();
}
