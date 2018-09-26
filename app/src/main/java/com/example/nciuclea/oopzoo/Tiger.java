package com.example.nciuclea.oopzoo;

class Tiger extends Animal implements Feedable, CageCleanable {

    Tiger(){
        isFed = false;
        isCageCleaned = false;
        hungerLevel = maxLevel;
        cageCleanLevel = maxLevel;
    }

    Tiger(float hungerLevel, float cageCleanLevel){
        this();
        this.hungerLevel = hungerLevel;
        this.cageCleanLevel = cageCleanLevel;
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
    void updateStats() {
        updateHunger();
        updateCage();
    }
}
