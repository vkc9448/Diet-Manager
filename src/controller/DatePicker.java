/*
* Diet Manager v2.0
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
import View.*;
import java.awt.*;
import javax.swing.*;


public class DatePicker extends JFrame{
      // add private JTextField for foods desc (calorie, fat, etc...)
      //private Food food;
      //private Write write;
      //private String name;
      //private double calorie
      //private double fats
      //private double carbs

      double weight;
      private DietManager dm;
      double calLimit;
      double totalCal;
      
    /**
     * DatePicker searches the log using the date picked by the user
     * @param weight - add the weight for this date
     * @param calLimit - add the calorie limit of this date
     * @param totalCal - add the total calorie of this date
     */
      
      public DatePicker(String date,JLabel jl1,JLabel jl2,JLabel jl3,JLabel jl4,JLabel jl5,JLabel jl6,JLabel jl7,JLabel jl8)
      {  dm = new DietManager();
         //dm.setDate();
         weight=dm.addWeight(date);
         jl1.setText(Double.toString(weight));
         calLimit=dm.getMileStone(date);
         jl2.setText(Double.toString(calLimit));
         totalCal=dm.getTotalDatesCalories(date);
         System.out.println(totalCal);
         jl6.setText(Double.toString(totalCal));
         //System.out.println(totalCal);
      }
      
      
      
      
      
     } // AddFood
