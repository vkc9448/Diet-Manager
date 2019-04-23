/*
 * Diet Manager v1.0
 * Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
 * SWEN.383.01
 *
 *The ExerciseHub class will work with exercise csv files to
 * retrive and delete data at the prompt of DietManager
 */
package model;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ExerciseHub{
    ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();
    String eFile = "exercise.csv";

    /**
     *readCSV() calls the CSV parser and retrives a ArrayList of ArrayLists and then parses
     */
    public boolean readCSV(){
        CSVParser parser = new CSVParser();
        ArrayList<ArrayList<String>> tempList = parser.parseCSV(eFile);
        for(ArrayList<String> exercise:tempList){
            for(Exercise existingExercise:exercisesList){
                if (existingExercise.getName() == exercise.get(1)){
                    //a exercise for this date already exists, this shouldnt happen.
                    System.out.println("Error: Exercise already exists, possible duplicate entry in csv.");
                } else{
                    //a exercise for this date does not yet exist.
                    Exercise e = new Exercise(exercise);
                    exercisesList.add(e);
                }
            }
        }//end of parse csv
        return true;
    }

    public void addExercise(String name, double calories){
        Exercise e = new Exercise(name,calories);
        exercisesList.add(e);
    }

    /**
     *remove exercise accepts a string of MM-DD-YYYY finds a corrasponding exercise and deletes it
     *@param A string of date in MM-DD-YYYY identifying the exercise to be deleted.
     *@return true if exercise was found a removed. False if no exercise was found for date.
     */
    public boolean removeExercise(String exerciseName){
        for(int i = 0; i< exercisesList.size(); i++){
            if (exercisesList.get(i).getExercise() == exerciseName){
                exercisesList.remove(i);
                return true;
            }
        }
        return false;
    }

    public void setCaloriesForExercise(String name, double cal){
        for(int i = 0; i < exercisesList.size();i++){
            if (exercisesList.get(i).getName() == name){
                exercisesList.get(i).setCaloriesBurned(cal);
            }
        }
    }

    public void writeOutToCSV(){
        //get an formated arraylist from all the exercises
        ArrayList<String> tempArray = new ArrayList<String>();
        for(int i = 0; i< exercisesList.size(); i++){
            tempArray.add(exercisesList.get(i).writeOutCSVString());
        }
        CSVParser parser = new CSVParser();
        parser.writeCSV(tempArray, eFile);
    }
    
   


} // ExerciseHub

