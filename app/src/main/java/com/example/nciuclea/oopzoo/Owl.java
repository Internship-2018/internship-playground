package com.example.nciuclea.oopzoo;

import java.util.LinkedList;
import java.util.List;

public class Owl extends Animal implements Feedable, CageCleanable {


    Owl(){
        type = "Owl";
        isFed = false;
        isCageCleaned = false;
        hungerLevel = maxLevel;
        cageCleanLevel = maxLevel;
    }

    Owl(float hungerLevel, float cageCleanLevel){
        this();
        this.hungerLevel = hungerLevel;
        this.cageCleanLevel = cageCleanLevel;
    }

    @Override
    public void updateHunger() {
        if (isFed && (hungerLevel < maxLevel)) {
            hungerLevel += 0.5;
        }
        else if (!isFed && (hungerLevel > 0)) {
            hungerLevel -= 0.01;
        }
    }

    @Override
    public void updateCage() {
        if (isCageCleaned && (cageCleanLevel < maxLevel)) {
            cageCleanLevel += 0.5;
        }
        else if (!isCageCleaned && (cageCleanLevel > 0)) {
            cageCleanLevel -= 0.01;
        }
    }

    @Override
    void updateStats() {
        if (this instanceof Feedable) this.updateHunger();
        if (this instanceof CageCleanable) this.updateCage();
    }

    @Override
    List<AnimalStatusLine> getStatusLineList(){
        List<AnimalStatusLine> animalStatusLineList = new LinkedList<AnimalStatusLine>();

        if (this instanceof Feedable) animalStatusLineList.add(new AnimalStatusLine(Feedable.NAME,
                this.getHungerLevel(), Feedable.BUTTON_NAME));
        if (this instanceof CageCleanable) animalStatusLineList.add(new AnimalStatusLine(CageCleanable.NAME,
                this.getCageCleanLevel(), CageCleanable.BUTTON_NAME));

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
        }
    }

    @Override
    void stopAllActivities() {
        isFed = false;
        isCageCleaned = false;
    }

}