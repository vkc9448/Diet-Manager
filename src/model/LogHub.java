/*
 * Diet Manager v1.0
 * Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
 * SWEN.383.01
 *
 *The Log class will work with log csv files to
 * retrive and delete data at the prompt of DietManager
 */

package model;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class LogHub{
    ArrayList<Log> logsList; //An array of Log Objects that store information on each date.
    String logFile; //The name of the csv file containing the log information.

    public LogHub()
    {
    logFile = "model/log.csv";
    logsList = new ArrayList<Log>();
    }
    /**
     * readCSV() calls the CSV parser and retrives a ArrayList of ArrayLists and then parses it into log objcts.
     */
    public void readCSV(){
        CSVParser parser = new CSVParser();
        String tempDateString = "";
        ArrayList<ArrayList<String>> tempList = parser.parseCSV(logFile);
        for(ArrayList<String> log:tempList){
            tempDateString = Integer.parseInt(log.get(1))+"-"+Integer.parseInt(log.get(2))+"-"+log.get(0);
            System.out.println("Parsing log object for date: " + tempDateString + " of type: " + log.get(3));

            //the parsing is to drop the 0 before month/days.
            if (checkIfLogExists(tempDateString)){
                getLogFromDateString(tempDateString).takeLogArray(log);
                System.out.println("loghub readcsv if: " + tempDateString);
            }
            else{
                Log l = new Log(log);
                logsList.add(l);
                System.out.println("loghub readcsv else: " + tempDateString);
            }

            /*for(Log existingLog:logsList){
                if (existingLog.getDateString() == (log.get(1)+"-"+log.get(2)+"-"+log.get(0))){//getDateString returns the day in the format (month+"-"+day+"-"+year)
                    //a log for this date already exists.
                    existingLog.takeLogArray(log);
                } else{
                    //a log for this date does not yet exist.
                    Log l = new Log(log);
                    logsList.add(l);
                }
            }*/
        }//end of parse csv
    }

    /**
     * addLog allows you to add a new log object.
     * @param year
     * @param month
     * @param day
     * @param calorieLimit - the calorie limit of this date.
     * @param weight - the weight limit of this date.
     */
    public boolean addLog(int year, int month, int day, double calorieLimit, double weight){
        //check that log doesnt already exist before creating a new log.
        if(checkIfLogExists(month+"-"+day+"-"+year)) {return false;}
        //create a new log.
        Log l = new Log(year, month, day, calorieLimit, weight);
        logsList.add(l);
        return true;
    }

    /**
     * addLog allows you to add a new log object.
     * @param year
     * @param month
     * @param day
     */
    public boolean addLog(int year, int month, int day) {
        //check that log doesnt already exist before creating a new log.
        if(checkIfLogExists(month+"-"+day+"-"+year)) {return false;}
        //create a new log.
        Log l = new Log(year, month, day);
        logsList.add(l);
        return true;
    }

    /**
     *remove log accepts a string of MM-DD-YYYY finds a corrasponding log and deletes it
     *@param A string of date in MM-DD-YYYY identifying the log to be deleted.
     *@return true if log was found a removed. False if no log was found for date.
     */
    public boolean removeLog(String _dateString){
        for(int i = 0; i< logsList.size(); i++){
            if (logsList.get(i).getDateString() == _dateString){
                logsList.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * addFood adds a food to a dates log.
     * @param date - formated as month+"-"+day+"-"+year
     * @param food - String food
     * @param portions - int portions
     */
    public void addFood(String date, String food, double portions){
        getLogFromDateString(date).addFood(food, portions);
    }

    /**
     * delete a food item from a date
     * @param date - formated as month+"-"+day+"-"+year
     * @param food - String food
     * @param portions - int portions
     */
    public void deleteFood(String date, String food, double portions){
        getLogFromDateString(date).deleteFood(food, portions);
    }

    /**
     * add exercise allows you to amnually add a exercise to a date.
     * @param date - formated as month+"-"+day+"-"+year
     * @param exercise - String of the exercise name.
     * @param minutes - double of the number of minutes performed.
     */
    public void addExercise(String date, String exercise, double minutes){
        getLogFromDateString(date).addExercise(exercise, minutes);
    }

    /**
     * Delete a exercise from a date
     * @param date - formated as month+"-"+day+"-"+year
     * @param exercise - String of the exercise name.
     * @param minutes - double of the number of minutes performed.
     */
    public void deleteExercise(String date, String exercise, double minutes){
        getLogFromDateString(date).deleteExercise(exercise,minutes);
    }

    /**
     * getCalorieLimit will retrive the limit for that date if it exists. If it doesnt exist it will retrive the
     * calorie limit from the most recent log date. If none of our recorded dates have a calorie limit it will
     * return the default of 2000.0.
     * @param date - formated as month+"-"+day+"-"+year
     * @return the calorie limit of that date as a double.
     */
    public double getCalorieLimit(String date){
        double calLim;
        calLim = getLogFromDateString(date).getCalorieLimit();
        if ((calLim != 0)){
            //There is a calorie limit for this date.
            return calLim;
        }
        else {
            //CalorieLimit was not entered by the user. retrive the most recent calorie limit or the default.
            for (int i = logsList.size(); i > 0; i--){
                if (logsList.get(i).getCalorieLimit() != 0){
                    return logsList.get(i).getCalorieLimit();
                }
            }
            //No Log has a calorie limit. return the default.
            return 2000.0;
        }
    }

    public void setCalorieLimit(String date, double calLimit){
        getLogFromDateString(date).setCalorieLimit(calLimit);
    }
    /**
     * getWegiht will retrive the weight for that date if it exists. If it doesnt exist it will retrive the
     * weight from the most recent log date. If none of our recorded dates have a weight stored it will
     * return the default of 150.0.
     * @param date - formated as month+"-"+day+"-"+year
     * @return double weight
     */
    public double getWeight(String date){
        double wgt = 0; //temporary weight holder
        try{
            wgt = getLogFromDateString(date).getWeight();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        if (wgt != 0){
            //There is a weight for this date.
            return wgt;
        }
        else {
            //weight was not entered by the user. retrive the most recent weight or the default.
            for (int i = logsList.size(); i > 0; i--){
                if (logsList.get(i).getWeight() != 0){
                    return logsList.get(i).getWeight();
                }
            }
            //No Log has a calorie limit. return the default.
            return 150.0;
        }
    }

    public ArrayList<String> getFoods(String date) {
        return getLogFromDateString(date).getFoods();
    }
    
     

    public ArrayList<Double> getFoodServings(String date) {
        return getLogFromDateString(date).getFoodServings();
    }

    public ArrayList<String> getExercises(String date) {
        return getLogFromDateString(date).getExercises();
    }

    public ArrayList<Double> getMinutesExercised(String date) {
        return getLogFromDateString(date).getMinutesExercised();
    }

    /**
     *Give a string of all of the foods and servings of each food eaten on a day.
     * @param date - formated as month+"-"+day+"-"+year
     * @return String listing foods and servings.
     */
    public String getFoodsConsumed(String date){
        return getLogFromDateString(date).getFoodsConsumed();
    }

    /**
     * If you need only one food you can call this method to find out the servings of that foods for this day.
     * @param date - formated as month+"-"+day+"-"+year
     * @param foodName - the name of the food you want the servings consumed of. Must match spelling and case.
     * @return a int of the number of portions consumed of this food.
     */
    public double getAFoodsPortion(String date, String foodName){
        return getLogFromDateString(date).getAFoodsPortion(foodName);
    }


    /**
     * gets the log object from a date string. Used only in LogHub to find the specific log the user is after.
     * @param _dateString - formated as month+"-"+day+"-"+year
     * @return a Log object
     */
    private Log getLogFromDateString(String _dateString){
    System.out.println("Currently " + logsList.size() + " Log objects exist.");
        for(Log existingLog:logsList){
            //System.out.println(existingLog.getDateString());
            if (existingLog.getDateString().equals(_dateString)){
                return existingLog;
            }
        }
        System.out.println("date string entered = " + _dateString);
        System.out.println("Error in finding a existing log from dateString. No log exists");
        return null; //unsafe needs to be handled
    }

    /**
     * Checks if a log matching that date exists.
     * @param _dateString - formated as month+"-"+day+"-"+year
     * @return boolean ture if a log for that day exists. false if not.
     */
    public boolean checkIfLogExists(String _dateString){
        for(Log existingLogs:logsList){
            if (existingLogs.getDateString().equals(_dateString)){
                return true; //the log exists
            }
        }
        return false; //there is no log for that day
    }

    /**
     * Will collect all of the data from our array of Log Objects and parse them into the format CSVParse expects.
     * Then send it to CSVParser to write it to our file.
     */
    public void writeOutToCSV(){
        ArrayList<String> tempArray = new ArrayList<String>();
        //get an formated arraylist from all the logs
        for(int i = 0; i < logsList.size(); i++){
            tempArray.add(logsList.get(i).writeOutCSVString());
        }
        CSVParser parser = new CSVParser();
        parser.writeCSV(tempArray, logFile);
    }


} // LogHub

