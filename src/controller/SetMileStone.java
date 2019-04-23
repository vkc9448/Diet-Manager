/*
* Diet Manager v1.0
* Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
* SWEN.383.01
*/

/***
* Listener Class for creating an object which will be added to the log & food collection
*/

package controller;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//import model.Food;
//import model.Write;
//import javax.swing.*;
import model.DietManager;


public class SetMileStone {
      private double calorieGoal;
      
      
      private int year;
      private int month;
      private int day;
      private String dateString;
   

      // add private JTextField for foods desc (calorie, fat, etc...)
      //private Food food;
      //private Write write;
      //private String name;
      //private double calorie
      //private double fats
      //private double carbs

      
      public void SetMileStone(int _year, int _month, int _day, double cal)
      {  dateString=Integer.toString(_month)+"-"+Integer.toString(_day)+"-"+Integer.toString(_year);
         DietManager dm= new DietManager();
         dm.setMileStone(dateString,cal);
      }
     // SetMileStone   
} // SetMileStone
