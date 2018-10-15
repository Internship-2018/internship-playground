package com.mtlepberghenov.internship_playground.storage.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "vehicle")
public class Vehicle {

  @SerializedName("id")
  @DatabaseField(generatedId = true)
  private int id;

  @SerializedName("type")
  @DatabaseField
  private String type;

  @SerializedName("manufacturer")
  @DatabaseField
  private String manufacturer;

  @SerializedName("model")
  @DatabaseField
  private String model;

  @SerializedName("color")
  @DatabaseField
  private String color;

  @SerializedName("year")
  @DatabaseField
  private String year;

  @SerializedName("imageUrl")
  @DatabaseField
  private String imageUrl;

  public Vehicle() {
    // needed by ormlite
  }

  public int getId() {
    return id;
  }

  public String getIdString() {
    return String.valueOf(id);
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
