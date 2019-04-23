/*
* Diet Manager v1.0
* Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
* SWEN.383.01
*/

/***
* Listener Class for creating an object which will be added to the log & food collection
*/
package model;

public class AddFood{
       DietManager dm= new DietManager();
       String f;
      
      public AddFood()
      {
        
         f=dm.addFood();
         
      }
      
      public String returnFood()
      {
      System.out.println("Food is here"); //testing
      return f;
      }
      
      
      
     } // AddFood
