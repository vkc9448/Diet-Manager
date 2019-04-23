/*
 * Diet Manager v1.0
 * Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
 * SWEN.383.01
 */

/**
 * FoodItems class will create food object
 */
package model;
import java.util.*;
//import model.Food;

public class FoodItem implements Food{

    private String foodName;
    private double calories;
    private double fat;
    private double carbs;
    private double protein;

    public FoodItem(ArrayList<String> foodItemList){
        foodName = foodItemList.get(1);
        calories = Double.parseDouble(foodItemList.get(2));
        fat = Double.parseDouble(foodItemList.get(3));
        carbs = Double.parseDouble(foodItemList.get(4));
        protein = Double.parseDouble(foodItemList.get(5));
    }

    public FoodItem(String foodName_, double calories_, double fat_, double carbs_, double protein_) {
        foodName = foodName_;
        calories = calories_;
        fat = fat_;
        carbs = carbs_;
        protein = protein_;
    }
    /**
     * Get food object
     */
    public String getName() {
        return foodName;
    }

    public double getCalories(){
        return calories;
    }

    public double getFat(){
        return fat;
    }

    public double getCarbs(){
        return carbs;
    }

    public double getProtein(){
        return protein;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    /**
     * Returns array of nutritional values for the user diet
     */
    public double[] getFoodData() {
        double[] diet = new double[]{calories, fat, carbs, protein};
        return diet;
    }

    public String printSummary(){
        return foodName + "\n calories - " + calories + "\n fat - " + fat + "\n carbs - " + carbs + "\n protein - " + protein + "\n";
    }

    public String writeOutCSVString(){
        String csvString = "b,"+foodName+","+calories+","+fat+","+carbs+","+protein;
        return csvString;
    }
} // FoodItems