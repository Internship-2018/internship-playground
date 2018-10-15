package com.mghelas.internship_playground.storage.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sweet_ingredients")
public class SweetIngredient {
    public final static String SWEET_ID_FIELD_NAME = "sweet_id";
    public final static String INGREDIENT_ID_FIELD_NAME = "ingredient_id";

    /**
     * This id is generated by the database and set on the object when it is passed to the create method. An id is
     * needed in case we need to update or delete this object in the future.
     */
    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField(foreign = true, columnName = SWEET_ID_FIELD_NAME)
    private Sweet sweet;

    @DatabaseField(foreign = true, columnName = INGREDIENT_ID_FIELD_NAME)
    private Ingredient ingredient;

    @DatabaseField
    private Double quantity;


    public SweetIngredient() {
    }

    public SweetIngredient(Sweet sweet, Ingredient ingredient, Double quantity) {
        this.sweet = sweet;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }
}
