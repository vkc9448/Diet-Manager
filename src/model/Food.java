/*
 * Diet Manager v1.0
 * Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
 * SWEN.383.01
 */

/**
 * Provides interface for all. (food items and recipe)
 * Returns information related to nutrition of a diet such as calories, carbs, fats, carbs proteins
 * Returns the name of the food item or the recipe.
 */
package model;

public interface Food{

    /**
     * Returns information related to nutrition of a diet
     */
    public String printSummary();

    /**
     * Get the name of the food item or recipe
     */
    public String getName();

} // Food