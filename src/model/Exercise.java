/*
 * Diet Manager v1.0
 * Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
 * SWEN.383.01
 *
 *The Exercise class will store exercise objects
 */
 package model;
 import java.util.*;
 

public class Exercise{
    private String exercise;
    private double caloriesBurned;

    public Exercise(String exerciseName, double calories){
        exercise = exerciseName;
        caloriesBurned=calories;
    }

    public Exercise (ArrayList<String> eList){
        exercise = eList.get(0);
        caloriesBurned = Double.parseDouble(eList.get(1));
    }

    public double getCaloriesBurned(){
        return caloriesBurned;
    }
    
    public String getName(){
     return exercise;
    }

    public String getExercise() {
        return exercise;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public String writeOutCSVString(){
        String csvString = "e,"+exercise+","+caloriesBurned;
        return csvString;
    }
}