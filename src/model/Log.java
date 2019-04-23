/*
 * Diet Manager v1.0
 * Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
 * SWEN.383.01
 *
 *The log class stores a single date and deatils about it. The logHub class mangaes
 * these log objects and allows the dietManager_Application class to request or change
 * data for a date.
 */
package model; 
import java.util.*;

public class Log{
    private int year;
    private int month;
    private int day;
    private String dateString;
    private double calorieLimit;
    private double weight;
    private ArrayList<String> foods = new ArrayList<String>();
    private ArrayList<Double> foodServings = new ArrayList<Double>();//the food in each position of the foods arraylist corraspons with the
    //item in the foodServings arraylist. ie: foods.get(2) is the name of the
    //food and foodServings.get(2) is the number of servings of that food.
    private ArrayList<String> exercises = new ArrayList<String>();
    private ArrayList<Double> minutesExercised = new ArrayList<Double>();

    /**
     *The log() constructers allow you to create a log class using either the date,
     * the arsed csv string array, or the individual perameters of the log class.
     * @param year, month, day as int's
     * @return void
     */
    public Log(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        dateString = month+"-"+day+"-"+year;
        System.out.println("Log object created for " + dateString);
    }

    /**
     *The log() constructers allow you to create a log class using either the date,
     * the arsed csv string array, or the individual perameters of the log class.
     * @param An array of String in the format CSVParser() uses when parsing log.csv
     * @return void
     */
    public Log(ArrayList<String> list){
        year = Integer.parseInt(list.get(0));
        month = Integer.parseInt(list.get(1));
        day = Integer.parseInt(list.get(2));
        dateString = month+"-"+day+"-"+year;
        System.out.println("Log object created for " + dateString);
        this.takeLogArray(list);

    }

    /**
     *The log() constructers allow you to create a log class using either the date,
     * the arsed csv string array, or the individual perameters of the log class.
     * @param year, month, day, calorieLimit, weight
     * @return void
     */
    public Log(int year, int month, int day, double calorieLimit, double weight){
        this.year = year;
        this.month = month;
        this.day = day;
        this.calorieLimit = calorieLimit;
        this.weight = weight;
        dateString = month+"-"+day+"-"+year;
        System.out.println("Log object created for " + dateString);
    }

    /**
     * in the case where a log already exists takeLogArray will take a Array of
     * a Log item from the log.csv file and retrive the weight/calorie/food/exercise from
     * that array and add it to this log entity.
     */
    public void takeLogArray(ArrayList<String> list){
        System.out.println("array sent to takeLogArray, arrays 3rd object is: " + list.get(3));
        switch(list.get(3)){
            case "w":
                //weight
                weight = Double.parseDouble(list.get(4));
                break;
            case "c":
                //calorie
                calorieLimit = Double.parseDouble(list.get(4));
                break;
            case "f":
                //food
                foods.add(list.get(4));
                foodServings.add(Double.parseDouble(list.get(5)));
            case "e":
                //exercise
                exercises.add(list.get(4));
                minutesExercised.add(Double.parseDouble(list.get(5)));
            default:
                System.out.println("Error in creating Log object from ArrayList: " +list + writeOutCSVString());
        }

    }

    /**
     * AddFood allows you to add a food item to the array of food items the user consumed on a day.
     * @param food
     * @param portions
     */
    public void addFood(String food, double portions){
        foods.add(food);
        foodServings.add(portions);
    }

    /**
     * deleteFood will remove the first instance of that food for this day that
     * matches the name and portion of the food passed in.
     * @param food
     * @param portions
     */
    public void deleteFood(String food, double portions){
        for(int i = 0; i < foods.size();i++){
            if (foods.get(i) == food && foodServings.get(i) == portions){
                System.out.print("The food: " + foods.get(i) + "(" + foodServings.get(i) + ") was deleted.");
                foods.remove(i);
                foodServings.remove(i);
            }
        }
    }

    /**
     * add exercise allows you to amnually add a exercise to this date.
     * @param exercise - String of the exercise name.
     * @param minutes - double of the number of minutes performed.
     */
    public void addExercise(String exercise, double minutes){
        exercises.add(exercise);
        minutesExercised.add(minutes);
    }

    /**
     * Delete a exercise from this date
     * @param exercise - String of the exercise name.
     * @param minutes - double of the number of minutes performed.
     */
    public void deleteExercise(String exercise, double minutes){
        for(int i = 0; i < exercises.size();i++){
            if (exercises.get(i) == exercise && minutesExercised.get(i) == minutes){
                System.out.print("The exercise: " + exercises.get(i) + "(" + minutesExercised.get(i) + ") was deleted.");
                exercises.remove(i);
                minutesExercised.remove(i);
            }
        }
    }

    /**
     * getDateString is used to get the date of this log in a easy string format.
     * @return a string of the date in the format (month+"-"+day+"-"+year)
     */
    public String getDateString(){
        return dateString;
    }

    /**
     * getCalorieLimit retrives the calorie limit for this day. LogHub will check if the calorieLimit is
     * null and retrive the entered calorie limit for another day or use the default.
     * @return double calorieLimit
     */
    public double getCalorieLimit(){
        return calorieLimit;
    }

    public void setCalorieLimit(double calorieLimit) {
        this.calorieLimit = calorieLimit;
    }

    /**
     * getWeight retrives the weight for this day. LogHub will check if the weight is
     * null and retrive the entered weight for another day or use the default.
     * @return weight
     */
    public double getWeight(){
        return weight;
    }

    public ArrayList<String> getFoods() {
        return foods;
    }

    public ArrayList<Double> getFoodServings() {
        return foodServings;
    }

    public ArrayList<String> getExercises() {
        return exercises;
    }

    public ArrayList<Double> getMinutesExercised() {
        return minutesExercised;
    }

    /**
     * getFoodsConsumed returns a string list of all of the foods consumed on this day.
     * @return a list of foods consumed
     */
    public String getFoodsConsumed(){
        String foodsEaten = "Foods For " + getDateString() + "\n";
        for(int i = 0; i < foods.size();i++){
            foodsEaten += (foodServings.get(i) + " serving(s) of " + foods.get(i) + "\n");
        }
        return foodsEaten;
    }

    /**
     * getAFoodsPortion returns the portion of the food consumed this day.
     * @param foodName
     * @return an int of the number of servings for that food.
     */
    public double getAFoodsPortion(String foodName){
        for(int i = 0; i < foods.size();i++){
            if (String.valueOf(foods.get(i)) == foodName){
                return foodServings.get(i);
            }
        }
        System.out.println("error getting a foods portion in log.java. no such food exists");
        return 0;
    }

    /**
     * writeOutAsArrayString returns a string in the format CSVParser expects and is used to
     * write the log object to the log.csv file.
     * @return a csv string containing the data for this date.
     */
    public String writeOutCSVString(){
        String logsCSV = "";

        //add weight
        if(weight != 0){
            logsCSV.concat(year+",");
            logsCSV.concat(month+",");
            logsCSV.concat(day+",");
            logsCSV.concat("w,");
            logsCSV.concat(weight+"\n");
        }

        //add calorie limit
        if(calorieLimit != 0){
            logsCSV.concat(year+",");
            logsCSV.concat(month+",");
            logsCSV.concat(day+",");
            logsCSV.concat("c,");
            logsCSV.concat(calorieLimit+"\n");
        }

        //add the food items.
        for(int i = 0; i< foods.size(); i++){
            logsCSV.concat(year+",");
            logsCSV.concat(month+",");
            logsCSV.concat(day+",");
            logsCSV.concat("f,");
            logsCSV.concat(foods.get(i)+",");
            logsCSV.concat(foodServings.get(i)+"\n");
        }

        return logsCSV;
    }
}//log