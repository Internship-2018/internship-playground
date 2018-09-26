package com.example.nciuclea.oopzoo;

class Tiger extends Animal implements Feedable, CageCleanable {

    Tiger(){
        hungerMaxLevel = 10;
        cageCleanMaxLevel = 10;
        isFed = false;
        isCageCleaned = false;
        hungerLevel = hungerMaxLevel;
        cageCleanLevel = cageCleanMaxLevel;
    }

    Tiger(float hungerLevel, float cageCleanLevel){
        this();
        this.hungerLevel = hungerLevel;
        this.cageCleanLevel = cageCleanLevel;
    }

    @Override
    public void updateHunger() {
        if (isFed && (hungerLevel < hungerMaxLevel)) {
            hungerLevel += 0.1;
        }
        else if (!isFed && (hungerLevel > 0)) {
            hungerLevel -= 0.02;
        }
    }

    @Override
    public float getHungerLevel() {
        return hungerLevel;
    }

    @Override
    public void startFeeding() {
        isFed = true;
    }

    @Override
    public void stopFeeding() {
        isFed = false;
    }

    @Override
    public void cleanCage() {
        if (cageCleanLevel < cageCleanMaxLevel){
            cageCleanLevel += 0.1;
        }
    }

    @Override
    public void decrementCleanCage() {
        if (cageCleanLevel > 0 && !isCageCleaned) {
            cageCleanLevel -= 0.01;
        }
    }
}
