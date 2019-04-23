package model;

import java.lang.*;
import java.text.*;
import java.util.*;

/**
 * DietManager Class
 * Execute the program
 */
public class DietManager {
    double cal;
    FoodHub fdHub;
    LogHub lgHub;
    ExerciseHub exHub;
    ArrayList<FoodItem> foodList;
    ArrayList<String> foodLog;

    public DietManager()
    {
        fdHub = new FoodHub();
        lgHub = new LogHub();
        exHub = new ExerciseHub();
        foodList= new ArrayList<FoodItem>();
        foodLog= new ArrayList<String>();
    }

    public String addFood()
    {  String food="";
        fdHub.parseCSV();
       
        return food;
    }

    public double addWeight(String date)
    {
        lgHub.readCSV();
        return lgHub.getWeight(date);
        
    }

   /* public void setDate()
    {
        lgHub.readCSV();
        lgHub.addDate();
    }*/

    public void setMileStone(String date, double cal)
    {
        lgHub.readCSV();
        lgHub.setCalorieLimit(date, cal);
    }
    
    public double getMileStone(String date)
    {
        lgHub.readCSV();
        return lgHub.getCalorieLimit(date);
    }


    public double getTotalDatesCalories(String date){
        //The total calories expended in exercise for the day.
        cal=0;
        fdHub.parseCSV();
        foodList=fdHub.returnFoodList();
        lgHub.readCSV();
        foodLog=lgHub.getFoods(date);
        for(String foodName: foodLog)
        {System.out.println(foodName+"aa");
        for(FoodItem food: foodList)
        {
        if(foodName==food.getName())
        {cal+=food.getCalories();}
        
        }
        }
        
        //get arraylist of foods eaten from log.
        //get calorie values of each food from fooditems.
        //return sum of values.
        return cal;
    }

    public double calculateCaloriesBurned(String date){
        //get the calories burned from exercise.

        //get exercise array from log for date.
        //get weight from log
        //get the calories burned for each exercise.

        //in a for loop for each exercise calculate the calores burned useing the math provided and add up all the calories burned and return the sum.

        /*180.0 * (160.0/100.0) * (15.0/60.0) = 72.0 calories (rounded to the nearest calorie) where:

        180.0 = calories per hour per 100 pounds for Gardening

                (160.0/100.0) = weight in 1/100 pounds

                (15.0/60.0) = fractional hours*/
                return 0.0;
    }

    public double getNetCaloriesForDate(String date){
        //The net calories (consumed - expended) for the day (this may be negative).
        //take getTotalDatesCalories and subtract calculateCaloriesBurned then return that number
        return 0.0;
    }

    public boolean ifNetCaloriesExceeded(String date){
        //get cal limit from log.
        //if getNetCaloriesForDate is greater then cal limit return true, otherwise return false.
        return true;
    }

    public String getDaysNutritionBreakdown(String date){
         return "a";
    }

}