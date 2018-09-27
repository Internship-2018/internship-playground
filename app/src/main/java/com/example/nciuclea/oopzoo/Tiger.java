package com.example.nciuclea.oopzoo;

import java.util.LinkedList;
import java.util.List;

class Tiger extends Animal implements Feedable, CageCleanable, Washable {

    public float getDirtyLevel() {
        return dirtyLevel;
    }

    float dirtyLevel;
    boolean isWashed;

    void setWashed(boolean isWashed) {
        this.isWashed = isWashed;
    }

    Tiger(){
        type = "Tiger";
        stopAllActivities();
        hungerLevel = maxLevel;
        cageCleanLevel = maxLevel;
        dirtyLevel = maxLevel;
    }

    Tiger(float hungerLevel, float cageCleanLevel, float dirtyLevel){
        this();
        this.hungerLevel = hungerLevel;
        this.cageCleanLevel = cageCleanLevel;
        this.dirtyLevel = dirtyLevel;
    }

    @Override
    public void updateHunger() {
        if (isFed && (hungerLevel < maxLevel)) {
            hungerLevel += 0.1;
        }
        else if (!isFed && (hungerLevel > 0)) {
            hungerLevel -= 0.02;
        }
    }

    @Override
    public void updateCage() {
        if (isCageCleaned && (cageCleanLevel < maxLevel)) {
            cageCleanLevel += 0.1;
        }
        else if (!isCageCleaned && (cageCleanLevel > 0)) {
            cageCleanLevel -= 0.01;
        }
    }

    @Override
    public void updateDirtyness() {
        if (isWashed && (dirtyLevel < maxLevel)) {
            dirtyLevel += 0.2;
        }
        else if (!isWashed && (dirtyLevel > 0)) {
            dirtyLevel -= 0.05;
        }
    }

    @Override
    void updateStats() {
        if (this instanceof Feedable) this.updateHunger();
        if (this instanceof CageCleanable) this.updateCage();
        if (this instanceof Washable) this.updateDirtyness();
    }

    @Override
    List<AnimalStatusLine> getStatusLineList(){
        List<AnimalStatusLine> animalStatusLineList = new LinkedList<AnimalStatusLine>();

        if (this instanceof Feedable) animalStatusLineList.add(new AnimalStatusLine(Feedable.NAME,
                this.getHungerLevel(), Feedable.BUTTON_NAME));
        if (this instanceof CageCleanable) animalStatusLineList.add(new AnimalStatusLine(CageCleanable.NAME,
                this.getCageCleanLevel(), CageCleanable.BUTTON_NAME));
        if (this instanceof Washable) animalStatusLineList.add(new AnimalStatusLine(Washable.NAME,
                this.getDirtyLevel(), Washable.BUTTON_NAME));

        return animalStatusLineList;
    }

    @Override
    void updateActionStates(String name, boolean type){
        switch (name) {
            case Feedable.NAME:
                this.setFed(type);
                return;
            case CageCleanable.NAME:
                this.setCageCleaned(type);
                return;
            case Washable.NAME:
                this.setWashed(type);
                return;
        }
    }

    @Override
    void stopAllActivities() {
        isFed = false;
        isCageCleaned = false;
        isWashed = false;
    }

}
