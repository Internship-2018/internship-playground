package com.example.nciuclea.oopzoomvp.ZooScreen;

import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.Animal;

import java.util.List;

interface ZooView {
    void updateAnimalList(List<Animal> newAnimalList);
}
