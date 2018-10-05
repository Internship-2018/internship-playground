package com.mtlepberghenov.internship_playground.screens.vehiclelist.model.entity;

public abstract class Vehicle {
  private String type;
  private String make;
  private String model;
  private String color;
  private int year;

  public Vehicle(String type, String make, String model, String color, int year) {
    this.type = type;
    this.make = make;
    this.model = model;
    this.color = color;
    this.year = year;
  }

  public String getType() {
    return type;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  public String getYear() {
    return String.valueOf(year);
  }
}
