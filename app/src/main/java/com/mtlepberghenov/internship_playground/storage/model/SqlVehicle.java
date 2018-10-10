package com.mtlepberghenov.internship_playground.storage.model;

import android.text.Editable;

public class SqlVehicle {

  private long id;
  private Editable type;
  private Editable model;
  private Editable color;
  private Editable year;


  public SqlVehicle(Editable type, Editable model, Editable color, Editable year) {
    this.type = type;
    this.model = model;
    this.color = color;
    this.year = year;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public Editable getType() {
    return type;
  }

  public Editable getModel() {
    return model;
  }

  public Editable getColor() {
    return color;
  }

  public Editable getYear() {
    return year;
  }
}
