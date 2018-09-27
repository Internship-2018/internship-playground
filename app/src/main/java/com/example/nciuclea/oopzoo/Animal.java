package com.example.nciuclea.oopzoo;

import java.util.List;

abstract class Animal {

    public String getType() {
        return type;
    }

    String type;
    final static public float maxLevel = 10;

    protected String name;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private int imageId;


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
    abstract List<AnimalStatusLine> getStatusLineList();
    abstract void stopAllActivities();
    abstract void updateActionStates(String name, boolean type);
}

interface Feedable {
    String NAME = "Hunger";
    String BUTTON_NAME = "FEED";
    void updateHunger();

    /* float getHungerLevel();
    void startFeeding();
    void stopFeeding(); */
}

interface CageCleanable {
    String NAME = "Cage";
    String BUTTON_NAME = "CLEAN";
    void updateCage();
}

interface Washable {
    String NAME = "Dirty";
    String BUTTON_NAME = "WASH";
    void updateDirtyness();
}
